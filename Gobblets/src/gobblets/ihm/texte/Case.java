package gobblets.ihm.texte;

public class Case {
	
	private gobblets.data.Case contenu;
	
	public Case(gobblets.data.Case contenu) {
		this.contenu = contenu;
	}
	
	public String[] getRepresentationTextuelle() {
		String[] textCase = {"   "};
		if(contenu != null && contenu.plusGrandePiece() != null) {
			Piece piece = new Piece(contenu.plusGrandePiece());
			textCase[0] = piece.getRepresentationTextuelle()[0] + piece.getRepresentationTextuelle()[1] + piece.getRepresentationTextuelle()[2];
		}
		return textCase;
	}

}
