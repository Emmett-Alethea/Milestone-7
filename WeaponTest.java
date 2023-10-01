package test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

import org.junit.Test;

import app.Product;
import app.Weapon;


public class WeaponTest {
	Weapon weapon = new Weapon("name", "desc", 5, 0, 12, 5);
	int damage = 5;
	


	@Test
	public void testWeapon() {
		Weapon weapon = new Weapon();
		assertThat(weapon, instanceOf(Product.class));
		//fail("Not yet implemented");
	}

	@Test
	public void testGetDamage() {
		assertEquals(weapon.getDamage(),damage);
	}


}
