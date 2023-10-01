package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ArmorTest.class, HealthTest.class, InventoryTest.class, ProductTest.class, WeaponTest.class })
public class AllTests {

}
