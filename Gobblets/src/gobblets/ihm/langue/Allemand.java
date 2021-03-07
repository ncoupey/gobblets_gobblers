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

public class Allemand implements Dictionnaire {

	private HashMap<Couleur,String> couleurs= new HashMap<>();;
	private HashMap<Taille,String> tailles= new HashMap<>();;
	private HashMap<Etat,String> etats= new HashMap<>();;
	private HashMap<ActionType,String> actions= new HashMap<>();;
	private HashMap<Erreur,String> erreurs= new HashMap<>();;
	private HashMap<Avertissement,String> avertissements= new HashMap<>();;
	private HashMap<Menu,String> menus= new HashMap<>();;
	
	public Allemand() {
		couleurs.put(Couleur.ROUGE, "rot");
		couleurs.put(Couleur.BLEU, "blau");
		couleurs.put(Couleur.VERT, "gr�n");
		couleurs.put(Couleur.JAUNE, "gelb");
		couleurs.put(Couleur.NOIR, "schwarz");
		tailles.put(Taille.PETITE, "klein");
		tailles.put(Taille.MOYENNE, "Mitte");
		tailles.put(Taille.GRANDE, "gro�");
		etats.put(Etat.JOUEUR1GAGNE,"Spieler 1 Sieg");
		etats.put(Etat.JOUEUR2GAGNE,"Spieler 2 Sieg");
		etats.put(Etat.JEUENCOURS,"Gerade stattfindendes Spiel");
		etats.put(Etat.JEUQUITTE,"Spiel links");
		etats.put(Etat.MATCHNUL,"Gleichberechtigung");
		actions.put(ActionType.PLACER,"Hinstellen");
		actions.put(ActionType.DEPLACER,"Bewegung");
		actions.put(ActionType.QUITTER,"verlassen");
		erreurs.put(Erreur.PASDEPIECEDISPONIBLE,"St�ck nicht verf�gbar");
		erreurs.put(Erreur.PASTAPIECE,"Dies ist nicht dein St�ck");
		erreurs.put(Erreur.CASEBLOQUEE,"Fall blockiert");
		erreurs.put(Erreur.ARGUMENTINCORRECT,"falsches Argument");
		erreurs.put(Erreur.PASDEPIECEICI,"Kein St�ck hier");
		erreurs.put(Erreur.PASDETAILLEDISPONIBLE,"Gr��e nicht verf�gbar");
		erreurs.put(Erreur.DIAGONIALEINCORRECTE,"falsche Diagonale");
		erreurs.put(Erreur.ORIGINEVIDE,"leerer Ursprung");
		avertissements.put(Avertissement.AVERTISSEMENT,"Warnung");
		avertissements.put(Avertissement.TONTOUR,"Sie sind dran");
		avertissements.put(Avertissement.CHOIXACTION,"Aktionsauswahl (Placer f�r Hinstellen, Deplacer f�r Bewegung, Quitter f�r verlassen)");
		avertissements.put(Avertissement.CHOIXTAILLE,"Gr��enauswahl (Petite f�r kleine, Moyenne f�r mittlere, Grande f�r gro�e)");
		avertissements.put(Avertissement.NOMJOUEUR,"Spielername");
		avertissements.put(Avertissement.COULEURJOUEUR,"Spielerfarbe (Rouge f�r Rot, Jaune f�r Gelb, Vert f�r Gr�n, Bleu f�r Blau oder Blanc f�r Wei�)");
		avertissements.put(Avertissement.CHOIXORIGIN,"Herkunftswahl");
		avertissements.put(Avertissement.CHOIXDESTINATION,"Zielauswahl");
		menus.put(Menu.MENU_FICHIER, "Was m�chten Sie tun? \n 1: Teil starten \n 2: Sprache �ndern \n 3: Hilfe \n 4: Info \n 5: Beenden");
		menus.put(Menu.MENU_OUVRIR, "Men� �ffnen");
		menus.put(Menu.MENU_ENREGISTRER, "Men� speichern");
		menus.put(Menu.MENU_NOUVEAU, "neues Men�");
		menus.put(Menu.MENU_QUITTER, "Auf Wiedersehen!");
		menus.put(Menu.MENU_AIDE, "\"Wie bei Tic-Tac-Toe besteht das Ziel des Spiels darin, drei Teile vertikal, horizontal oder diagonal auszurichten.\n"+
				"Jeder Spieler hat 6 Teile: 2 kleine, 2 mittlere und 2 gro�e. \n" + 
				"Jeder Spieler kann entweder eine Figur platzieren oder eine bereits platzierte Figur bewegen. \n" + 
				"Ein Spieler kann ein St�ck auf ein anderes legen, aber nur, wenn es gr��er als das Original ist.");
		menus.put(Menu.MENU_APROPOS,"Spiel erstellt von Noah Coupey und Edgar Mauranne von TD 1-2.");
		menus.put(Menu.MENU_LANGUE, " 1: Fran�ais\n 2: English\n 3:Deutsche");
		menus.put(Menu.MENU_TITRE_APROPOS, " Info");
		menus.put(Menu.MENU_TITRE_REGLES, "Regeln");
		menus.put(Menu.MENU_TITRE_QUITTER, "verlassen");
		menus.put(Menu.MENU_TITRE_SAUVEGARDER, "Speichern");
		menus.put(Menu.MENU_TITRE_CHARGER, "Laden");
		menus.put(Menu.MENU_TITRE_FR, " Français");
		menus.put(Menu.MENU_TITRE_ENG, " English");
		menus.put(Menu.MENU_TITRE_GER, " German");
		menus.put(Menu.MENU_TITRE_AIDE, "Hilf");
		menus.put(Menu.MENU_TITRE_LANGUE, "Sprichst");
		menus.put(Menu.MENU_TITRE_NEW, "Neuer Teil");
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
