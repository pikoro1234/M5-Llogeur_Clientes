package src;

import java.util.Vector;

public class Client{
	
	private String nif;
    private String nom;
    private String telefon;
    public Vector<Lloguer> lloguers;
    private static final double EUROS_PER_UNITAT_DE_COST = 30;

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
        return crea_cabecera()+implementa_detalle()+crea_fin_pag();
    }
    
    private String crea_cabecera() {
    	return "Informe de lloguers del client "+getNom() +" (" + getNif() + ")\n";
    }
    
    private String implementa_detalle() {
    	String resultat = "";
    	 for (Lloguer lloguer: lloguers) {
    	     
             resultat += "\t" +lloguer.getVehicle().getMarca()+" " +
             lloguer.getVehicle().getModel()+": "+(lloguer.unitatsDeCost() * EUROS_PER_UNITAT_DE_COST)+"€"+"\n";
         }
    	 return resultat;
    }
    
    private String crea_fin_pag() {
    	 return "Import a pagar: " + importeTotal() + "€\n" +"Punts guanyats: " + bonificacionsTotales() + "\n";
    	
    }
    
    //informe HTML
    
    public String informeHTML() {
    	return crea_cabeceraHTML()+crea_bodyHTML()+crea_footerHTML();
    }
    
    private String crea_cabeceraHTML() {
    	return "<h1>informe lloguers</h1>\n"+ 
    "<p>Informe de lloguers del client <em>" + getNom() +
    "</em> (<strong>" + getNif() + "</strong>)</p>\n" +
    "<table>\n<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>     ";
    }
    
    private String crea_bodyHTML() {
    	String resultat = "";
        for (Lloguer lloguer : lloguers) { 
            resultat += "<tr><td>" + lloguer.getVehicle().getMarca() + "</td><td>" +
                    lloguer.getVehicle().getModel() + "</td><td>" +
                    lloguer.unitatsDeCost() * EUROS_PER_UNITAT_DE_COST + "€</td></tr>\n";
        }
        return resultat;
    }
    	
    private String crea_footerHTML() {
    	 return "</table>\n" +
         "<p>Import a pagar: <em>" + importeTotal() +
         "€</em></p>\n" +
         "<p>Punts guanyats: <em>" + bonificacionsTotales() + "</em></p>";
    }
    
    
    private double importeTotal() {
    	double total = 0;
    	for(Lloguer lloguer : lloguers) {
    		total +=(lloguer.unitatsDeCost() * EUROS_PER_UNITAT_DE_COST);
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
