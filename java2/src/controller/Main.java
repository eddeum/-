package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class Main implements Initializable {
				// Initializable : view가 새로 열렸을때 초기값 설정하는 메소드 제공
	
	public static Main instance;
	public Main() {
		instance = this;
	}
	
	
    @FXML
    private BorderPane borderpane; // 씬빌더에서 만든 컨테이너 객체(fx:id)
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Main 뷰가 실행(view <---> controller) 되었습니다.");
		 
		loadpage("/view/login/login.fxml"); // loadpage 메소드 호출시(파일경로 = 패키지명/파일명)
	}
	
	public void loadpage(String page) { // loadpage(파일경로)
		try {
		// 페이지(fxml) 객체화
		Parent parent = FXMLLoader.load(getClass().getResource(page)); // 무조건 예외처리 발생
		borderpane.setCenter(parent); // main.fxml에 존재하는 borderpane객체내 center을 해당 파일로 경로
		}catch(Exception e) {System.out.println("페이지 연결 실패 이유 : " +e);} // 만약에 파일이 존재하지 않으면 예외 발생
	}
	
	
}
