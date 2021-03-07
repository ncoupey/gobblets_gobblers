package gobblets.ihm.texte;

import java.util.Scanner;

import gobblets.data.ActionType;
import gobblets.data.Couleur;
import gobblets.data.Joueur;
import gobblets.data.JoueurHumain;
import gobblets.data.Plateau;
import gobblets.data.Taille;
import gobblets.ihm.Avertissement;
import gobblets.ihm.IHM;

public class SaisieConsole extends IHM {

	public static final Scanner sc = new Scanner(System.in);
	
	public SaisieConsole() {
		
	}

	@Override
	public Joueur saisirJoueur(int a) throws IllegalArgumentException{
		System.out.println(avertissement(Avertissement.NOMJOUEUR)+" "+a);
		String nom = sc.next();
		System.out.println(avertissement(Avertissement.COULEURJOUEUR));
		Couleur color = Couleur.valueOf(sc.next().toUpperCase());
		if(color instanceof Couleur){
			Joueur player = new JoueurHumain(nom, color);
			return player;
		}else throw new IllegalArgumentException();
	}

	@Override
	public ActionType saisirAction(Joueur player) {
		System.out.println(avertissement(Avertissement.CHOIXACTION));
		ActionType action = ActionType.valueOf(sc.next().toUpperCase());
		return action;
	}

	@Override
	public Taille saisirTaille() {
		System.out.println(avertissement(Avertissement.CHOIXTAILLE));
		Taille size = Taille.valueOf(sc.next().toUpperCase());
		return size;
	}

	@Override
	public int[] saisirCoordonnees(ActionType action) {
		System.out.print("x: ");
		int x = sc.nextInt();
		System.out.print("y: ");
		int y = sc.nextInt();
		int[] coordonnees = {x,y};
		return coordonnees;
	}

	@Override
	public void display(Plateau board, Joueur player) {
		gobblets.ihm.texte.Plateau affichePlateau = new gobblets.ihm.texte.Plateau(board);
		Piece holder;
		System.out.println("   0   1   2 ");
		System.out.println("0 " + affichePlateau.getRepresentationTextuelle()[0]);
		System.out.println("  ---+---+---");
		System.out.println("1 " + affichePlateau.getRepresentationTextuelle()[1]);
		System.out.println("  ---+---+---");
		System.out.println("2 " + affichePlateau.getRepresentationTextuelle()[2]);
		System.out.println("");
		for(int i = 0; i < board.getMaisonJoueur1().size(); i++) {
			holder = new Piece(board.getMaisonJoueur1().get(i));
			System.out.print(holder.getRepresentationTextuelle()[1] + " ");
		}
		System.out.println("");
		for(int j = 0; j < board.getMaisonJoueur2().size(); j++) {
			holder = new Piece(board.getMaisonJoueur2().get(j));
			System.out.print(holder.getRepresentationTextuelle()[1] + " ");
		}
		System.out.println("");
		System.out.println("");
		System.out.println(avertissement(Avertissement.TONTOUR) + ", " + player.getNom());
	}
	
	public void finalize() {
		sc.close();
	}
	
}
