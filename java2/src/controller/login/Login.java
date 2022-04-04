package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import dto.Member;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Login implements Initializable {
	
	// * 해당 클래스의 메모리를 반환해주는 메소드
		// 1. 현재 클래스로 객체선언
	public static Login 본인객체;
		// 2. 생성자에서 객체내 this 넣어주기
			// this : 현재클래스의 메모리[새로운 메모리할당 x]
	public Login() {
		본인객체 = this; // super : 슈퍼클래스(상속) this : 현 클래스
		// this : 현재클래스 자체 메모리 호출
	}
		// 3. 외부에서 호출할 수 있는 메소드 생성(메소드 안만들어도됨)
	public static Login get본인객체() {
		return 본인객체;
	}
	
	// line 17~26 : Loginpane controller에서 회원가입페이지로 이동하기위함..
	
	
	// * 로그인 성공한 회원객체
	public static Member member;
	
	
	

    @FXML
    private MediaView mediaview;
    
    @FXML
    private BorderPane borderpane;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// 1. 동영상 삽입하기
			// 1. 동영상파일 객체화
		Media media = new Media(getClass().getResource("/img/login.mp4").toString());
			// 2. 미디어플레이어 객체에 동영상 넣기
		MediaPlayer mediaPlayer = new MediaPlayer(media);
			// 3. 미디어뷰에 미디어플레이어 넣기
		mediaview.setMediaPlayer(mediaPlayer);
			// 4. 미디어플레이어 시작
		mediaPlayer.play();
		
		loadpage("/view/login/loginpane.fxml");
	}
	
	public void loadpage(String page) {
		try {
		Parent parent = FXMLLoader.load(getClass().getResource(page));
		borderpane.setCenter(parent);
		}catch(Exception e) {System.out.println("해당 파일이 없습니다."+e);}
	}
	
	
	
}
