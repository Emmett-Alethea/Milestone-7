package test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

import org.junit.Test;

import app.Health;
import app.Product;

public class HealthTest {
	Health health = new Health("name", "desc", 2, 3, 5.4, 10);
	int healthRestore = 10;

	@Test
	public void testHealth() {
		assertThat(health, instanceOf(Product.class));
	}

	@Test
	public void testGetHealthRestore() {
		assertEquals(healthRestore, health.getHealthRestore());
	}

}
