package src;

import java.text.ParseException;

import java.text.SimpleDateFormat;


public class GestorLloguersLite {

    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    
    public static void main(String[] args) throws ParseException {
    	
    	NuevoCliente();
    	
    }

    
    public static Client NuevoCliente() throws ParseException {
    		
    		Client client = new Client("111222","jorge", "12345678");
    		Vehicle auto = new Vehicle("Ferrari", "murci",Vehicle.LUXE);
    		Lloguer llog = new Lloguer(dateFormat.parse("01/10/19"),1,new Vehicle("piccanto","kia",Vehicle.BASIC));
    		llog.setVehicle(auto);
    		client.afegeix(new Lloguer(dateFormat.parse("01/10/19"),1,new Vehicle("piccanto","kia",Vehicle.BASIC)));
    		client.afegeix(new Lloguer(dateFormat.parse("10/10/19"),1,new Vehicle("toyota","prius",Vehicle.GOLD)));
    		System.out.println("datos prueba "+client.getNom()+" "+client.getNif()+" "+client.contaLloguers());
    		System.out.println("cantidad alquilados "+client.contaLloguers()+ " ");
    		
    		System.out.println("fechas "+llog.bonificacions());
    		System.out.println("auto: "+auto.getCategoria()+auto.getMarca()+auto.getModel()+"get vehiculo "+llog.getVehicle());
    		return client;
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
