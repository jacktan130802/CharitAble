
/*
 *	jie134 - Ryan Gill
 *	CS-3443-003
 *	Dr. Rathore
 */
package application.Main;
	
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import model.*;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {

		try {
			//Model.initInventory(); //(uncomment to initialize inventory if none exists) change more
			Stage window = primaryStage;
			window.setTitle("p1920709 Jack Tan Xin Jie");
			window.setResizable(false);
			Inventory.loadFiles();    //loads the saved data.properties file
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root,600,600);
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
