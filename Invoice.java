package task11;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Scanner;


public class Invoice {
		
	public static void main(String[] args) {
		
		//create a new file to write to
		Formatter newFile = null;
		try {
			newFile = new Formatter("/Users/taqua/Dropbox/Chevaun Martin-117761/2. Advanced Programming Concepts/Task 11/invoice.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//initialise variables
		//Customer Details
		String orderNum = "";
		String customerName = "";
		String customerContact = "";
		String customerLocation = "";
		String customerStreet = "";
		String customerSuburb = "";
		String customerEmail = "";
		
		//Restaurant Details
		String restaurantName = "";
		String restContact = "";
		String restaurantLocation = "";
		String menuItem = "";
		int mealQty = 0;
		float mealPrice = 0;
		ArrayList<String> menuItems = new ArrayList<String>();
		ArrayList<Integer> mealsQty = new ArrayList<Integer>();
		ArrayList<Float> mealsPrice = new ArrayList<Float>();
		String specPrep = "";
		
		//Driver details
		ArrayList<Driver> driversarraylist = new ArrayList<Driver>();
		Driver newDriver = new Driver ("", "", 0);
		
		//read drivers from txt file and store driver objects in an array so that they can be sorted
		try {
			File readFile = new File("/Users/taqua/Dropbox/Chevaun Martin-117761/2. Advanced Programming Concepts/Task 7/drivers.txt");
			Scanner sc = new Scanner(readFile);
			sc.useDelimiter(", \n");
			String allDrivers = sc.next();
			String driverList[] = allDrivers.split("\n");
			String[] splitArray;
			Driver newArray[][] = new Driver[30][3];

			for (int i = 0; i < driverList.length; i++) {
				splitArray = driverList[i].split(", ");
				String name = splitArray[0];
				String location = splitArray[1];
				String load = splitArray[2].trim();
				//replacing "" with "0" to handle the one driver in the txt file that does not have a load
				if (load.equals("")) {
					load = "0";
				}
				Driver d = new Driver(name, location, Integer.parseInt(load));
				driversarraylist.add(d);
			}
			
			//Sort the array list by the load (ascending)
			Collections.sort(driversarraylist, new SortbyLoad());

		}
		catch (FileNotFoundException e) {
			System.out.println("Could not read the txt file");
		}
		
		//Request customer location			
		customerLocation = promptUserStr("Enter Customer City:");

		//check if the customer location matches a driver location. Terminate the program and print an apology if a driver is not available.
		boolean custLocation = false;
		for (int i = 0; i < driversarraylist.size(); i++) {
			if	(driversarraylist.get(i).driverLocation.equalsIgnoreCase(customerLocation)) {
				custLocation = true;
				break;
			} 
		}
		
		if (custLocation == false) {
			String noDrivers = "Sorry! Our drivers are too far away from you to be able to deliver to your location.";
			newFile.format("%s", noDrivers);
			newFile.close();
			System.out.print(noDrivers);
		}
		
		//Request customer details
		if (custLocation == true) {

			orderNum = promptUserStr("Enter you order number:");
			
			customerName = promptUserStr("Enter customer name and surname:");
			
			customerEmail = promptUserStr("Enter customer email address:");
			
			customerContact = promptUserStr("Enter customer phone number:");

			customerStreet = promptUserStr("Enter customer street name and number:");

			customerSuburb = promptUserStr("Enter customer suburb:");
			
			restaurantName = promptUserStr("Enter the restaurant name:");

			restaurantLocation = promptUserStr("Enter the restaurant City:");
			
			//Check if a driver is available by looking up the location in the driver array list and comparing it to the restaurant city name
			//If no driver is available, terminate the program
			boolean driverAvailable = false;
			for (int i = 0; i < driversarraylist.size(); i++) {
				if	(driversarraylist.get(i).driverLocation.equalsIgnoreCase(restaurantLocation)) {
					newDriver = new Driver(driversarraylist.get(i).driverName, driversarraylist.get(i).driverLocation, driversarraylist.get(i).driverLoad);
					driverAvailable = true;
					break;
				} 
			}
			if (driverAvailable == false) {
				String noDrivers = "Sorry, no drivers available for this restaurant";
				newFile.format("%s", noDrivers);
				newFile.close();
				System.out.print(noDrivers);
			} else if (driverAvailable == true) {
			
			//Request restaurant details
			restContact = promptUserStr("Enter the restaurant contact number:");
	
			menuItem = promptUserStr("What menu item would you like to order?");
			menuItems.add(menuItem);
	
			mealQty = promptUserInt("How many?");
			mealsQty.add(mealQty);

			mealPrice = promptUserFloat("What is the price of this item?");
			mealsPrice.add(mealPrice);
			
			//Request a new menu item
			boolean status = true;
			while (status == true) {
				menuItem = promptUserStr("Add another menu item to your order:\nIf you have nothing else to add, type in 'done'");
				if (menuItem.equalsIgnoreCase("done")) {
					status = false;
					break;
				} else {
				menuItems.add(menuItem);
				}
				
				mealQty = promptUserInt("How many?");
				mealsQty.add(mealQty);
				
				mealPrice = promptUserFloat("What is the price of this item?");
				mealsPrice.add(mealPrice);
			}
				
			specPrep = promptUserStr("Do you have any special preparation instructions to add? Type the instructions here, or type 'none' if you have none.");
	
			//Create new objects
			Customer cust  = new Customer(orderNum, customerName, customerContact, customerStreet, customerSuburb, customerLocation, customerEmail);
			Restaurant newRest = new Restaurant(restaurantName, restaurantLocation, restContact, specPrep);
			Order newOrder = new Order(mealsQty, menuItems, mealsPrice);
		
			//write data to invoice.txt file
			newFile.format("%s", cust.customerDetails());
			newFile.format("%s", newRest.restaurantDetails());
			newFile.format("%s", newOrder.orderDetails());
			newFile.format("%s", newRest.specialInstructions()); 
			newFile.format("%s", newOrder.orderTotal());  
			newFile.format("%s", newDriver.driverDetails());
			newFile.format("%s", cust.customerAddress());
			newFile.format("%s", newRest.restaurantContact());
			newFile.close();
			}
		}	
	}
	
	//method to request a string from a user
	private static String promptUserStr(String input) {
		
		System.out.println(input);
		Scanner methodScan = new Scanner(System.in);
		String inputLine = methodScan.nextLine();
		if (inputLine != "") {
			return inputLine;
		}
		return promptUserStr(input);
	}	
	
	//method to request a float from a user
	private static Float promptUserFloat(String input) {
		
		System.out.println(input);
		Scanner methodScan = new Scanner(System.in);
		if (methodScan.hasNextFloat()) {
			return methodScan.nextFloat();
		}
		System.out.print("Please only enter numbers - decimal separator must be a comma\n");
		return promptUserFloat(input);
	}	
	
	//method to request an integer from a user
	private static int promptUserInt(String input) {
		
		System.out.println(input);
		Scanner methodScan = new Scanner(System.in);
		if (methodScan.hasNextInt()) {
			return methodScan.nextInt();
		}
		System.out.print("Please only enter a whole number");
		return promptUserInt(input);
	}	
}


		
