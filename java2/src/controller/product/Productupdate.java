package controller.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import controller.home.Home;
import dao.ProductDao;
import dto.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class Productupdate implements Initializable {

	 @FXML
	    private Button btnupdate;

	    @FXML
	    private TextField txtpname;

	    @FXML
	    private TextField txtpcontent;

	    @FXML
	    private Button btnimg;

	    @FXML
	    private TextField txtpprice;

	    @FXML
	    private RadioButton opt1;

	    @FXML
	    private ToggleGroup category;

	    @FXML
	    private RadioButton opt2;

	    @FXML
	    private RadioButton opt3;

	    @FXML
	    private RadioButton opt4;

	    @FXML
	    private ImageView img;

	    @FXML
	    private Button btnback;

	    @FXML
	    private Label txtpath;

	    @FXML
	    void back(ActionEvent event) {
	    	Home.home.loadpage("/view/product/productview.fxml");
	    }
	    
	    private String pimage = null; 
	    
	    @FXML
	    void imgadd(ActionEvent event) {
	    	// 1. 파일 선택 클래스(javafx에서만 사용)
	    	FileChooser fileChooser = new FileChooser();
	    	
	    	// 2. 파일 선택[필터] 형식
	    		fileChooser.getExtensionFilters().add(new ExtensionFilter("이미지파일:image file", "*png", "*jpeg", "*jpg", "*gif") );
	    	
	    	// 3. 새로운 stage(윈도우창)에서 파일선택 화면 실행
	    	File file =  fileChooser.showOpenDialog(new Stage());
	    		// 파일선택객체.showOpenDialog(스테이지);
	    		// fileChooser 화면에서 선택된 파일을 file 클래스객체화
	    	
	    	// 4. 선택한 파일의 경로
	    	txtpath.setText("파일 경로 : " + file.getPath());
	    	
	    	// 5. 파일경로
	    	pimage = file.toURI().toString();
	    	
//	    		System.out.println(file.getPath()); 			// 경로구분선 : \
//	    		System.out.println(file.toURI());				// 경로구분선 : /
//	    		System.out.println(file.toURI().toString());	// 문자열로 변환
	    	
	    	// 6. 미리보기 이미지컨트롤에 띄우기
	    	Image image = new Image(pimage); // 해당 이미지의 경로값이 / 구분되어 있어야함
	    	img.setImage(image); // ImageView에 해당 이미지 넣어주기
	    	
	    	// * 선택된 파일을 현재 프로젝트 폴더로 복사(이동)해오기
	    	try {
		    	// 1. 파일 입력 스트림[이동 단위 : 바이트]
		    	FileInputStream inputStream = new FileInputStream(file); // file : fileChooser에서 선택된 파일 객체
		    	// 2. 파일 출력 스트림
		    		// 1. 새로운 경로 설정
		    	File copyfile = new File("C:/Users/504/git/java/java2/src/img/" + file.getName() );
		    	FileOutputStream outputStream = new FileOutputStream(copyfile);
		    	// 3. 바이트 배열 선언
		    	byte[] bytes = new byte[1024*1024*1024]; // 1바이트 -> 1024바이트 -> 1키로바이트 -> 1024키로바이트 -> 1메가바이트
		    	// 4. 반복문을 이용한 inputStream의 파일 스트림 모두 읽어오기
		    	int size;
		    	while((size = inputStream.read(bytes))>0) { // 읽어온 바이트가 0보다 작으면 반복문 종료[읽어올 바이트
		    		outputStream.write(bytes, 0, size); // 읽어온 바이트만큼 내보내기
		    	} // while e
		    	// 5. 용량이 큰 경우에는 스트림 종료 필수!!!
		    	inputStream.close();
		    	outputStream.close();
		    	// * 복사된 파일의 경로를 db에 저장
		    	pimage = copyfile.toURI().toString();
	    	}catch(Exception e) {System.out.println(e);}
	    }

	    @FXML
	    void update(ActionEvent event) {
	    	
	    	if(pimage == null) { // 사진 수정이 없으면
	    		pimage = Productcontrol.select.getPimg(); // 기존 사진 경로를 사용
	    	} // if e
	    	String pcategory = null;
	    	if(opt1.isSelected()) pcategory = "남성의류";
	    	if(opt2.isSelected()) pcategory = "여성의류";
	    	if(opt3.isSelected()) pcategory = "게임기기";
	    	if(opt4.isSelected()) pcategory = "생활용품";
	    	Product upproduct = new Product(
	    			Productcontrol.select.getPnum(), 
	    			txtpname.getText(), 
	    			pimage, 
	    			txtpcontent.getText(), 
	    			pcategory, 
	    			Integer.parseInt(txtpprice.getText() ), 
	    			0, 
	    			null, 
	    			0);
	    	
	    	boolean result = ProductDao.productDao.update(upproduct);
	    	if(result) {
	    		Alert alert = new Alert(AlertType.INFORMATION);
	    			alert.setHeaderText("제품 수정 성공");
	    		alert.showAndWait();
	    		Home.home.loadpage("/view/product/product.fxml");
	    	}else {
	    		Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setHeaderText("제품 수정 실패[관리자에게 문의]");
    		alert.showAndWait();
	    	} // else e
	    }
	

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Product product = Productcontrol.select;
		txtpname.setText(product.getPname());
		txtpcontent.setText(product.getPcontent());
		txtpprice.setText(product.getPprice()+"");
		txtpath.setText(product.getPimg());
		if(product.getPcategory().equals("남성의류")) {opt1.setSelected(true);}
		if(product.getPcategory().equals("여성의류")) {opt2.setSelected(true);}
		if(product.getPcategory().equals("게임기기")) {opt3.setSelected(true);}
		if(product.getPcategory().equals("생활용품")) {opt4.setSelected(true);}
	}
	
}
