package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Loginpane implements Initializable {
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
    @FXML
    private TextField txtid;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private Button btnlogin;

    @FXML
    private Button btnsignup;

    @FXML
    private Button btnfindid;

    @FXML
    private Button btnfindpassword;

    @FXML
    private Label lblconfirm;

    @FXML
    void accfindid(ActionEvent event) {
    	System.out.println("���̵�ã�� �������� �̵�");
    	Login.get���ΰ�ü().loadpage("/view/login/findid.fxml");
    }

    @FXML
    void accfindpassword(ActionEvent event) {
    	System.out.println("�н�����ã�� �������� �̵�");
    	Login.get���ΰ�ü().loadpage("/view/login/findpassword.fxml");
    }

    @FXML
    void accsignup(ActionEvent event) {
    	System.out.println("ȸ������ �������� �̵�");
    	// * ȸ������ ��ư�� ������ login��Ʈ��Ŭ���� �� borderpane �����̳� center ������ ����
    	// ���� : �ٸ� Ŭ������ �����̳� ȣ���ؾ���..!
    	//	Login login = new Login(); -> ���ο� �����̳� ������ X
    	//	login.loadpage("/view/signuppane.fxml"); -> X
    	// �ذ��� : ���� �����̳� �������� ��� -> this
    	
    	// login ��Ʈ�ѿ� �����ϴ� borderpane ��ü�� ���� ����
    		// * ���� : borderpane ��ü�� �ٸ� ��Ʈ�ѿ� �ִ�.
    		// * new : ���ο� �޸� �Ҵ�[���� borderpane�� �ƴ� ���ο� borderpane ����]
    		// * ���� loginŬ�������� ������� borderpane;
    	Login.get���ΰ�ü().loadpage("/view/login/signuppane.fxml");
    	
    }

    @FXML
    void login(ActionEvent event) {
    	
    	String id = txtid.getText(); // �ش� fxid�� �Էµ� �� ��������
    	String password = txtpassword.getText(); // �ش� fxpassword�� �Էµ� �� ��������

    	if(id.equals("admin") && password.equals("1234")) {
    		lblconfirm.setText("������ �̱���");
    	}else {
    		lblconfirm.setText("�Ϲ� ȸ�� �̱���");
    	}
    	
    	System.out.println("�α��� �������� �̵�");
    }

	
	
	
}
