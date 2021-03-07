package gobblets.data;

public class Piece {
	Taille taille;
	Couleur couleur;
	
	public Piece(Taille taille) {
		this.taille = taille;
		this.couleur = null;
	}
	public Couleur getCouleur() {
		return couleur;
	}
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}
	public Taille getTaille() {
		return taille;
	}
	public boolean appartientA(Joueur joueurActif) {
		 if(joueurActif.getCouleur() == couleur) {
			 return true;
		 }
		 else {
			 return false;
		 }
	}
	
	@Override
	public String toString() {
		return "Piece [taille=" + taille + ", couleur=" + couleur + "]";
	}
}
