package gobblets.ihm.texte;

import gobblets.data.Couleur;
import gobblets.data.Taille;

public class Piece {

	private gobblets.data.Piece contenu;
	
	public Piece(gobblets.data.Piece contenu) {
		this.contenu = contenu;
	}
	
	public String[] getRepresentationTextuelle() {
		String[] textPiece = {" ", " ", " "};
		Taille size = contenu.getTaille();
		Couleur color = contenu.getCouleur();
		if(size == Taille.PETITE) {
			if(color == Couleur.NOIR) {
				textPiece[1] = "*";
			}
			else if(color == Couleur.BLEU) {
				textPiece[1] = "\u001B[34m.\u001B[0m";
			}
			else if(color == Couleur.JAUNE) {
				textPiece[1] = "\u001B[33m*\u001B[0m";
			}
			else if(color == Couleur.ROUGE) {
				textPiece[1] = "\u001B[31m.\u001B[0m";
			}
			else if(color == Couleur.VERT) {
				textPiece[1] = "\u001B[32m*\u001B[0m";
			}
		}
		else if(size == Taille.MOYENNE) {
			if(color == Couleur.NOIR) {
				textPiece[1] = "x";
			}
			else if(color == Couleur.BLEU) {
				textPiece[1] = "\u001B[34mo\u001B[0m";
			}
			else if(color == Couleur.JAUNE) {
				textPiece[1] = "\u001B[33mx\u001B[0m";
			}
			else if(color == Couleur.ROUGE) {
				textPiece[1] = "\u001B[31mo\u001B[0m";
			}
			else if(color == Couleur.VERT) {
				textPiece[1] = "\u001B[32mx\u001B[0m";
			}
		}
		else if(size == Taille.GRANDE) {
			if(color == Couleur.NOIR) {
				textPiece[1] = "X";
			}
			else if(color == Couleur.BLEU) {
				textPiece[1] = "\u001B[34mO\u001B[0m";
			}
			else if(color == Couleur.JAUNE) {
				textPiece[1] = "\u001B[33mX\u001B[0m";
			}
			else if(color == Couleur.ROUGE) {
				textPiece[1] = "\u001B[31mO\u001B[0m";
			}
			else if(color == Couleur.VERT) {
				textPiece[1] = "\u001B[32mX\u001B[0m";
			}
		}
		return textPiece;
	}
}
