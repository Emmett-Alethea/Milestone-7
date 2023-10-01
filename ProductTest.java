package test;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Product;

public class ProductTest {
	String name = "Item";
	String desc = "Description";
    int quant = 0;
    int cart = 0;
    Double prices = 0.0;
    Product product = new Product(name, desc, quant, cart, prices);

	@Test
	public void testProduct() {
		Product items = new Product("item", "desc", 0, 0, 0);
		assertNotSame(product,items);
	}

	@Test
	public void testGetName() {
		assertEquals(name, product.getName());
	}

	@Test
	public void testGetDescription() {
		assertEquals(desc, product.getDescription());
	}

	@Test
	public void testGetQuantity() {
		assertEquals(quant, product.getQuantity());
	}

	@Test
	public void testGetCartQuant() {
		assertEquals(cart, product.getCartQuant());
	}

	@Test
	public void testGetPrice() {
		assertEquals(prices, product.getPrice());
	}

	

}
