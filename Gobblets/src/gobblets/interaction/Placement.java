package gobblets.interaction;

import gobblets.data.Case;
import gobblets.data.Joueur;
import gobblets.data.Taille;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;

public class Placement extends Action {
	Taille taille;
	Case destination;
	
	public Placement(Taille taille, Case destination) {
		super();
		this.taille = taille;
		this.destination = destination;
	}

	public Taille getTaille() {
		return taille;
	}

	public Case getDestination() {
		return destination;
	}

	public boolean verifier(Joueur player) throws PiecePasDisponibleException, CaseBloqueeException {
		if(player.aPieceDeTaille(taille)) {
			if(destination.acceptePiece(taille)) {
				return true;
			}
			else throw new CaseBloqueeException();
		}
		else throw new PiecePasDisponibleException();
	}

	@Override
	public void appliquer(Joueur player) throws CaseBloqueeException, PiecePasDisponibleException {
		if(this.verifier(player)) {
			destination.placePiece(player.enlevePiece(taille));
		}
	}

	@Override
	public String toString() {
		return "Placement d'un pièce de taille "+ taille +" dans la case " + destination + ".";
	}

}
