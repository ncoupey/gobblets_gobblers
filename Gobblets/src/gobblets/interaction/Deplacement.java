package gobblets.interaction;

import gobblets.data.Case;
import gobblets.data.Joueur;
import gobblets.ihm.Erreur;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;

public class Deplacement extends Action{
	
	private Case origin;
	private Case destination;
	
	public Deplacement(Case origin, Case destination) {
		super();
		this.origin = origin;
		this.destination = destination;
	}
	
	public Case getOrigin() {
		return origin;
	}
	
	public Case getDestination() {
		return destination;
	}
	
	public boolean verifier(Joueur player) throws PiecePasDisponibleException, CaseBloqueeException {
		if(origin.plusGrandePiece() == null) {
			throw new PiecePasDisponibleException(Erreur.ORIGINEVIDE);
		}
		if(player.getCouleur() == origin.plusGrandePiece().getCouleur()) {
			if(destination.acceptePiece(origin.plusGrandePiece().getTaille())) {
				return true;
			}
			else throw new CaseBloqueeException();
		}
		else throw new PiecePasDisponibleException();
	}
	
	public void appliquer(Joueur player) throws PiecePasDisponibleException, CaseBloqueeException {
		if(verifier(player)) {
			destination.placePiece(origin.enlevePiece(origin.plusGrandePiece()));
		}
	}

	@Override
	public String toString() {
		return "Deplacement [origin=" + origin + ", destination=" + destination + "]";
	}
}
