package gobblets.graphique;

import java.io.IOException;

import gobblets.Gobblets;
import gobblets.data.Etat;
import gobblets.data.Joueur;
import gobblets.logic.Jeu;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ControleurFin {
	
	private Stage oldStage;
	private Joueur j1;
	private Joueur j2;
    @FXML
    private Label gagnant;
	
	public void retourMenu() throws IOException {
		
		Stage stage = new Stage();
		Stage currentWindow = (Stage) gagnant.getScene().getWindow();
		AnchorPane ap;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Gobblets.class.getResource("graphique/Menu.fxml"));
		
		ap = loader.load(); 
	    
		Scene scene = new Scene(ap);
		stage.setScene(scene);
		currentWindow.close();
		oldStage.close();
        stage.show();
	}
	
	public void rejouer() throws IOException {
		Stage stage = new Stage();
		Stage currentWindow = (Stage) gagnant.getScene().getWindow();
		BorderPane bp = new BorderPane();
		Jeu jeu = new Jeu(j1, j2);
		stage.setTitle("Gobblets");
		FXMLLoader loader = new FXMLLoader(Gobblets.class.getResource("graphique/Sample.fxml"));
		bp = loader.load(); 
		Controleur controller = loader.<Controleur>getController();
		Joueur[] tabJoueur = {j1, j2};
		controller.setGame(tabJoueur, jeu);
	    
		Scene scene = new Scene(bp);
		stage.setScene(scene);
		currentWindow.close();
		oldStage.close();
        stage.show();
	}
	
	public void quitter() {
		Stage currentWindow = (Stage) gagnant.getScene().getWindow();
		currentWindow.close();
		oldStage.close();
	}
	
	public void tranfert(Joueur j1, Joueur j2, Etat etat, Stage oldStage) {
		this.oldStage = oldStage;
		this.j1 = j1;
		this.j2 = j2;
		if(etat == Etat.JOUEUR1GAGNE) {
			gagnant.setText(j1.getNom()+" a gagné !");
			
		}else if (etat == Etat.JOUEUR2GAGNE){
			gagnant.setText(j2.getNom()+" a gagné !");
		}
	}
}
