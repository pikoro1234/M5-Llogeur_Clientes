package src;

import java.util.Vector;

public class Client{
	

	private String nif;
    private String nom;
    private String telefon;
    public Vector<Lloguer> lloguers;

    public Client(String nif, String nom, String telefon) {
    this.nif = nif;
    this.nom = nom;
    this.telefon = telefon;
    this.lloguers = new Vector<Lloguer>();
    }
    
    public String getNif()     { return nif;     }
    public String getNom()     { return nom;     }
    public String getTelefon() { return telefon; }

    public void setNif(String nif) { this.nif = nif; }
    public void setNom(String nom) { this.nom = nom; }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public void afegeix(Lloguer lloguer) {
       if (! lloguers.contains(lloguer) ) {
            lloguers.add(lloguer);
        }
    }
    public void elimina(Lloguer lloguer) {
        if (lloguers.contains(lloguer) ) {
            lloguers.remove(lloguer);
        }
    }
    public boolean conte(Lloguer lloguer) {
        return lloguers.contains(lloguer);
    }
    
    
    
    ////////
    public String informe() {
        // XXX: de moment buit
    	
    	
        double total = 0;
     
        String resultat = "Informe de lloguers del client " +
                getNom() +
                " (" + getNif() + ")\n";
        for (Lloguer lloguer: lloguers) {
       
            double quantitat = lloguer.quantitat();

            // composa els resultats d'aquest lloguer
            resultat += "\t" +
                    lloguer.getVehicle().getMarca() +
                    " " +
                    lloguer.getVehicle().getModel() + ": " +(lloguer.quantitat() * 30)+"€"+"\n";
        }

        // afegeix informació final
        resultat += "Import a pagar: " + importeTotal() + "€\n" +
                "Punts guanyats: " + bonificacionsTotales() + "\n";
        return resultat;
    }
    
    private double importeTotal() {
    	double total = 0;
    	for(Lloguer lloguer : lloguers) {
    		total +=lloguer.quantitat()*30;
    	}
    	return total;
    }
    
    private int bonificacionsTotales() {
    	int bonificacions = 0;
    	for	(Lloguer lloguer : lloguers) {
    		bonificacions += lloguer.bonificacions();
    	}
    	return bonificacions;
    }

    public int contaLloguers() {
        return lloguers.size();
    }
} 
