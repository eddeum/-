package controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Server { // fxml ������� �ʴ� Ŭ����[���� ��Ʈ�� ���]
	
	// ��øŬ����[Ŭ���� �ȿ� Ŭ������ ���� : Client]
	public class Client {// ������ ���ӵ� Ŭ���̾�Ʈ�� Ŭ����
		// 1. �ʵ�[ ���� ]
		public Socket socket;
		// 2. ������
		public Client(Socket socket) {
			this.socket = socket;
			recive(); // ������ ����� Ŭ���̾�Ʈ ��ü�� �����ɶ� �ޱ� �޼ҵ�(���ѷ���)
		} // ������ e
		
		// 3. ������ �޽��� �޴� �޼ҵ�[�������� : ������ Ŭ���̾�Ʈ�� ����Ǿ�����] 
		public void recive() { 
			// ��Ƽ������[Thread Ŭ���� / Runnable �������̽�]
				// run �޼ҵ带 �ʼ������� �����ؾ���.
			// �������̽��� �߻�޼ҵ尡 �����ϱ� ������ �����ʼ�[Ŭ�������� implements �ϰų� �͸�ü]
			Runnable runnable = new Runnable() { // �͸� ������ü
				@Override
				public void run() { // �߻�޼ҵ� ����
					// ��������� �޽��� �޴� ���
					try {
						while(true) {
							InputStream inputStream = socket.getInputStream(); // 1. �Է� ��Ʈ��
							byte[] bytes = new byte[1000]; 	// 2. ����Ʈ �迭 ����[��Ʈ���� ����Ʈ ����]
							inputStream.read(bytes); 		// 3. �Է½�Ʈ������ ����Ʈ �о����
							String msg = new String(bytes); // 4. ����Ʈ�� -> ���ڿ� ��ȯ
							// * ������ ���� �޽����� ���� ������ ���ӵ� ��� Ŭ���̾�Ʈ���� ���� �޽��� ������
							for(Client client :  clientlist) {
								client.send(msg); // ���� �޽����� ������ ���ӵ�[clientlist] ��� Ŭ���̾�Ʈ���� 
							} // for e
						} // while e
					}catch(Exception e) {}
				}
			}; // ��Ƽ������ ���� ��
			
			// �ش� ��Ƽ�����带 ������Ǯ�� �־��ֱ�
			threadpool.submit(runnable);
			
		} // recive e
		
		// 4. ������ �޽��� ������ �޼ҵ�[�������� : ������ �޽����� �޾�����]
		public void send(String msg) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						OutputStream outputStream = socket.getOutputStream(); // 1. ��½�Ʈ��
						outputStream.write(msg.getBytes()); // 2. ��������
					}catch(Exception e) {}
					
				}
			}; // ��Ƽ������ ���� ��
			threadpool.submit(runnable);
		} // send e
				
	} // ��øŬ���� end

	
	
    
    // * ������ ����� Ŭ���̾�Ʈ�� �����ϴ� ����Ʈ
    public Vector<Client> clientlist = new Vector<>();
    			// Vector ����ϴ� ���� : ����ȭ ����(O)	-> ����ȭ : ���� �����尡 �ϳ��� �޼ҵ忡 ������ ��� ��� ���� �����
    // * ��Ƽ�����带 �������ִ� ������Ǯ
    public ExecutorService threadpool;
    	// ExecutorService : ������Ǯ ���� �������̽�[����Ŭ����(implements) or ��������(�͸�ü) �ؾ���]
    
    // 1. �������� ����
    ServerSocket serverSocket;
    // 2. �������� �޼ҵ�[�μ��� ip�� port �޾Ƽ� ���� ip�� port�� �������� ���ε�(����)]
    public void serverstart(String ip, int port) { 
    	try {
	    	// 1. �������� �޸��Ҵ�
	    	serverSocket = new ServerSocket();
	    	// 2. �������� ���ε�[ip�� port ����]
	    	serverSocket.bind(new InetSocketAddress(ip, port));
    	}catch(Exception e) {}
    		// 3. Ŭ���̾�Ʈ�� ��û ���[��Ƽ������ ����ϴ����� : Ŭ���̾�Ʈ 1.����, 2.������, 3.�ޱ� ����ó��]
    	Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				try {
					while(true) {
						Socket socket = serverSocket.accept(); // 1. ��û �����Ŀ� ��ȯ�� ������ ����
						clientlist.add(new Client(socket) ); // 2. ����� Ŭ���̾�Ʈ(����ȼ���) �����Ŀ� ����Ʈ�� ����
					} // while e
				}catch(Exception e) {}
			}
		}; // ��Ƽ������ ���� ��
		
		threadpool = Executors.newCachedThreadPool(); // ������Ǯ�� �޸� �ʱ�ȭ[�Ҵ�]
		threadpool.submit(runnable); // ������ ������ ��Ƽ�����带 ������Ǯ�� �־��ֱ�
    } // �������� e
    // 3. �������� �޼ҵ�
    public void serverstop() {
    	try {
	    	// 1. ���ӵ� ��� Ŭ���̾�Ʈ���� ���� �ݱ�
	    	for(Client client : clientlist) {
	    		client.socket.close();
	    	}
	    	// 2. �������� �ݱ�
	    	serverSocket.close();
	    	// 3. ������Ǯ �ݱ�
	    	threadpool.shutdown();
    	}catch(Exception e) {System.out.println("�������� ���� : "+e);}
    } // �������� e
    
    


}
