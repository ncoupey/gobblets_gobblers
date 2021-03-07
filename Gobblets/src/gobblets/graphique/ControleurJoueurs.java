package gobblets.graphique;

import java.io.IOException;

import gobblets.Gobblets;
import gobblets.data.Couleur;
import gobblets.data.Joueur;
import gobblets.data.JoueurHumain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControleurJoueurs {
	private String nom1;
	private String couleurTxt1;
	private String nom2;
	private String couleurTxt2;
	private Joueur[] tabJoueur = new Joueur[2];
	private Couleur couleurJ1;
	private Couleur couleurJ2;
	@FXML
	ObservableList<String>couleur = FXCollections.observableArrayList("ROUGE","BLEU","VERT","JAUNE","NOIR");
	@FXML
	private TextField joueur1;
	@FXML
	private ChoiceBox couleur1;
	@FXML
	private TextField joueur2;
	@FXML
	private ChoiceBox couleur2;

    @FXML
    private Button boutonValider;
	@FXML
	private void initialize() {
		couleur1.setItems(couleur);
		couleur1.setValue("ROUGE");
		couleur2.setItems(couleur);
		couleur2.setValue("VERT");
	}
	private void terminer() {
		
		Stage stage = (Stage) boutonValider.getScene().getWindow();
		Joueur j1= new JoueurHumain(nom1,couleurJ1);
		Joueur j2= new JoueurHumain(nom2,couleurJ2);
		this.tabJoueur[0] = j1;
		this.tabJoueur[1] = j2;
		stage.close();
	}
	
	public void validNom(){
		nom1=joueur1.getText();
		couleurTxt1 = (String) couleur1.getValue();
		couleurJ1 = Couleur.valueOf(couleurTxt1);
		nom2=joueur2.getText();
		couleurTxt2 = (String) couleur2.getValue();
		couleurJ2 = Couleur.valueOf(couleurTxt2);
		if(couleurJ1==couleurJ2 || nom1.length()==0 || nom2.length()==0) {
			Alerte.warning("La couleur des deux joueurs ne doit pas etre vide et les cases des noms doivent être remplie");
		}else {
			this.terminer();	
		}
	}
	
	public Joueur[] getJoueurs() {
		return tabJoueur;
	}
	
}
