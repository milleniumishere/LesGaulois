package personnages;

public class Chaudron {
	private int quantitePotion=0;
	private int forcePotion=0;
	
	public Chaudron() {
		super();
	}

	public boolean resterPotion() {
		return quantitePotion>0;
	}
	
	public void remplirChaudron(int quantite, int forcePotion) {
		this.quantitePotion=quantite;
		this.forcePotion=forcePotion;
	}
	
	public int prendreLouche() {
		quantitePotion--;
		int tempVar = forcePotion;
		if(quantitePotion<=0) {
			forcePotion=0;
		}
		return tempVar;
	}
}
