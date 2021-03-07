package gobblets.ihm;

import gobblets.data.ActionType;
import gobblets.data.Couleur;
import gobblets.data.Etat;
import gobblets.data.Taille;

public interface Dictionnaire {
	public abstract String couleur(Couleur couleur);
	public abstract String taille(Taille taille);
	public abstract String etat(Etat etat);
	public abstract String action(ActionType action);
	public abstract String erreur(Erreur erreur);
	public abstract String avertissement(Avertissement avertissement);
	public abstract String menu(Menu menu);
}
