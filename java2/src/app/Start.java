package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Start extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		// 5. �����̳� �ҷ�����
		Parent parent = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
																// ��Ű����(����)/���ϸ�.Ȯ����
		// 6. �� ��ü -> �����̳�
		Scene scene = new Scene(parent);
		// 7. �� -> ��������
		stage.setScene(scene);
		// 3. �������� �ΰ� ����
			Image image = new Image("/img/stagelogo.jpeg"); // 1. �̹��� �ҷ�����[�̹��� ��üȭ]
				// ������ vs �����
				// ������ : ��� ���
					// C:\Users\504\git\java\java2\src\img
				// ����� : �� ��ġ[������Ʈ src] ���� ���
					// ����[src��������] /img/���ϸ�.Ȯ���� 
			
		stage.getIcons().add(image); // 3. �������� ������ ���� 
		
		// * �ܺ���Ʈ ����
			// 1. ��Ʈ �ε�
			Font.loadFont(getClass().getResourceAsStream("SANGJU Gotgam.ttf"), 14); // �ش� ��Ʈ�� ��ǻ�� �̸��� ��Ȯ���� �ʾ� �ȵǴ°� ���ƿ�... �ٸ� ��Ʈ�� �Ǵϱ�... �غ��ð� ���� �� ��Ʈ�� ��ǻ���̸��� Ȯ���ؔF�Կ�~~��
			// 2. ���� scene�� �ܺ� ��Ÿ�Ͻ�Ʈ ����
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
		stage.setResizable(false);	// 4. �������� ũ�� ���� �Ұ�
		stage.setTitle("��������"); // 2. �������� â �̸�
		stage.show(); // 1. �������� ����
	}
	public static void main(String[] args) {
		launch(args);
	}
}
