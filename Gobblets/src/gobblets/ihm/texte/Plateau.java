package gobblets.ihm.texte;

public class Plateau {
	
	private gobblets.data.Plateau board;
	private Case[] plateauAffichable = new Case[9];
	
	public Plateau(gobblets.data.Plateau board) {
		this.board = board;
		int nbTab = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				Case box = new Case(board.getPlateau()[i][j]);
				plateauAffichable[nbTab] = box;
				nbTab++;
			}
		}
	}
	
	public String[] getRepresentationTextuelle() {
		String[] textPlateauHolder = {" ","|"," ","|"," ","",
								" ","|"," ","|"," ","",
								" ","|"," ","|"," ",""};
		for(int i = 0; i < 9; i++) {
			textPlateauHolder[i*2] = plateauAffichable[i].getRepresentationTextuelle()[0];
		}
		String[] textPlateau = {"", "", ""};
		textPlateau[0] = textPlateauHolder[0] + textPlateauHolder[1] + textPlateauHolder[2] + textPlateauHolder[3] + textPlateauHolder[4];
		textPlateau[1] = textPlateauHolder[6] + textPlateauHolder[7] + textPlateauHolder[8] + textPlateauHolder[9] + textPlateauHolder[10];
		textPlateau[2] = textPlateauHolder[12] + textPlateauHolder[13] + textPlateauHolder[14] + textPlateauHolder[15] + textPlateauHolder[16];
		return textPlateau;
	}
	
}
