package task11;

public class Restaurant {
	String restaurantName = "";
	String restaurantLocation = "";
	String restaurantContact = "";
	String specInstructions = "";
	
	//Constructor
	public Restaurant(String restaurantName, String restaurantLocation, String restaurantContact, String specInstructions) {
	   this.restaurantName = restaurantName;
	   this.restaurantLocation = restaurantLocation;
	   this.restaurantContact = restaurantContact;
	   this.specInstructions = specInstructions;
   
	}
	
	//Method to print restaurant details
	public String restaurantDetails() { 
		  String output = "";
		  output += "\n\nYou have ordered the following from " + restaurantName + " in " + restaurantLocation + ":";

		  return output;
	}
	
	//Method to print special instructions
	public String specialInstructions() { 
		  String output = "\n\nSpecial Instructions: ";
		  output += specInstructions + "\n";
		  
		  return output;
	}

	//Method to print restaurant contact
	public String restaurantContact() { 
		  String output = "\nIf you need to contact the restaurant, their number is " + restaurantContact + ".";
		  
		  return output;
	}
}
