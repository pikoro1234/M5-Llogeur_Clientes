package src;
import java.util.Date;

public class Lloguer {
	
	  private  Date data;
	  private int dies;
	  private Vehicle vehicle;
	  
	public Lloguer(String data, int dies) {
		
	}
	
	public Lloguer(Date data, int dies,Vehicle vehicle) {
        this.data = data;
        this.dies = dies;
    }

    public Date getData() { return data; }

    public int getDies() { return dies; }

    public void setData(Date data) { this.data = data; }

    public void setDies(int dies) { this.dies = dies; }
    
    public void setVehicle(Vehicle vehicle) {this.vehicle = vehicle;}
    
    public Vehicle getVehicle() {return vehicle;}
 
    }

