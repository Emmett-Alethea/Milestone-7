package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import app.Inventory;
import app.Product;

public class InventoryTest {
	 Inventory inventory = new Inventory();
	 ArrayList<Product>inventoryList = new ArrayList<Product>();
	 Product item = new Product("name", "desc",5,5,5);
	
	 
	

	@Test
	public void testAddItem() {
		ArrayList<Product> testItem = new ArrayList<Product>();
		testItem.add(item);
		inventoryList.add(item);
		assertEquals(testItem,inventoryList);
		
	}

	@Test
	public void testRemoveItem() {
		 ArrayList<Product>testEmpty = new ArrayList<Product>();
		 inventoryList.remove(item);
		 assertEquals(testEmpty, inventoryList);
	}

	@Test
	public void testChangeQuantity() {
		int change = 5;
		int newQuantity = item.getQuantity() + change;
		item.setQuantity(newQuantity);
		assertEquals(newQuantity, item.getQuantity());
	}

	@Test
	public void testGetItemProduct() {
		String item2 = item.toString();
		assertEquals(item2, item.toString());
	}

}
