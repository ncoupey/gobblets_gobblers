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

public class Francais implements Dictionnaire {

	private HashMap<Couleur,String> couleurs = new HashMap<>();
	private HashMap<Taille,String> tailles= new HashMap<>();
	private HashMap<Etat,String> etats= new HashMap<>();
	private HashMap<ActionType,String> actions= new HashMap<>();
	private HashMap<Erreur,String> erreurs= new HashMap<>();
	private HashMap<Avertissement,String> avertissements= new HashMap<>();
	private HashMap<Menu,String> menus= new HashMap<>();
	
	public Francais() {
		System.setProperty( "file.encoding", "UTF-8" );
		couleurs.put(Couleur.ROUGE, "Rouge");
		couleurs.put(Couleur.BLEU, "Bleu");
		couleurs.put(Couleur.VERT, "Vert");
		couleurs.put(Couleur.JAUNE, "Jaune");
		couleurs.put(Couleur.NOIR, "Noir");
		tailles.put(Taille.PETITE, "Petite");
		tailles.put(Taille.MOYENNE, "Moyenne");
		tailles.put(Taille.GRANDE, "Grande");
		etats.put(Etat.JOUEUR1GAGNE,"Victoire du joueur 1");
		etats.put(Etat.JOUEUR2GAGNE,"Victoire du joueur 2");
		etats.put(Etat.JEUENCOURS,"Jeu en cours");
		etats.put(Etat.JEUQUITTE,"Jeu terminé");
		etats.put(Etat.MATCHNUL,"Match nul");
		actions.put(ActionType.PLACER,"Placer");
		actions.put(ActionType.DEPLACER,"Deplacer");
		actions.put(ActionType.QUITTER,"Quitter");
		erreurs.put(Erreur.PASDEPIECEDISPONIBLE,"Cette pièce n'est pas disponible !");
		erreurs.put(Erreur.PASTAPIECE,"Ce n'est pas ta pièce...");
		erreurs.put(Erreur.CASEBLOQUEE,"Cette case est bloquée");
		erreurs.put(Erreur.ARGUMENTINCORRECT,"Argument incorrect");
		erreurs.put(Erreur.PASDEPIECEICI,"Pas de pièce ici");
		erreurs.put(Erreur.PASDETAILLEDISPONIBLE,"Taille non disponible");
		erreurs.put(Erreur.DIAGONIALEINCORRECTE,"Diagonale incorrecte");
		erreurs.put(Erreur.ORIGINEVIDE,"Origine vide");
		avertissements.put(Avertissement.AVERTISSEMENT,"Avertissement");
		avertissements.put(Avertissement.TONTOUR,"C'est ton tour");
		avertissements.put(Avertissement.CHOIXACTION,"Choix de l'action (Placer, Deplacer ou quitter)");
		avertissements.put(Avertissement.CHOIXTAILLE,"Choix de la taille (Petite Moyenne ou Grande)");
		avertissements.put(Avertissement.NOMJOUEUR,"Nom du joueur");
		avertissements.put(Avertissement.COULEURJOUEUR,"Couleur du joueur (rouge, jaune, vert, bleu ou blanc)");
		avertissements.put(Avertissement.CHOIXORIGIN,"Origine de la pièce");
		avertissements.put(Avertissement.CHOIXDESTINATION,"Destination de la pièce");
		menus.put(Menu.MENU_FICHIER, "Que voulez vous faire ?\n 1:Jouer \n 2: Changer de langue \n 3: Aide \n 4: A propos\n 5: Quitter");
		menus.put(Menu.MENU_OUVRIR, "Ouvrir menu");
		menus.put(Menu.MENU_ENREGISTRER, "Menu enregistrer");
		menus.put(Menu.MENU_NOUVEAU, "menu nouveau");
		menus.put(Menu.MENU_QUITTER, "Au revoir !");
		menus.put(Menu.MENU_AIDE, "Comme pour le morpion, le but du jeu est d'aligner trois pièces verticalement, horizontalement ou diagonalement.\n"
				+ "Chaque joueur possède 6 pièces: 2 petites, 2 moyennes et 2 grandes.\n"
				+ "Chacun leur tour, les joueurs peuvent soit poser une pièce, soit en déplacer une déjà posée.\n"
				+ "Un joueur peut poser une pièce par dessus une autre, mais seulement si celle-ci est plus grande que l'originale.");
		menus.put(Menu.MENU_APROPOS, "Jeu crée par Noah Coupey et Edgar Mauranne du TD 1-2.");
		menus.put(Menu.MENU_LANGUE, " 1: Français\n 2: English\n 3:Deutsche");
		menus.put(Menu.MENU_TITRE_APROPOS, " A propos");
		menus.put(Menu.MENU_TITRE_REGLES, " Règles");
		menus.put(Menu.MENU_TITRE_QUITTER, "Quitter ");
		menus.put(Menu.MENU_TITRE_SAUVEGARDER, " Sauvegarder");
		menus.put(Menu.MENU_TITRE_CHARGER, " Charger");
		menus.put(Menu.MENU_TITRE_FR, " Français");
		menus.put(Menu.MENU_TITRE_ENG, " English");
		menus.put(Menu.MENU_TITRE_GER, " German");
		menus.put(Menu.MENU_TITRE_AIDE, " Aide");
		menus.put(Menu.MENU_TITRE_LANGUE, "Langue");
		menus.put(Menu.MENU_TITRE_NEW, "Nouvelle partie");
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
