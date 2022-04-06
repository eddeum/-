package controller.product;

//import java.awt.ScrollPane; // 임포트가 awt 로 되어 있어서 안되는것 같아요 감사합니다..
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.home.Home;
import dao.ProductDao;
import dto.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Productcontrol implements Initializable{
	
    @FXML
    private Button btnadd;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private VBox vbox;

    @FXML
    void accadd(ActionEvent event) {
    	Home.home.loadpage("/view/product/productadd.fxml");
    }
    
    public static Product select; // 선택된 버튼의 제품 저장
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	// 1. 모든 제품 가져오기
    	ArrayList<Product> productlist = ProductDao.productDao.list();
//    	System.out.println("확인 : "+ productlist.toString()); // 확인용
    	
    	// 2. 그리드 클래스[행/열]
    	GridPane gridPane = new GridPane();
    		// * 그리드간 여백
    		gridPane.setPadding(new Insets(10) );
    		// * 버튼들 간 여백
    		gridPane.setHgap(20);
    		gridPane.setVgap(20);
    	// 3. 반복문
    	int i = 0; // 인덱스용 변수
    	for(int row = 0; row < productlist.size()/3; row++) { // 행
    		for(int col = 0; col<3; col++) { // 열
    			
    			// 1. 이미지
    			ImageView imageView = new ImageView(new Image(productlist.get(i).getPimg() ) );
    				imageView.setFitWidth(250);	// 이미지 가로길이
    				imageView.setFitHeight(200);// 이미지 세로길이
    			// 2.버튼 생성(버튼에 이미지 넣기)
    			Button button = new Button(null, imageView);
    				// * 버튼 배경제거[transparent : 투명색]
    				button.setStyle("-fx-background-color : transparent");
    				// * 버튼 id값넣기[제품 식별 = index]
    				button.setId(i+"");
    				// * 버튼 클릭이벤트
    					// button.setOnAction(e->{}); // 람다식 : 인수 -> {실행코드}
    				button.setOnAction(e -> {
    					// 1. 클릭한 버튼의 id 가져오기
    					int id = Integer.parseInt( e.toString().split(",")[0].split("=")[2] );
    					// 2. 클릭한 제품 번호 저장
    					select = productlist.get(id);
    					// 3. 화면전환
    					Home.home.loadpage("/view/product/productview.fxml");
    				});
    				
    			gridPane.add(button, col, row); // 해당 열번호, 행번호에 버튼 추가
    			i++; // 인덱스 증가
    		} // for e
    	} // for e
    	// * 3배수의 나머지 값
    	int row = productlist.size() / 3; //행
    	int remain = productlist.size() % 3;
    	if(remain != 0) { // 나머지가 존재하면
    		for(int col = 0; col<remain; col++) { // 열 // 3 대신에 나머지값을 넣어주셔야 해요 // 나머지값 까지 반복ㅁ누 실행
    			ImageView imageView = new ImageView(new Image(productlist.get(i).getPimg() ) );
    				imageView.setFitWidth(250);	// 이미지 가로길이
    				imageView.setFitHeight(200);// 이미지 세로길이
    			Button button = new Button(null, imageView);
    				button.setStyle("-fx-background-color : transparent");
    				button.setId(i+"");
    				button.setOnAction(e -> {
    					int id = Integer.parseInt( e.toString().split(",")[0].split("=")[2] );
    					select = productlist.get(id);
    					Home.home.loadpage("/view/product/productview.fxml");
    				});
        			gridPane.add(button, col, row+1); // 마지막행에 나머지 값 만큼 버튼 추가해서 그리드에 추가
        			i++; // 인덱스 증가
        		} // for e
    	} // if e
    	
    	// 4. 
    	vbox.getChildren().add(gridPane);
    }

} // ce
