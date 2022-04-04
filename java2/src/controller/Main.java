package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class Main implements Initializable {
				// Initializable : view�� ���� �������� �ʱⰪ �����ϴ� �޼ҵ� ����
	
	public static Main instance;
	public Main() {
		instance = this;
	}
	
	
    @FXML
    private BorderPane borderpane; // ���������� ���� �����̳� ��ü(fx:id)
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Main �䰡 ����(view <---> controller) �Ǿ����ϴ�.");
		 
		loadpage("/view/login/login.fxml"); // loadpage �޼ҵ� ȣ���(���ϰ�� = ��Ű����/���ϸ�)
	}
	
	public void loadpage(String page) { // loadpage(���ϰ��)
		try {
		// ������(fxml) ��üȭ
		Parent parent = FXMLLoader.load(getClass().getResource(page)); // ������ ����ó�� �߻�
		borderpane.setCenter(parent); // main.fxml�� �����ϴ� borderpane��ü�� center�� �ش� ���Ϸ� ���
		}catch(Exception e) {System.out.println("������ ���� ���� ���� : " +e);} // ���࿡ ������ �������� ������ ���� �߻�
	}
	
	
}
