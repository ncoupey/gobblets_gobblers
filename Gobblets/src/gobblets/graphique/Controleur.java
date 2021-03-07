package gobblets.graphique;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import gobblets.Gobblets;
import gobblets.data.Couleur;
import gobblets.data.Etat;
import gobblets.data.Joueur;
import gobblets.data.Piece;
import gobblets.data.Taille;
import gobblets.ihm.Erreur;
import gobblets.ihm.IHM;
import gobblets.ihm.Menu;
import gobblets.interaction.Action;
import gobblets.interaction.Deplacement;
import gobblets.interaction.Placement;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.Jeu;
import gobblets.logic.PiecePasDisponibleException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;



public class Controleur {
	private Joueur j1;
	private Joueur j2;
	private int originX = 5;
	private int originY = 5;
	private Taille taille = null;
	private Jeu jeu;
	private Circle currentCircle;
	@FXML
	MenuItem nouv;
	@FXML
	MenuItem save;
	@FXML
	MenuItem load;
	@FXML
	MenuItem exit;
	@FXML
	MenuItem language;
	@FXML
	MenuItem about;
	@FXML
	MenuItem rules;
	@FXML
	MenuItem FR;
	@FXML
	MenuItem GER;
	@FXML
	MenuItem ENG;
	@FXML
	MenuItem help;
    @FXML
    private BorderPane bp;
    @FXML
    private Button bouton00;
    @FXML
    private Button bouton10;
    @FXML
    private Button bouton20;
    @FXML
    private Button bouton01;
    @FXML
    private Button bouton11;
    @FXML
    private Button bouton21;
    @FXML
    private Button bouton02;
    @FXML
    private Button bouton12;
    @FXML
    private Button bouton22;
    @FXML
    private Circle piece10;
    @FXML
    private Circle piece12;
    @FXML
    private Circle piece11;
    @FXML
    private Circle piece14;
    @FXML
    private Circle piece15;
    @FXML
    private Circle piece13;
    @FXML
    private Circle piece20;
    @FXML
    private Circle piece21;
    @FXML
    private Circle piece22;
    @FXML
    private Circle piece23;
    @FXML
    private Circle piece24;
    @FXML
    private Circle piece25;
    @FXML
    private Label bottomLabel;
    @FXML
    private Label labelMaisonJ1;
    @FXML
    private Label labelMaisonJ2;
    @FXML
    private GridPane gpBoard;
    @FXML
    private Circle cercle00;
    @FXML
    private Circle cercle10;
    @FXML
    private Circle cercle01;
    @FXML
    private Circle cercle11;
    @FXML
    private Circle cercle20;
    @FXML
    private Circle cercle21;
    @FXML
    private Circle cercle02;
    @FXML
    private Circle cercle12;
    @FXML
    private Circle cercle22;
    
	public void menuQuitter() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Quitter");
		alert.setHeaderText("Attention");
		alert.setContentText("Voulez vous vraiment quitter la partie ?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			System.exit(0);
		}
		
	}
	
	 @FXML
	public void menuNouvellePartie() throws IOException {
		System.out.println("1");
		Stage stage = new Stage();
		Stage currentWindow = (Stage) labelMaisonJ1.getScene().getWindow();
		System.out.println("2");
		BorderPane bp = new BorderPane();
		Jeu jeu = new Jeu(j1, j2);
		stage.setTitle("Gobblets");
		FXMLLoader loader = new FXMLLoader(Gobblets.class.getResource("graphique/Sample.fxml"));
		bp = loader.load(); 
		Controleur controller = loader.<Controleur>getController();
		Joueur[] tabJoueur = {j1, j2};
		controller.setGame(tabJoueur, jeu);
	    
		System.out.println("3");
		Scene scene = new Scene(bp);
		stage.setScene(scene);
		currentWindow.close();
        stage.show();
        System.out.println("4");
	}
	
	public void FR(ActionEvent e) {
		IHM.setLanguage("FR");
		about.setText(IHM.menu(Menu.MENU_TITRE_APROPOS));
		rules.setText(IHM.menu(Menu.MENU_TITRE_REGLES));
		exit.setText(IHM.menu(Menu.MENU_TITRE_QUITTER));
		save.setText(IHM.menu(Menu.MENU_TITRE_SAUVEGARDER));
		load.setText(IHM.menu(Menu.MENU_TITRE_CHARGER));
		FR.setText(IHM.menu(Menu.MENU_TITRE_FR));
		ENG.setText(IHM.menu(Menu.MENU_TITRE_ENG));
		GER.setText(IHM.menu(Menu.MENU_TITRE_GER));
		language.setText(IHM.menu(Menu.MENU_TITRE_LANGUE));
		help.setText(IHM.menu(Menu.MENU_TITRE_AIDE));
		nouv.setText(IHM.menu(Menu.MENU_TITRE_NEW));
	}
	public void ANG(ActionEvent e) {
		IHM.setLanguage("ENG");
		about.setText(IHM.menu(Menu.MENU_TITRE_APROPOS));
		rules.setText(IHM.menu(Menu.MENU_TITRE_REGLES));
		exit.setText(IHM.menu(Menu.MENU_TITRE_QUITTER));
		save.setText(IHM.menu(Menu.MENU_TITRE_SAUVEGARDER));
		load.setText(IHM.menu(Menu.MENU_TITRE_CHARGER));
		FR.setText(IHM.menu(Menu.MENU_TITRE_FR));
		ENG.setText(IHM.menu(Menu.MENU_TITRE_ENG));
		GER.setText(IHM.menu(Menu.MENU_TITRE_GER));
		language.setText(IHM.menu(Menu.MENU_TITRE_LANGUE));
		help.setText(IHM.menu(Menu.MENU_TITRE_AIDE));
		nouv.setText(IHM.menu(Menu.MENU_TITRE_NEW));
	}
	public void GER(ActionEvent e) {
		IHM.setLanguage("GER");
		about.setText(IHM.menu(Menu.MENU_TITRE_APROPOS));
		rules.setText(IHM.menu(Menu.MENU_TITRE_REGLES));
		exit.setText(IHM.menu(Menu.MENU_TITRE_QUITTER));
		save.setText(IHM.menu(Menu.MENU_TITRE_SAUVEGARDER));
		load.setText(IHM.menu(Menu.MENU_TITRE_CHARGER));
		FR.setText(IHM.menu(Menu.MENU_TITRE_FR));
		ENG.setText(IHM.menu(Menu.MENU_TITRE_ENG));
		GER.setText(IHM.menu(Menu.MENU_TITRE_GER));
		language.setText(IHM.menu(Menu.MENU_TITRE_LANGUE));
		help.setText(IHM.menu(Menu.MENU_TITRE_AIDE));
		nouv.setText(IHM.menu(Menu.MENU_TITRE_NEW));
	}
	
	
	public void display() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				Piece test = jeu.getPlateau().getCase(i, j).plusGrandePiece();
				Circle cercleChanger = this.getCercle(i, j);
				if(test != null) {
					if(test.getTaille() == Taille.PETITE) {
						cercleChanger.setStrokeWidth(2);
						cercleChanger.setRadius(4);
						cercleChanger.setFill(this.getColor(test.getCouleur()));
						cercleChanger.setVisible(true);
					}
					else if(test.getTaille() == Taille.MOYENNE) {
						cercleChanger.setStrokeWidth(3);
						cercleChanger.setRadius(8);
						cercleChanger.setFill(this.getColor(test.getCouleur()));
						cercleChanger.setVisible(true);
					}
					else {
						cercleChanger.setStrokeWidth(5);
						cercleChanger.setRadius(12);
						cercleChanger.setFill(this.getColor(test.getCouleur()));
						cercleChanger.setVisible(true);
					}
				}
				else {
					cercleChanger.setVisible(false);
				}
			}
		}
		if(jeu.getEtat() == Etat.JEUENCOURS) {
			bottomLabel.setText(jeu.getJoueurActif().getNom() + ", à toi de jouer !");
		}
		else if(jeu.getEtat() == Etat.JOUEUR1GAGNE) {
			bottomLabel.setText(j1.getNom() + " a gagné !");
		}
		else {
			bottomLabel.setText(j2.getNom() + ", a gagné !");
		}
	}
	
	private Circle getCercle(int i, int j) {
		switch(i) {
		case 0:
			switch(j) {
			case 0:
				return cercle00;
			case 1:
				return cercle01;
			case 2:
				return cercle02;
			}
			break;
		case 1:
			switch(j) {
			case 0:
				return cercle10;
			case 1:
				return cercle11;
			case 2:
				return cercle12;
			}
			break;
		case 2:
			switch(j) {
			case 0:
				return cercle20;
			case 1:
				return cercle21;
			case 2:
				return cercle22;
			}
			break;
		}
		return cercle00;
	}

	public void choisirCase(ActionEvent e) throws IOException {
		
		Node boutonClick = ((Node) e.getSource());
		int x = Integer.parseInt(boutonClick.getId().substring(6, 7));
		int y = Integer.parseInt(boutonClick.getId().substring(7));
		if(taille != null) {
			Action placement = new Placement(taille, jeu.getPlateau().getCase(x, y));
			try {
				taille = null;
				currentCircle.setStroke(Color.TRANSPARENT);
				placement.appliquer(jeu.getJoueurActif());
				currentCircle.setOpacity(0.3);
				currentCircle.setCursor(Cursor.DEFAULT);
				currentCircle.setDisable(true);
				currentCircle = null;
				jeu.verifWin();
				jeu.changeJoueur();
			} catch (PiecePasDisponibleException e1) {
				Alerte.warning(IHM.erreur(Erreur.PASDEPIECEDISPONIBLE));
			} catch (CaseBloqueeException e1) {
				Alerte.warning(IHM.erreur(Erreur.CASEBLOQUEE));
			}
		}
		else if(originX == 5 && originY ==  5) {
			if(jeu.getPlateau().getCase(x, y).plusGrandePiece() == null) {
				Alerte.warning(IHM.erreur(Erreur.ORIGINEVIDE));
			}
			else {
				originX = x;
				originY = y;
				this.getCercle(x, y).setStroke(Color.DARKMAGENTA);
			}
		}
		else if(originX == x && originY == y) {
			originX = 5;
			originY = 5;
			this.getCercle(x, y).setStroke(Color.TRANSPARENT);
		}
		else {
			Action deplacement = new Deplacement(jeu.getPlateau().getCase(originX, originY), jeu.getPlateau().getCase(x, y));
			try {
				this.getCercle(originX, originY).setStroke(Color.TRANSPARENT);
				originX = 5;
				originY = 5;
				deplacement.appliquer(jeu.getJoueurActif());
				jeu.verifWin();
				jeu.changeJoueur();
			} catch (PiecePasDisponibleException e1) {
				Alerte.warning(IHM.erreur(Erreur.PASTAPIECE));
			} catch (CaseBloqueeException e1) {
				Alerte.warning(IHM.erreur(Erreur.CASEBLOQUEE));
			}
		}
		this.display();
		System.out.println(jeu.getEtat());
		if(jeu.getEtat() != Etat.JEUENCOURS) {
			Stage currentWindow = (Stage) cercle00.getScene().getWindow();
			Stage menuFin = new Stage();
			AnchorPane ap;
			FXMLLoader charge = new FXMLLoader();
			charge.setLocation(Gobblets.class.getResource("graphique/menuFin.fxml"));
			ap = charge.load();
			charge.<ControleurFin>getController().tranfert(j1, j2, jeu.getEtat(), currentWindow);
			Scene menu = new Scene(ap);
			menuFin.setScene(menu);
			menuFin.initModality(Modality.APPLICATION_MODAL);
			menuFin.showAndWait();
		}
	}
	
	
	public void choisirPiece(MouseEvent e) {
		Circle boutonClick = ((Circle) e.getSource());
		int numJoueur = Integer.parseInt(boutonClick.getId().substring(5, 6));
		int numPiece = Integer.parseInt(boutonClick.getId().substring(6));
		if((numJoueur == 1 && jeu.getJoueurActif() == j2) || (numJoueur == 2 && jeu.getJoueurActif() == j1)) {
			Alerte.warning(IHM.erreur(Erreur.PASTAPIECE));
		}
		else if(taille != null && boutonClick == currentCircle) {
			taille = null;
			currentCircle.setStroke(Color.TRANSPARENT);
			currentCircle = null;
		}
		else {
			if(currentCircle != null) {
				currentCircle.setStroke(Color.TRANSPARENT);
			}
			if(numPiece == 0 || numPiece == 1) {
				taille = Taille.PETITE;
				boutonClick.setStrokeWidth(2);
			}
			else if (numPiece == 2 || numPiece == 3) {
				taille = Taille.MOYENNE;
				boutonClick.setStrokeWidth(3);
			}
			else {
				taille = Taille.GRANDE;
				boutonClick.setStrokeWidth(5);
			}
			boutonClick.setStroke(Color.DARKMAGENTA);
			currentCircle = boutonClick;
		}	
	}
	
	public void setGame(Joueur[] players, Jeu jeu) {
		this.j1 = players[0];
		this.j2 = players[1];
		this.jeu = jeu;
		Color colorj1 = this.getColor(j1.getCouleur());
		Color colorj2 = this.getColor(j2.getCouleur());
		piece10.setFill(colorj1);
		piece11.setFill(colorj1);
		piece12.setFill(colorj1);
		piece13.setFill(colorj1);
		piece14.setFill(colorj1);
		piece15.setFill(colorj1);
		piece20.setFill(colorj2);
		piece21.setFill(colorj2);
		piece22.setFill(colorj2);
		piece23.setFill(colorj2);
		piece24.setFill(colorj2);
		piece25.setFill(colorj2);
		bottomLabel.setText(j1.getNom() + ", à toi de jouer !");
		labelMaisonJ1.setText("Maison de " + j1.getNom());
		labelMaisonJ2.setText("Maison de " + j2.getNom());
		jeu.changeJoueur();
	}
	
	
	private Color getColor(Couleur color) {
		if(color == Couleur.BLEU) {
			return Color.BLUE;
		}
		else if(color == Couleur.JAUNE) {
			return Color.YELLOW;
		}
		else if(color == Couleur.ROUGE) {
			return Color.RED;
		}
		else if(color == Couleur.VERT) {
			return Color.GREEN;
		}
		else {
			return Color.BLACK;
		}
	}

	
	public void menuAPropos(ActionEvent e) {
		Alerte.inform(IHM.menu(Menu.MENU_TITRE_APROPOS), IHM.menu(Menu.MENU_APROPOS));
	}
	public void menuRegles(ActionEvent e) {
		Alerte.inform(IHM.menu(Menu.MENU_TITRE_REGLES), IHM.menu(Menu.MENU_AIDE));
	}

	public void Sauvegarder(ActionEvent e) {
		 FileChooser myFile = new FileChooser();
		 File file = myFile.showSaveDialog(null);
		 myFile.setInitialFileName("Gobblets");
		}
	public void Charger(ActionEvent e) {
		FileChooser myFile = new FileChooser();
		 File file = myFile.showOpenDialog(null);
	}
}
