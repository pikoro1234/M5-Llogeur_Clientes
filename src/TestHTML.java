package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class TestHTML {

	@Test
    public void testInformeHTML() throws ParseException {
        Client client = GestorLloguersLite.NuevoCliente();

        assertEquals(client.informeHTML(), "<h1>Informe de lloguers</h1>\n" +
                "<p>Informe de lloguers del client <em>jorge</em> (<strong>111222</strong>)</p>\n" +
                "<table>\n" +
                "<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>     <tr><td>Tata</td><td>Vista</td><td>405.0€</td></tr>\n" +
                "    <tr><td>Volkswagen</td><td>Sirocco</td><td>1470.0€</td></tr>\n" +
                "    <tr><td>Kawasaki</td><td>Ninja</td><td>5400.0€</td></tr>\n" +
                "<tr><td>Volkswagen</td><td>Sirocco</td><td>1470.0€</td></tr>\n" +
                "<tr><td>Kawasaki</td><td>Ninja</td><td>5400.0€</td></tr>\n" +
                "</table>\n" +
                "<p>Import a pagar: <em>7275.0€</em></p>\n" +
                "<p>Punts guanyats: <em>4</em></p>\n"+
                "<p>Punts guanyats: <em>4</em></p>");
    }

    @Test
    public void testInformeHTMLSenseLloguer() {
    	Client client = new Client("111222","jorge", "12345678");
        assertEquals(client.informeHTML(), "<h1>Informe de lloguers</h1>\n" +
                "<p>Informe de lloguers del client <em>jorge</em> (<strong>111222</strong>)</p>\n" +
                "<table>\n" +
                "<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>     </table>\n" +
                "<p>Import a pagar: <em>0.0€</em></p>\n" +
                "<p>Punts guanyats: <em>0</em></p>\n"+
                "<p>Punts guanyats: <em>0</em></p>");
    }

}
