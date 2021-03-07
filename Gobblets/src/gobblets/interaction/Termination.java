package gobblets.interaction;


import gobblets.data.Joueur;
import gobblets.ihm.IHM;
import gobblets.ihm.Menu;


public class Termination extends Action {

	public Termination() {
		
	}
	
	public boolean verifier(Joueur player) {
		return true;
		
	}
	
	public void appliquer(Joueur player) {
		System.out.println(IHM.menu(Menu.MENU_QUITTER));
		System.exit(0);
	}
	
}