package objets;

import personnages.Gaulois;

public class Trophee {
    private Gaulois gaulois;
    private Equipement equipement;

    public Trophee(Equipement equipement, Gaulois gaulois) {
        this.equipement = equipement;
        this.gaulois = gaulois;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public Gaulois getGaulois() {
        return gaulois;
    }
    
    public String donnerNom(){
        return gaulois.getNom();
    }

}
