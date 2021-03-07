package gobblets.data;

public enum Taille {
	PETITE('p') {
		public boolean Recouvre(Taille taille) {
			return false;
		}
	},
	MOYENNE('m'){
		public boolean Recouvre(Taille taille) {
				if(taille==PETITE) {
					return true;
				}
				else {
					return false;
				}
		}
	},
	GRANDE('g'){
		public boolean Recouvre(Taille taille) {
			if(taille==PETITE || taille==MOYENNE) {
				return true;
			}
			else {
				return false;
			}
		}
	};
	private char symbole;

	public char getSymbole() {
		return symbole;
	}
	Taille(char symbole){
		this.symbole=symbole;
	}
	
	public boolean Recouvre(Piece piece) {
		Taille taillePiece = piece.getTaille();
		return Recouvre(taillePiece);
		
		
	}
	public abstract boolean Recouvre(Taille taille);

}

