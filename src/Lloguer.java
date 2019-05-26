package src;
import java.util.Date;

public class Lloguer {
	
	  private  Date data;
	  private int dies;
	  private Vehicle vehicle;
	  private static final double PLUS_LLOGUER_LLARG_BASIC = 1.5;
	  private static final double PLUS_LLOGUER_LLARG_GOLD = 2.5;
	  private static final int DIES_INICIALS_BASIC = 3;
	  private static final int DIES_INICIALS_GOLD = 2;
	  private final int PREU_VEHICLE_BASIC = 3;
	  private final int PREU_VEHICLE_GOLD = 4;
	  private final int PREU_VEHICLE_LUXE = 6;
	  
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
    
    public void setVehicle(Vehicle vehicle) {this.vehicle=vehicle;}
    
    public Vehicle getVehicle() {return vehicle;}
    
    public double quantitat() {
    	
    	double quantitat = 0;
    	
    	switch (this.getVehicle().getCategoria()){
    		case Vehicle.BASIC:
    			quantitat +=PREU_VEHICLE_BASIC;
    			if(this.getDies() > DIES_INICIALS_BASIC) {
    				quantitat += (this.getDies()- DIES_INICIALS_BASIC)*PLUS_LLOGUER_LLARG_BASIC;
    			}
    			break;
    		case Vehicle.GOLD:
    			quantitat +=PREU_VEHICLE_GOLD;
    			if(this.getDies() > DIES_INICIALS_GOLD) {
    				quantitat += (this.getDies()-DIES_INICIALS_GOLD)*PLUS_LLOGUER_LLARG_GOLD;
    			}
    			break;
    		case Vehicle.LUXE:
    			quantitat += this.getDies()*PREU_VEHICLE_LUXE;
    			break;
    	}
    	return quantitat;
    }
    
    public int bonificacions() {
    	int bonificacions = 0;
    	
    	 // afegeix lloguers freqüents
        bonificacions ++;

        // afegeix bonificació per dos dies de lloguer de Luxe
        if (this.getVehicle().getCategoria() == Vehicle.LUXE &&
                this.getDies()>1 ) {
            bonificacions ++;
        }
        
        return bonificacions;
    }
}

