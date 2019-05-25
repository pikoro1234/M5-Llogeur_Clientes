package src;


import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.Test;

public class TestInforme {
	/*
	 * Client jorge = new Client("y39164503p ","Jorge Fiorilo", "987654321");
        
        jorge.afegeix(new Lloguer(dateFormat.parse("10/11/2019"),10,new Vehicle("toyota", "Runner", Vehicle.GOLD)));
        
        jorge.afegeix(new Lloguer(dateFormat.parse("05/02/2018"),15,new Vehicle("nissan", "Pathfinder", Vehicle.LUXE)));
        
        jorge.afegeix(new Lloguer(dateFormat.parse("25/07/2019"),20,new Vehicle("kia", "Piccanto", Vehicle.BASIC)));
       
	 * resultat = "Informe de lloguers del client " +
                getNom() +
                " (" + getNif() + ")\n"
                
                  resultat += "\t" +
                    lloguer.getVehicle().getMarca() +
                    " " +
                    lloguer.getVehicle().getModel() + ": " +
                    (quantitat * 30) + "€" + "\n";
                
                
                
                 resultat += "Import a pagar: " + total + "€\n" +
                "Punts guanyats: " + bonificacions + "\n";
        return resultat;
	 */

	@Test
	public void TestInforme() throws ParseException {
		
		Client cliente = GestorLloguersLite.NuevoCliente();
		
		assertEquals(cliente.informe(),"Informe de lloguers del client Jorge Fiorilo (y39164503p)\n"+
		"kia Piccanto:  );
				
	}
}
