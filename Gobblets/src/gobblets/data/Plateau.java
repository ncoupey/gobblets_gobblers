package gobblets.data;

import java.util.ArrayList;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;

public class Plateau {

		private Case[][] plateau;

		private ArrayList<Piece> maisonJoueur1 = new ArrayList<Piece>();
		private ArrayList<Piece> maisonJoueur2 = new ArrayList<Piece>();

		
		private Plateau(){
			plateau = new Case[3][3];
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++)	{
					plateau[j][k] = new Case();
				}
			}
			for(int i = 1; i <= 2; i++) {
				maisonJoueur1.add(0, new Piece(Taille.PETITE));
				maisonJoueur2.add(0, new Piece(Taille.PETITE));
				maisonJoueur1.add(1*i, new Piece(Taille.MOYENNE));
				maisonJoueur2.add(1*i, new Piece(Taille.MOYENNE));
				maisonJoueur1.add(2*i, new Piece(Taille.GRANDE));
				maisonJoueur2.add(2*i, new Piece(Taille.GRANDE));
			}
		}
		
		public static Plateau initPlateau() {
			Plateau board = new Plateau();
			return board;
		}
		
		public Case[][] getPlateau(){
			return plateau;
		}
		
		public Case getCase(int x, int y) {
			return plateau[x][y];
		}
		
		private Case[] getLigne(int ligne) {
			Case[] ligneVoulue = {plateau[ligne][0], plateau[ligne][1], plateau[ligne][2]};
			return ligneVoulue;
		}
		
		private Case[] getColonne(int colonne) {
			Case[] colonneVoulue = {plateau[0][colonne], plateau[1][colonne], plateau[2][colonne]};
			return colonneVoulue;
		}
		
		private Case[] getDiagonalePrincipale() {
			Case[] diago = {plateau[0][0], plateau[1][1], plateau[2][2]};
			return diago;
		}
		
		private Case[] getDiagonaleSecondaire() {
			Case[] diago = {plateau[0][2], plateau[1][1], plateau[2][0]};
			return diago;
		}
		
		public ArrayList<Piece> getMaisonJoueur1(){
			return maisonJoueur1;
		}
		
		public ArrayList<Piece> getMaisonJoueur2(){
			return maisonJoueur2;
		}
		
		public void placePiece(Piece piece, int ligne, int colonne) throws CaseBloqueeException {
			Case caseVoulue = plateau[ligne][colonne];
			if(caseVoulue.acceptePiece(piece.getTaille())) {
				caseVoulue.placePiece(piece);
				plateau[ligne][colonne] = caseVoulue;
			}
			else throw new CaseBloqueeException();
		}
		
		public Piece enlevePiece(int ligne, int colonne) throws PiecePasDisponibleException {
			Case caseVoulue = plateau[ligne][colonne];
			return caseVoulue.enlevePiece(caseVoulue.plusGrandePiece());
		}
		
		public Piece plusGrandPiece(int ligne, int colonne) {
			Case caseVoulue = plateau[ligne][colonne];
			return caseVoulue.plusGrandePiece();	
		}
		
		public Couleur verifierLigne(int ligne) {
			Case[] test = getLigne(ligne);
			if(test[0].plusGrandePiece() == null || test[1].plusGrandePiece() == null || test[2].plusGrandePiece() == null)	{
				return null;
			}
			else if(test[0].plusGrandePiece().getCouleur() == test[1].plusGrandePiece().getCouleur() 
					&& test[1].plusGrandePiece().getCouleur() == test[2].plusGrandePiece().getCouleur()) {
				return test[0].plusGrandePiece().getCouleur();
			}
			else return null;
		}
		
		public Couleur verifierColonne(int colonne) {
			Case[] test = getColonne(colonne);
			if(test[0].plusGrandePiece() == null || test[1].plusGrandePiece() == null || test[2].plusGrandePiece() == null)	{
				return null;
			}
			else if(test[0].plusGrandePiece().getCouleur() == test[1].plusGrandePiece().getCouleur() 
					&& test[1].plusGrandePiece().getCouleur() == test[2].plusGrandePiece().getCouleur()) {
				return test[0].plusGrandePiece().getCouleur();
			}
			else return null;
		}
		
		public Couleur verifierDiagonale(char diago) {
			if(diago == 'p') {
				Case[] test = getDiagonalePrincipale();
				if(test[0].plusGrandePiece() == null || test[1].plusGrandePiece() == null || test[2].plusGrandePiece() == null)	{
					return null;
				}
				if(test[0].plusGrandePiece().getCouleur() == test[1].plusGrandePiece().getCouleur() 
						&& test[1].plusGrandePiece().getCouleur() == test[2].plusGrandePiece().getCouleur()) {
					return test[0].plusGrandePiece().getCouleur();
				}
				else return null;
			}
			else if(diago == 's') {
				Case[] test = getDiagonaleSecondaire();
				if(test[0].plusGrandePiece() == null || test[1].plusGrandePiece() == null || test[2].plusGrandePiece() == null)	{
					return null;
				}
				if(test[0].plusGrandePiece().getCouleur() == test[1].plusGrandePiece().getCouleur() 
						&& test[1].plusGrandePiece().getCouleur() == test[2].plusGrandePiece().getCouleur()) {
					return test[0].plusGrandePiece().getCouleur();
				}
				else return null;
			}
			else return null;
		}
}
