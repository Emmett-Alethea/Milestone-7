package test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

import org.junit.Test;

import app.Armor;
import app.Product;

public class ArmorTest {
	
	Armor armor = new Armor("name", "desc", 5, 0, 12, 6);
	int defense = 6;

	@Test
	public void testArmor() {
		assertThat(armor, instanceOf(Product.class));
	}

	@Test
	public void testGetDefense() {
		assertEquals(defense, armor.getDefense());
	}

}
