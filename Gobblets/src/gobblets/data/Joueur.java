package gobblets.data;

import java.util.ArrayList;

import gobblets.ihm.Erreur;
import gobblets.interaction.Action;
import gobblets.logic.PiecePasDisponibleException;

public abstract class  Joueur {
	
	private String nom;
	private Couleur couleur;
	private ArrayList<Piece> maison = new ArrayList<Piece>();
	
	public Joueur(String nom, Couleur couleur) {
		this.nom = nom;
		this.couleur = couleur;
	}

	public ArrayList<Piece> getPieces() {
		return maison;
	}



	public void setPieces(ArrayList<Piece> piece) {
		this.maison = piece;
	}

	public void ajoutePiece(Piece piece) {
		maison.add(piece);
	}
	
	public boolean aPiece(Piece piece) {
		return maison.contains(piece);
	}
	
	public String getNom() {
		return nom;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public abstract Action choisirAction(Plateau board);
	
	
	public Piece enlevePiece(Taille taille) throws PiecePasDisponibleException {
			Piece searchPiece = null;
			int i = 0;
			while(i<=maison.size()) {
				if(taille == maison.get(i).getTaille()) {
					searchPiece = maison.get(i);
					break;
				}
				i++;
			}
			if(searchPiece != null) {
				maison.remove(i);
				return searchPiece;
			}else {
				throw new PiecePasDisponibleException(Erreur.PASDEPIECEDISPONIBLE);
			}
			
			
	}
	
	public boolean aPieceDeTaille(Taille taille) {
		boolean Valide = false;
		for(int i = 0; i < maison.size(); i++) {
			if(taille == maison.get(i).getTaille()) {
				Valide = true;
				break;
			}
		}
		return Valide;
	}
	
}