package computers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ComputerManagerTests {


    @Test
    public void TestConstructor() {
        ComputerManager computer = new ComputerManager();
        assertEquals(0, computer.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void TestAddComputerWithNull() {
        ComputerManager computerenager = new ComputerManager();
        Computer computer = new Computer("IBM","Best",10.00);
        computerenager.addComputer(null);
    }

    @Test
    public void TestAddComputerRealComputer() {
        ComputerManager computerenager = new ComputerManager();
        Computer computer = new Computer("IBM","Best",10.00);
        computerenager.addComputer(computer);
        assertEquals(1, computerenager.getCount());
    }


    @Test(expected = IllegalArgumentException.class)
    public void TestAddComputerSameComputer() {
        ComputerManager computerenager = new ComputerManager();
        Computer computer = new Computer("IBM","Best",10.00);
        computerenager.addComputer(computer);
        computerenager.addComputer(computer);
    }

    @Test
    public void TestRemoveComputerSameComputer() {
        ComputerManager computerenager = new ComputerManager();
        Computer computer = new Computer("IBM","Best",10.00);
        computerenager.addComputer(computer);
        assertEquals(computer,  computerenager.removeComputer("IBM","Best"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void TestRemoveComputerInvalidComputer() {
        ComputerManager computerenager = new ComputerManager();
        Computer computer = new Computer("IBM","Best",10.00);
        computerenager.addComputer(computer);
        assertEquals(computer,  computerenager.removeComputer("HP","Best"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void TestRemoveComputerEmptymodel() {
        ComputerManager computerenager = new ComputerManager();
        Computer computer = new Computer("IBM","Best",10.00);
        computerenager.addComputer(computer);
        assertEquals(computer,  computerenager.removeComputer(null,"Best"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void TestRemoveComputerEmptyManifacture() {
        ComputerManager computerenager = new ComputerManager();
        Computer computer = new Computer("IBM","Best",10.00);
        computerenager.addComputer(computer);
        assertEquals(computer,  computerenager.removeComputer("IBM",null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestgetComputersByManufacturerEmptyManifacture() {
        ComputerManager computerenager = new ComputerManager();
        Computer computer = new Computer("IBM","Best",10.00);
        computerenager.addComputer(computer);
        assertEquals(computer,  computerenager.getComputersByManufacturer(null));
    }

    @Test
    public void TestgetComputersByManufacturerValidManifacture() {
        ComputerManager computerenager = new ComputerManager();
        Computer computer = new Computer("IBM","Best",10.00);
        computerenager.addComputer(computer);
        assertNotNull(  computerenager.getComputersByManufacturer("IBM"));
    }
}