package app;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonParser.Feature;


public class Inventory {
private static ArrayList<Product> inventoryList;
public Inventory() {
	inventoryList = new ArrayList<Product>();
	try {
	readFromFile(); }
	catch(JsonMappingException e) {
		e.printStackTrace();
	}
	catch(JsonGenerationException e) {
		e.printStackTrace();
	}
	catch(JsonProcessingException e) {
		e.printStackTrace();
	}

}
public static void readFromFile() throws JsonMappingException, JsonProcessingException {
	String filename = "Stock.json";
	
	try {
		File file = new File(filename);
		Scanner s = new Scanner(file);
		
		ObjectMapper objectmapper = new ObjectMapper(); // error here

		while (s.hasNext()) {
			String json = s.nextLine();
			if(json.contains("damage")) {
				Product item = objectmapper.readValue(json, Weapon.class);
				addItem(item);
			}
			if(json.contains("defense")) {
				Product item = objectmapper.readValue(json,  Armor.class);
				addItem(item);
			}
			if(json.contains("healthRestore")) {
				Product item = objectmapper.readValue(json,  Health.class);
				addItem(item);
			}
		
	} 
	}
	catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	catch(IOException io) {
		io.printStackTrace();
	}
}
public static void addItem(Product item) {
	inventoryList.add(item);
}
public static void removeItem(Product item) {
	inventoryList.remove(item);
}
public static void changeQuantity(Product item, int change) { // decreases quantity by one
	int newQuantity = item.getQuantity() + change;
	item.setQuantity(newQuantity);
}
public static void addCart(Product item) {
	changeQuantity(item, -1);
}
public static void removeCart(Product item) {
	changeQuantity(item, 1);
}

public static void displayInventory() {
	for (Product item: inventoryList) {
		item.displayProduct();
	}
}

public static Product getItem(int i) {
	return inventoryList.get(i);
}
public static void getItem(Product item) {
	if (item != null) {
	System.out.println(item.toString()); }
}
public static Product matchItem(String name) {
	for (Product item: inventoryList) {
		int m = item.compareTo(name);
		if (m == 0) {
			return item;
		}
	}
	System.out.println("Please select an item in stock");
	return null;
}
public static void sortName() {
	Collections.sort(inventoryList, Comparator.comparing(Product::getName));;
}
public static void reverseSortName() {
	Comparator<Product>nameCompare
	= (c1,c2) -> c1.getName().compareTo(c2.getName());
	Collections.sort(inventoryList, Collections.reverseOrder(nameCompare));
}
public static void sortPrice() {
	Collections.sort(inventoryList, Comparator.comparing(Product::getPrice));
}
public static void reverseSortPrice() {
	Comparator<Product>priceCompare
	= (c1,c2) -> c1.getPrice().compareTo(c2.getPrice());
	Collections.sort(inventoryList, Collections.reverseOrder(priceCompare));
}
}