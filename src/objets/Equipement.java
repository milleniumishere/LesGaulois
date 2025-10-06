package objets;

public enum Equipement {
	CASQUE("casque"), BOUCLIER("bouclier");

	private String nom;
	
	private Equipement(String nom) {
		this.nom=nom;
	}
	
	public String toString() {
		return nom;
	}
	
	public static void main(String[] args) {
        Equipement e = Equipement.CASQUE;
        System.out.println(e);
    }
}
