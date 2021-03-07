package gobblets;
import java.io.IOException;

import gobblets.graphique.Controleur;
import gobblets.ihm.IHM;
import gobblets.ihm.Menu;
import gobblets.logic.Jeu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Gobblets extends Application{
	
	public static void main(String[] args) {
	        launch(args);
	}

	public void start(Stage stage) throws IOException {
		AnchorPane ap;
		stage.setTitle("Gobblets");
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Gobblets.class.getResource("graphique/Menu.fxml"));
		
		ap = loader.load(); 
	    
		Scene scene = new Scene(ap);
		stage.setScene(scene);
        stage.show();
	}
}
