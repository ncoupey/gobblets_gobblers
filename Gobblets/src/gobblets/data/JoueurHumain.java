package gobblets.data;

import java.util.InputMismatchException;

import gobblets.ihm.Avertissement;
import gobblets.ihm.IHM;
import gobblets.ihm.texte.SaisieConsole;
import gobblets.interaction.Action;
import gobblets.interaction.Deplacement;
import gobblets.interaction.Placement;
import gobblets.interaction.Termination;

public class JoueurHumain extends Joueur{

	public JoueurHumain(String nom, Couleur couleur) {
		super(nom, couleur);
	}

	@Override
	public Action choisirAction(Plateau board)throws ArrayIndexOutOfBoundsException {
		SaisieConsole saisie = new SaisieConsole();
		ActionType typeAction = saisie.saisirAction(this);
		
		if(typeAction == ActionType.PLACER) {
			Taille taille = saisie.saisirTaille();
			System.out.println(IHM.avertissement(Avertissement.CHOIXDESTINATION));
			int[] destination = saisie.saisirCoordonnees(typeAction);
			Action placer = new Placement(taille, board.getPlateau()[destination[1]][destination[0]]);
			return placer;
		}
		else if(typeAction == ActionType.DEPLACER) {
				System.out.println(IHM.avertissement(Avertissement.CHOIXORIGIN));
				int[] origin = saisie.saisirCoordonnees(typeAction);
				System.out.println(IHM.avertissement(Avertissement.CHOIXDESTINATION));
				int[] destination =saisie.saisirCoordonnees(typeAction);
				Action deplacer = new Deplacement(board.getPlateau()[origin[1]][origin[0]], board.getPlateau()[destination[1]][destination[0]]);
				return deplacer;
			}
			else if(typeAction == ActionType.QUITTER) {
					Action quitter = new Termination();
					return quitter;
				}
				else {
					throw new ArrayIndexOutOfBoundsException();
			}
		}
		
}