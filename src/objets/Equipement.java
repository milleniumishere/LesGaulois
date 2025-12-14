package objets;

public enum Equipement {
    Casque("casque"),
    Bouclier("bouclier");

    private String nom;

    Equipement(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "nom='" + nom + '\'' +
                "} " + super.toString();
    }

    public String getNom() {
        return nom;
    }
}
