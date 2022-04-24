package task11;

public class Customer {
	String orderNum;
	String customerName;
	String customerContact;
	String customerStreet;
	String customerSuburb;
	String customerLocation;
	String customerEmail;
	
	//Constructor
	public Customer(String orderNum, String customerName, String customerContact, String customerStreet, String customerSuburb, String customerLocation, String customerEmail) {
	   this.orderNum = orderNum;
	   this.customerName = customerName;
	   this.customerContact = customerContact;
	   this.customerStreet = customerStreet;
	   this.customerSuburb = customerSuburb;
	   this.customerLocation = customerLocation;
	   this.customerEmail = customerEmail;
	    
	}

	//Method to print customer details
	public String customerDetails() { 
		  String output = "";
		  output += "Order Number " + orderNum;
		  output += "\nCustomer: " + customerName;
		  output += "\nEmail: " + customerEmail;
		  output += "\nPhone Number: " + customerContact;
		  output += "\nLocation: " + customerLocation;

		  return output;
		  }
	
	//Method to print customer address
	public String customerAddress() { 
		  String output = "\n";
		  output += customerStreet + "\n" + customerSuburb + "\n";

		  return output;
		  }
	
}


