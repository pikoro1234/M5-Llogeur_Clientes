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
    }
    
    public String informe() {
        // XXX: de moment buit
        return null;
    }

    public int contaLloguers() {
        return lloguers.size();
    }
} 
