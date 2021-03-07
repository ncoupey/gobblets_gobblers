package gobblets.data;

public enum Couleur {
	ROUGE(255,0,0,"RED"),
	BLEU(0,0,255,"BLUE"),
	VERT(0,255,0,"GREEN"),
	JAUNE(255,255,0,"YELLOW"),
	NOIR(0,0,0,"BLACK");
	
	private int r;
	private int v;
	private int b;
	private String code;
	
	public int getR() {
		return r;
	}


	public int getV() {
		return v;
	}

	public int getB() {
		return b;
	}
	
	public String getCode() {
		return code;
	}
	
	Couleur(int rouge, int vert, int bleu, String code){
		this.r=rouge;
		this.v=vert;
		this.b=bleu;
		this.code=code;
		}
	
	public String toString() {
		return code;
	}
}
