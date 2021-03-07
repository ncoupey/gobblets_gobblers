package gobblets.logic;

import gobblets.ihm.Erreur;

public class CaseBloqueeException extends Exception {

	private static final long serialVersionUID = 0;

	public CaseBloqueeException(){
		super();
	}	
	
	public CaseBloqueeException(String mot){
		super(mot);
	}	
	
	public CaseBloqueeException(Throwable truc){
		super(truc);
	}	
	
	public CaseBloqueeException(String mot, Throwable truc){
		super(mot, truc);
	}	
	
	public CaseBloqueeException(String mot, Throwable truc, boolean b1,boolean b2){
		super(mot, truc, b1, b2);
	}	
	
	public CaseBloqueeException(Erreur error){
		System.out.println(error);
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Erreur getErreur() {
		return Erreur.CASEBLOQUEE;
	}
	
}
