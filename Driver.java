package task11;

public class Driver {
	
	String driverName = "";
	String driverLocation = "";
	int driverLoad = 0;
	
	//Constructor
	public Driver(String driverName, String driverLocation, int driverLoad) {
	   this.driverName = driverName;
	   this.driverLocation = driverLocation;
	   this.driverLoad = driverLoad;
	}
	
		//Method to print closest driver details
	public String driverDetails() { 
		String output = "\n\n";
		output += driverName + " is the nearest to the restaurant so he will be delivering your order to you at:\n" ;

		return output;
	}
	
	//Method to print driver error message
	public String noDriver() { 
		String output = "Sorry, no drivers";
		
		return output;
	}
}
