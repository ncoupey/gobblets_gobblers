package gobblets.logic;

import gobblets.ihm.Erreur;
import gobblets.ihm.IHM;

public class PiecePasDisponibleException extends Exception {
	
	private static final long serialVersionUID = 0;
	
	public PiecePasDisponibleException() {
		super();
	}	
	
	public PiecePasDisponibleException(String mot) {
		super(mot);
	}	
	
	public PiecePasDisponibleException(Throwable truc) {
		super(truc);
	}
	
	public PiecePasDisponibleException(String mot, Throwable truc) {
		super(mot, truc);
	}	
	
	public PiecePasDisponibleException(String mot, Throwable truc, boolean b1, boolean b2) {
		super(mot, truc, b1, b2);
	}	
	
	public PiecePasDisponibleException(Erreur error) {
		System.out.println(IHM.erreur(error));
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Erreur getErreur() {
		return Erreur.PASDEPIECEDISPONIBLE;
		
	}
	
}
