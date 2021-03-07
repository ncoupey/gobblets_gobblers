package gobblets.graphique;

import java.io.File;
import java.io.IOException;

import gobblets.Gobblets;
import gobblets.ihm.IHM;
import gobblets.ihm.Menu;
import gobblets.logic.Jeu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControleurMenuPrincipal {
	
    @FXML
    private Button nouvellePartie;
    
    
	public void menuAPropos(ActionEvent e) {
		Alerte.inform(IHM.menu(Menu.MENU_TITRE_APROPOS), IHM.menu(Menu.MENU_APROPOS));
	}
	public void menuRegles(ActionEvent e) {
		Alerte.inform(IHM.menu(Menu.MENU_TITRE_REGLES), IHM.menu(Menu.MENU_AIDE));
	}

	public void menuNouveau(ActionEvent e) throws IOException {
		
		Stage playerStage = new Stage();
		AnchorPane ap;
		FXMLLoader charge = new FXMLLoader();
		charge.setLocation(Gobblets.class.getResource("graphique/J1.fxml"));
		
		ap = charge.load();
		Scene choixJ1 = new Scene(ap);
		playerStage.setScene(choixJ1);
		playerStage.initModality(Modality.APPLICATION_MODAL);
		playerStage.showAndWait();
		ControleurJoueurs playerControl = charge.<ControleurJoueurs>getController();
		
		if(playerControl.getJoueurs()[0] != null) {
		Stage mainMenu = (Stage) nouvellePartie.getScene().getWindow();
		mainMenu.close();
		
		Stage stage = new Stage();
		BorderPane bp = new BorderPane();
		Jeu jeu = new Jeu(playerControl.getJoueurs()[0], playerControl.getJoueurs()[1]);
		stage.setTitle("Gobblets");
		FXMLLoader loader = new FXMLLoader(Gobblets.class.getResource("graphique/Sample.fxml"));
		bp = loader.load(); 
		Controleur controller = loader.<Controleur>getController();
		controller.setGame(playerControl.getJoueurs(), jeu);
		
	    
		Scene scene = new Scene(bp);
		stage.setScene(scene);
        stage.show();
		}
	}
	public void menuQuitter(ActionEvent e) {
		System.exit(0);
	}
	public void menuCharger(ActionEvent e) {
		FileChooser myFile = new FileChooser();
		File file = myFile.showOpenDialog(null);
	}
}
