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

public class Signuppane implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
    @FXML
    private TextField txtid;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private Button btnsignup;

    @FXML
    private Button btnback;

    @FXML
    private Label lblconfirm;

    @FXML
    private PasswordField txtpasswordconfirm;

    @FXML
    private PasswordField txtemail;

    @FXML
    private PasswordField txtaddress;

    @FXML
    void back(ActionEvent event) {
    	System.out.println("�ڷΰ���");
    	Login.get���ΰ�ü().loadpage("/view/login/loginpane.fxml");
    }

    @FXML
    void signup(ActionEvent event) {

    }
	
	
	
}
