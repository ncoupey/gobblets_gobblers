package gobblets.logic;
import java.util.*;
import gobblets.data.Etat;
import gobblets.data.Joueur;
import gobblets.data.Plateau;
import gobblets.ihm.Erreur;
import gobblets.ihm.IHM;
import gobblets.ihm.texte.SaisieConsole;

public class Jeu {
	Etat etat = Etat.JEUENCOURS;
	Plateau plateau = Plateau.initPlateau();
	Joueur j1;
	Joueur j2;
	Joueur joueurActif =j2;
	int nbTour=1;
	
	public Jeu() {
		j1 = this.getJ1();
		j2= this.getJ2();

	}
	
	public Jeu(Joueur j1, Joueur j2) {
		this.j1 = j1;
		this.j2= j2;
		for(int i = 0; i < plateau.getMaisonJoueur1().size(); i++) {
            plateau.getMaisonJoueur1().get(i).setCouleur(j1.getCouleur());
        }
		j1.setPieces(plateau.getMaisonJoueur1());
		for(int i = 0; i < plateau.getMaisonJoueur2().size(); i++) {
            plateau.getMaisonJoueur2().get(i).setCouleur(j2.getCouleur());
        }
		j2.setPieces(plateau.getMaisonJoueur2());
	}
	
	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	
	public Plateau getPlateau() {
		return plateau;
	}
	
	private Etat unTour(int nbTour) {
		Etat etatJeu= Etat.JEUENCOURS;
		changeJoueur();
		Joueur j = this.getJoueurActif();
		SaisieConsole saisie = new SaisieConsole();
		saisie.display(plateau,j);
		int test = 0;
		do {
			try {
			j.choisirAction(plateau).appliquer(j);
			test = 1;
			}
			catch (CaseBloqueeException e) {
				System.out.println(IHM.erreur(Erreur.CASEBLOQUEE));
			}
			catch (PiecePasDisponibleException e) {
				System.out.println(IHM.erreur(Erreur.PASDEPIECEDISPONIBLE));
			}
			catch(InputMismatchException e) {
				System.out.println(IHM.erreur(Erreur.ARGUMENTINCORRECT));
			}
			catch(IllegalArgumentException e) {
				System.out.println(IHM.erreur(Erreur.ARGUMENTINCORRECT));
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println(IHM.erreur(Erreur.ARGUMENTINCORRECT));
			}
		}while(test == 0);
		if(plateau.verifierDiagonale('p') == j.getCouleur() || plateau.verifierDiagonale('s') == j.getCouleur()) {
			if(j == j1) {
				etatJeu= Etat.JOUEUR1GAGNE;
			}
			else if(j == j2) {
				etatJeu= Etat.JOUEUR2GAGNE;
			}
			else {
				etatJeu=Etat.JEUENCOURS;
			}
		}
		for(int i=0;i<=1;i++) {
			j = this.getJoueurActif();
			for(int k =0; k<=2;k++) {
				if(plateau.verifierLigne(k) == j.getCouleur() || plateau.verifierColonne(k) == j.getCouleur()) {
					if(j == j1) {
						saisie.display(plateau,j);
						etatJeu= Etat.JOUEUR1GAGNE;
					}
					else if(j == j2) {
						saisie.display(plateau,j);
						etatJeu= Etat.JOUEUR2GAGNE;
					}
					else {
						etatJeu=Etat.JEUENCOURS;
						}
					}
				}
				changeJoueur();
			}
			
			return etatJeu;
	}
	
	public void verifWin() {
		Joueur j = this.getJoueurActif();
		if(plateau.verifierDiagonale('p') == j.getCouleur() || plateau.verifierDiagonale('s') == j.getCouleur()) {
			if(j == j1) {
				this.etat= Etat.JOUEUR1GAGNE;
			}
			else if(j == j2) {
				this.etat= Etat.JOUEUR2GAGNE;
			}
			else {
				this.etat=Etat.JEUENCOURS;
			}
		}
		for(int i=0;i<=1;i++) {
			j = this.getJoueurActif();
			for(int k =0; k<=2;k++) {
				if(plateau.verifierLigne(k) == j.getCouleur() || plateau.verifierColonne(k) == j.getCouleur()) {
					if(j == j1) {
						this.etat= Etat.JOUEUR1GAGNE;
					}
					else if(j == j2) {
						this.etat= Etat.JOUEUR2GAGNE;
					}
					else {
						this.etat=Etat.JEUENCOURS;
						}
					}
				}
			}
	}
	
	public Etat play() {
		 etat = unTour(nbTour);
		 this.nbTour += 1;
		 return etat;
		 
		
	}
	
	public void changeJoueur() {
		if(joueurActif == j1) {
			joueurActif =j2;
		}
		else {
			joueurActif = j1;
		}
	}

	public Joueur getJ1(){
		int erreur = 1;
		do {
			try {
				SaisieConsole saisie =new SaisieConsole();
				j1=saisie.saisirJoueur(1);
				for(int i = 0; i < plateau.getMaisonJoueur1().size(); i++) {
	                plateau.getMaisonJoueur1().get(i).setCouleur(j1.getCouleur());
	            }
				j1.setPieces(plateau.getMaisonJoueur1());
				erreur = 0;
			}catch (IllegalArgumentException e){
				System.out.println(IHM.erreur(Erreur.ARGUMENTINCORRECT));

				System.out.println(" "); 
				erreur = 1;

				}
		}while(erreur ==1);
		return j1;

	}

	public Joueur getJ2() {
		int erreur = 1;
		do {
			try {
				SaisieConsole saisie =new SaisieConsole();
				j2=saisie.saisirJoueur(2);
				for(int i = 0; i < plateau.getMaisonJoueur2().size(); i++) {
	                plateau.getMaisonJoueur2().get(i).setCouleur(j2.getCouleur());
	            }
				j2.setPieces(plateau.getMaisonJoueur2());
				erreur = 0;
				if(j1.getCouleur() == j2.getCouleur()) {
					erreur =1;
					System.out.println(IHM.erreur(Erreur.ARGUMENTINCORRECT));
				}
			}catch (IllegalArgumentException e){
				System.out.println(IHM.erreur(Erreur.ARGUMENTINCORRECT));
				System.out.println(" ");
				erreur = 1;
				}
		}while(erreur ==1);
		return j2;

	}

	public Joueur getJoueurActif() {
		return joueurActif;
	}

	

}
