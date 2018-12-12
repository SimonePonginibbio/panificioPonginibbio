package it.gov.itisfeltrinelli.panifici;
	
import it.gov.itisfeltrinelli.panifici.model.DAO_Panifici;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private String url = "jdbc:mysql://127.0.0.1:3306/panifici";
	private String user = "root";
	private String password = "";
	
	@Override
	public void start(Stage primaryStage) {
		try {
			DAO_Panifici database = new DAO_Panifici(url, user, password);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Panifici.fxml"));
			BorderPane root = loader.load();
			PanificiController controller = loader.getController();
			controller.setDatabase(database);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
