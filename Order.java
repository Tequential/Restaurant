package task11;

import java.util.ArrayList;
import java.text.DecimalFormat;

public class Order{
	
	DecimalFormat df = new DecimalFormat("#.00");
	ArrayList<String> menuItems = new ArrayList<String>();
	ArrayList<Integer> mealsQty = new ArrayList<Integer>();
	ArrayList<Float> itemPrice = new ArrayList<Float>();
	
	
	//Constructor for menu items
	public Order(ArrayList<Integer> mealsQty, ArrayList<String> menuItems, ArrayList<Float> itemPrice) {
		this.menuItems = menuItems;
		this.mealsQty = mealsQty;
		this.itemPrice = itemPrice;
	}
	
	//Method to print order details
	public String orderDetails() { 
		  String output = "";
		  for (int i = 0; i < menuItems.size(); i++ ) {
		  output += "\n\n" + mealsQty.get(i) + " x " + menuItems.get(i) + " (R" + df.format(itemPrice.get(i)) + ")" ;
		  }

		  return output;
	}

	//Method to print total value
	public String orderTotal() { 
		  String output = "";
		  Float price = 0f;
		  Float qty = 0f;
		  Float total = 0f;
		  for (int i = 0; i < menuItems.size(); i++ ) {
			  price = itemPrice.get(i);
			  qty = (float) mealsQty.get(i);
			  total += (price * qty);
		  }
		  
		  output = "\nTotal: " + "R" + df.format(total);
		  return output;
	}
	
}
