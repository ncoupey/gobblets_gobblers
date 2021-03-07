package gobblets.ihm.langue;

import java.util.HashMap;
import gobblets.data.ActionType;
import gobblets.data.Couleur;
import gobblets.data.Etat;
import gobblets.data.Taille;
import gobblets.ihm.Avertissement;
import gobblets.ihm.Dictionnaire;
import gobblets.ihm.Erreur;
import gobblets.ihm.Menu;

public class Anglais implements Dictionnaire {

	private HashMap<Couleur,String> couleurs= new HashMap<>();;
	private HashMap<Taille,String> tailles= new HashMap<>();;
	private HashMap<Etat,String> etats= new HashMap<>();;
	private HashMap<ActionType,String> actions= new HashMap<>();;
	private HashMap<Erreur,String> erreurs= new HashMap<>();;
	private HashMap<Avertissement,String> avertissements= new HashMap<>();;
	private HashMap<Menu,String> menus= new HashMap<>();;
	
	public Anglais() {
		couleurs.put(Couleur.ROUGE, "Red");
		couleurs.put(Couleur.BLEU, "Blue");
		couleurs.put(Couleur.VERT, "Green");
		couleurs.put(Couleur.JAUNE, "Yellow");
		couleurs.put(Couleur.NOIR, "Black");
		tailles.put(Taille.PETITE, "Small");
		tailles.put(Taille.MOYENNE, "Medium");
		tailles.put(Taille.GRANDE, "Large");
		etats.put(Etat.JOUEUR1GAGNE,"Player 1 Victory");
		etats.put(Etat.JOUEUR2GAGNE,"Player 2 Victory");
		etats.put(Etat.JEUENCOURS,"Game in progress");
		etats.put(Etat.JEUQUITTE,"Game ended");
		etats.put(Etat.MATCHNUL,"Draw");
		actions.put(ActionType.PLACER,"Place");
		actions.put(ActionType.DEPLACER,"Move");
		actions.put(ActionType.QUITTER,"Quit");
		erreurs.put(Erreur.PASDEPIECEDISPONIBLE,"That piece isn't available !");
		erreurs.put(Erreur.PASTAPIECE,"This is not your piece");
		erreurs.put(Erreur.CASEBLOQUEE,"That square isn't available !");
		erreurs.put(Erreur.ARGUMENTINCORRECT,"Incorrect argument");
		erreurs.put(Erreur.PASDEPIECEICI,"No piece here");
		erreurs.put(Erreur.PASDETAILLEDISPONIBLE,"Size not available");
		erreurs.put(Erreur.DIAGONIALEINCORRECTE,"Incorrect diagonal");
		erreurs.put(Erreur.ORIGINEVIDE,"Blank origin");
		avertissements.put(Avertissement.AVERTISSEMENT,"Warning");
		avertissements.put(Avertissement.TONTOUR,"It's your turn");
		avertissements.put(Avertissement.CHOIXACTION,"Choose an action (Placer for Place, Deplacer for Move, Quitter for Quit)");
		avertissements.put(Avertissement.CHOIXTAILLE,"What size ?(Petite for Little, Moyenne for Medium, Grande for Large)");
		avertissements.put(Avertissement.NOMJOUEUR,"Enter a name for player");
		avertissements.put(Avertissement.COULEURJOUEUR,"Enter a color for player (rouge for red, jaune for yellow, vert for green, bleu for blue or blanc for white)");
		avertissements.put(Avertissement.CHOIXORIGIN,"Enter the current location of the piece");
		avertissements.put(Avertissement.CHOIXDESTINATION,"Choose the destination for that piece");
		menus.put(Menu.MENU_FICHIER, "What would you like to do? \n 1: Play \n 2: Language setup \n 3: Help \n 4: About \n 5: Exit");
		menus.put(Menu.MENU_OUVRIR, "Open menu");
		menus.put(Menu.MENU_ENREGISTRER, "Save menu");
		menus.put(Menu.MENU_NOUVEAU, "New menu");
		menus.put(Menu.MENU_QUITTER, "See you next time!");
		menus.put(Menu.MENU_AIDE, "Just like tic-tac-toe, the objective of the game is to align three pieces vertically, horizontally or diagonally. \n"+ 
				"Each player has 6 pieces: 2 small, 2 medium and 2 large. \n" + 
				"Each player in turn can either place a piece or move an already placed piece. \n" + 
				"A player can place one piece on top of another, but only if it is larger than the original.");
		menus.put(Menu.MENU_APROPOS, "Game created by Noah Coupey and Edgar Mauranne from TD 1-2.");
		menus.put(Menu.MENU_LANGUE, " 1: Français\n 2: English\n 3:Deutsche");
		menus.put(Menu.MENU_TITRE_APROPOS, " About");
		menus.put(Menu.MENU_TITRE_REGLES, " Rules");
		menus.put(Menu.MENU_TITRE_QUITTER, "Exit ");
		menus.put(Menu.MENU_TITRE_SAUVEGARDER, " Save");
		menus.put(Menu.MENU_TITRE_CHARGER, " Load");
		menus.put(Menu.MENU_TITRE_FR, " Français");
		menus.put(Menu.MENU_TITRE_ENG, " English");
		menus.put(Menu.MENU_TITRE_GER, " German");
		menus.put(Menu.MENU_TITRE_AIDE, " Help");
		menus.put(Menu.MENU_TITRE_LANGUE, "Language");
		menus.put(Menu.MENU_TITRE_NEW, "New game");
	}
	
	public String couleur(Couleur couleur) {
		return couleurs.get(couleur);
	}
	
	public String taille(Taille taille) {
		return tailles.get(taille);
		
	}
	
	public String etat(Etat etat) {
		return etats.get(etat);
		
	}
	
	public String action(ActionType action) {
		return actions.get(action);
		
	}
	
	public String erreur(Erreur erreur) {
		return erreurs.get(erreur);
		
	}
	
	public String avertissement(Avertissement avertissement) {
		return avertissements.get(avertissement);
		
	}
	
	public String menu(Menu menu) {
		return menus.get(menu);
		
	}
}
