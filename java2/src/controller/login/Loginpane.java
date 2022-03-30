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
    	System.out.println("아이디찾기 페이지로 이동");
    	Login.get본인객체().loadpage("/view/login/findid.fxml");
    }

    @FXML
    void accfindpassword(ActionEvent event) {
    	System.out.println("패스워드찾기 페이지로 이동");
    	Login.get본인객체().loadpage("/view/login/findpassword.fxml");
    }

    @FXML
    void accsignup(ActionEvent event) {
    	System.out.println("회원가입 페이지로 이동");
    	// * 회원가입 버튼을 누르면 login컨트롤클래스 내 borderpane 컨테이너 center 페이지 변경
    	// 문제 : 다른 클래스내 컨테이너 호출해야함..!
    	//	Login login = new Login(); -> 새로운 컨테이너 생성은 X
    	//	login.loadpage("/view/signuppane.fxml"); -> X
    	// 해결방안 : 기존 컨테이너 가져오는 방법 -> this
    	
    	// login 컨트롤에 존재하는 borderpane 객체내 센터 변경
    		// * 문제 : borderpane 객체가 다른 컨트롤에 있다.
    		// * new : 새로운 메모리 할당[기존 borderpane이 아닌 새로운 borderpane 생성]
    		// * 기존 login클래스에서 사용중인 borderpane;
    	Login.get본인객체().loadpage("/view/login/signuppane.fxml");
    	
    }

    @FXML
    void login(ActionEvent event) {
    	
    	String id = txtid.getText(); // 해당 fxid에 입력된 값 가져오기
    	String password = txtpassword.getText(); // 해당 fxpassword에 입력된 값 가져오기

    	if(id.equals("admin") && password.equals("1234")) {
    		lblconfirm.setText("관라자 이군요");
    	}else {
    		lblconfirm.setText("일반 회원 이군요");
    	}
    	
    	System.out.println("로그인 페이지로 이동");
    }

	
	
	
}
