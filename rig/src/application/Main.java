package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	public static ChoiceBox<String> colorSelector;
	@Override
	public void start(Stage primaryStage) {
		try {			
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			
			Scene scene = new Scene(root,400,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
			Image background = new Image("file:..\\..\\iconImages\\sunnyIcon.png");
			ImagePattern pattern = new ImagePattern(background);
			scene.setFill(pattern);	
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}
