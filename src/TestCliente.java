package src;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

public class TestCliente {
	
	static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	@Test
	public void TestInforme() throws ParseException {
		
		Client cliente = GestorLloguersLite.NuevoCliente();
		
		assertEquals(cliente.contaLloguers(), 2);
	}
	
	@Test
	public void TestInformeSenseLloguer() {
		
		Client client = new Client("111222","jorge", "12345678");
	        assertEquals(client.informe(), "Informe de lloguers del client jorge (111222)\n" +
	                "Import a pagar: 0.0€\n" +
	                "Punts guanyats: 0\n");
	}
	
	@Test 
	public void TestInformeVariosDias()throws ParseException{
		Client client = new Client("111222","jorge", "12345678");
        client.afegeix(new Lloguer(dateFormat.parse("01/10/2019"),
                100,new Vehicle("piccanto", "kia", Vehicle.BASIC)));

        assertEquals(client.informe(), "Informe de lloguers del client jorge(111222)\n" +
                "\tkia piccanto: 4455.0€\n" +
                "Import a pagar: 4455.0€\n" +
                "Punts guanyats: 1\n");
		
	}
	
	@Test
	public void TestInformeLloguerBasicUndia() throws ParseException{
		Client client = new Client("111222","jorge", "12345678");
        client.afegeix(new Lloguer(dateFormat.parse("01/10/2019"),
                1,new Vehicle("piccanto", "kia", Vehicle.BASIC)));

        assertEquals(client.informe(), "Informe de lloguers del client jorge(111222)\n" +
                "\tkia piccanto: 90.0€\n" +
                "Import a pagar: 90.0€\n" +
                "Punts guanyats: 1\n");	
	}
	
	@Test
    public void testInformeLloguerGoldMoltsDies() throws ParseException {
		Client client = new Client("111222","jorge", "12345678");
		 client.afegeix(new Lloguer(dateFormat.parse("01/10/2019"),
	            100,new Vehicle("piccanto", "kia", Vehicle.GOLD)));

        assertEquals(client.informe(), "Informe de lloguers del client jorge(111222)\n" +
                "\tkia piccanto: 7470.0€\n" +
                "Import a pagar: 7470.0€\n" +
                "Punts guanyats: 1\n");
    }

    @Test
    public void testInformeLloguerGoldUnDia() throws ParseException {
    	Client client = new Client("111222","jorge", "12345678");
		 client.afegeix(new Lloguer(dateFormat.parse("01/10/2019"),
	            1,new Vehicle("piccanto", "kia", Vehicle.GOLD)));


        assertEquals(client.informe(), "Informe de lloguers del client jorge(111222)\n" +
                "\tkia piccanto: 120.0€\n" +
                "Import a pagar: 120.0€\n" +
                "Punts guanyats: 1\n");
    }

    @Test
    public void testInformeLloguerLuxeMoltsDies() throws ParseException {
    	Client client = new Client("111222","jorge", "12345678");
		 client.afegeix(new Lloguer(dateFormat.parse("01/10/2019"),
	          100,new Vehicle("piccanto", "kia", Vehicle.LUXE)));

      
        assertEquals(client.informe(), "Informe de lloguers del client jorge(111222)\n" +
                "\tkia piccanto: 18000.0€\n" +
                "Import a pagar: 18000.0€\n" +
                "Punts guanyats: 2\n");
    }

    @Test
    public void testInformeLloguerLuxeUnDia() throws ParseException {
    	Client client = new Client("111222","jorge", "12345678");
		 client.afegeix(new Lloguer(dateFormat.parse("01/10/2019"),
				 1,new Vehicle("piccanto", "kia", Vehicle.LUXE)));
		 
		 
        assertEquals(client.informe(), "Informe de lloguers del client jorge(111222)\n" +
                "\tkia piccanto: 180.0€\n" +
                "Import a pagar: 180.0€\n" +
                "Punts guanyats: 1\n");
    }
}


