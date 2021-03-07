package gobblets.ihm;

import gobblets.data.ActionType;
import gobblets.data.Couleur;
import gobblets.data.Etat;
import gobblets.data.Joueur;
import gobblets.data.Plateau;
import gobblets.data.Taille;
import gobblets.ihm.langue.Allemand;
import gobblets.ihm.langue.Anglais;
import gobblets.ihm.langue.Francais;

public abstract class IHM {
	static Dictionnaire dictionnaire= new Francais();
	private static IHM ihm;
	public IHM() {
		
	}
	
	public static IHM getIHM() {
		return ihm;
		
	}
	
	public static void setIhm(IHM ihm) {
		IHM.ihm = ihm;
	}
	
	public static void setLanguage(String langue) {
		switch (langue) {
			case "FR":
				dictionnaire =new Francais();
				break;
			case "ENG":
				dictionnaire =new Anglais();
				break;
			case "GER":
				dictionnaire =new Allemand();
				break;
		}
	}
	
	public static String couleur(Couleur color) {
		return  dictionnaire.couleur(color);
		
	}
	
	public static String taille(Taille size) {
		return dictionnaire.taille(size);
		
	}
	
	public static String etat(Etat state) {
		return dictionnaire.etat(state);
		
	}
	
	public static String action(ActionType action) {
		return dictionnaire.action(action);
		
	}
	
	public static String erreur(Erreur error) {
		return dictionnaire.erreur(error);
		
	}
	
	public static String avertissement(Avertissement warning) {
		return dictionnaire.avertissement(warning);
		
	}
	
	public static String menu(Menu home) {
		return dictionnaire.menu(home);
		
	}
	
	public abstract Joueur saisirJoueur(int a);
	
	public abstract ActionType saisirAction(Joueur player);
	
	public abstract Taille saisirTaille();
	
	public abstract int[] saisirCoordonnees(ActionType action);
	
	public abstract void display(Plateau board, Joueur player);
}
