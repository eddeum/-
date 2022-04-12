package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import dto.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Findpasswordpane implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
	}
	
    @FXML
    private TextField txtemail;

    @FXML
    private Button btnfindpassword;

    @FXML
    private Button btnback;

    @FXML
    private Label lblconfirm;

    @FXML
    private TextField txtid;

    @FXML
    void back(ActionEvent event) {
    	System.out.println("비밀번호찾기에서 뒤로가기버튼 클릭");
    	Login.get본인객체().loadpage("/view/login/loginpane.fxml");
    }

    @FXML
    void findpassword(ActionEvent event) {
    	// 1. 컨트롤에 입력된 데이터 가져오기
    	String id = txtid.getText();
    	String email = txtemail.getText();
    	// 2. db 메소드 호출
    	String password = MemberDao.memberDao.findpassword(id, email);
    	// 3. 확인
    	if(password != null) {
    		
    		// 이메일 전송 메소드 호출
    		Member.sendmail(email, password); // 수정해야될부분
    		
    		
    		// 메시지
    		Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setHeaderText("해당 이메일로 비밀번호를 전송했습니다");
    		alert.showAndWait();
    	}else {
    		lblconfirm.setText("해당 이메일의 아이디 정보가 없습니다.");
    	} // else e
    }
	
}
