package store;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StoreTests {

    @Test
    public void TestConstructor() {
        Store garage = new Store();
        assertEquals(0, garage.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestAddComputerWithNull() {
        Store garage = new Store();
        garage.addProduct(null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void TestAddComputerSameComputer() {
        Store garage = new Store();
        Product computer = new Product("IBM", 55, 10.00);
        garage.addProduct(computer);
        garage.getProducts().add(computer);
    }


    @Test(expected = IllegalArgumentException.class)
    public void TestAddComputerRealComputer() {
        Store garage = new Store();
        Product computer = new Product("IBM", 0, 10.00);
        garage.addProduct(computer);
    }

    @Test
    public void TestAddComputerRealComputer2() {
        Store garage = new Store();
        Product computer = new Product("IBM", 5, 10.00);
        garage.addProduct(computer);
        assertEquals(1, garage.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestAddComputerRealComputer3() {
        Store garage = new Store();
        Product computer = new Product("IBM", 10, 10.00);
        garage.addProduct(computer);
        garage.buyProduct("aaa",5);
    }


    @Test(expected = IllegalArgumentException.class)
    public void TestAddComputerRealComputer4() {
        Store garage = new Store();
        Product computer = new Product("IBM", 10, 10.00);
        garage.addProduct(computer);
        garage.buyProduct("aaa",15);
    }

    @Test
    public void TestAddComputerRealComputer5() {
        Store garage = new Store();
        Product computer = new Product("IBM", 10, 10.00);
        garage.addProduct(computer);

assertEquals(50,garage.buyProduct("IBM",5),0.0);
    }

    @Test
    public void TestAddComputerRealComputer6() {
        Store garage = new Store();
        Product computer = new Product("IBM", 10, 10.00);
        garage.addProduct(computer);

        assertNotNull(garage.getTheMostExpensiveProduct());
    }

}