import java.text.ParseException;

import java.text.SimpleDateFormat;

public class GestorLloguersLite {

    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) throws ParseException {
    
        Client jorge = new Client("y39164503p ","Jorge Fiorilo", "987654321");
        
        jorge.afegeix(new Lloguer(dateFormat.parse("10/11/2019"),10,new Vehicle("toyota", "Runner", Vehicle.GOLD)));
        
        jorge.afegeix(new Lloguer(dateFormat.parse("05/02/2018"),15,new Vehicle("Nissan", "Pathfinder", Vehicle.LUXE)));
        
        jorge.afegeix(new Lloguer(dateFormat.parse("25/07/2019"),20,new Vehicle("Kia", "Piccanto", Vehicle.BASIC)));
       
       
        System.out.println(toString(jorge));

    }

  	 public static String toString(Client client) {
        String string = "Client: " + client.getNom() + "\n\t\t"
                        + client.getNif() + "\n\t\t"
                        + client.getTelefon() + "\n"
                        + "Lloguers: " + client.contaLloguers() + "\n\t\t";

        for (int x = 0; x < client.contaLloguers(); x++){
            string += x + 1 + ".\tvehicle: " + client.lloguers.get(x).getVehicle().getMarca()
                    + " " + client.lloguers.get(x).getVehicle().getModel() + "\n\t\t\t" +
                    "data d'inici: " + dateFormat.format(client.lloguers.get(x).getData()) + "\n\t\t\t" +
                    "dies llogats: " + client.lloguers.get(x).getDies() + "\n\t\t";
        }

        return string;
    }
}
