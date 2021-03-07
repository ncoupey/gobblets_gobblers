package gobblets.data;

import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;

public class Case {
	
	private Piece petite;
	private Piece moyenne;
	private Piece grande;
	
	public Case() {
		petite = null;
		moyenne = null;
		grande = null;
	}
	
	public boolean acceptePiece(Taille taille) {
		if(taille == Taille.GRANDE) {
			return(grande == null);
		}
		else if(taille == Taille.MOYENNE) {
			return(moyenne == null && grande  == null);
		}
		else if(taille == Taille.PETITE) {
			return(petite == null && moyenne == null && grande == null);
		}
		else {
			return false;
		}
		
	}
	
	public Piece enlevePiece(Piece piece) throws PiecePasDisponibleException {
		if(piece.getTaille() == Taille.GRANDE && grande != null) {
			Piece pieceRetire = grande;
			grande = null;
			return pieceRetire;
		}
		else if(piece.getTaille() == Taille.MOYENNE && moyenne != null) {
			Piece pieceRetire = moyenne;
			moyenne = null;
			return pieceRetire;
		}
		else if(piece.getTaille() == Taille.PETITE && petite != null) {
			Piece pieceRetire = petite;
			petite = null;
			return pieceRetire;
		}
		else {
			throw new PiecePasDisponibleException();
		}
	}
	
	public void placePiece(Piece piece) throws CaseBloqueeException {
		if(piece.getTaille() == Taille.GRANDE  && grande == null) {
			grande = piece;
		}
		else if(piece.getTaille() == Taille.MOYENNE && moyenne == null) {
			moyenne = piece;
		}
		else if(piece.getTaille() == Taille.PETITE && petite == null) {
			petite = piece;
		}
		else {
			throw new CaseBloqueeException();
		}
	}
	
	public Piece plusGrandePiece() {
		if(grande != null) {
			return grande;
		}
		else if(moyenne != null) {
			return moyenne;
		}
		else if(petite != null) {
			return petite;
		}
		else {
			return null;
		}
	}

	@Override
	public String toString() {
		return "Case [petite=" + petite + ", moyenne=" + moyenne + ", grande=" + grande + "]";
	}
	
	
}
