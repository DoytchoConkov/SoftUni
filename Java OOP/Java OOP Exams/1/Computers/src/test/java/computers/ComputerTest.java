package computers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComputerTest {

    private Computer computer;

    @Before
    public void setUp() {
        this.computer = new Computer("Test");
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorShouldThrowExeptionWithNull() {
        Computer computer = new Computer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorShouldThrowExeptionWithEmptyName() {
        Computer computer = new Computer("");
    }

    @Test
    public void TestConstructorShouldWorkWithCorrectName() {
        Computer computer = new Computer("Name");
        assertEquals("Name", computer.getName());
    }

    @Test
    public void TestGetPartsShouldReturnCollection() {
        assertNotNull(this.computer.getParts());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void TestGetPartsShouldReturnUnmodifiableCollection() {
        this.computer.getParts().add(new Part("test", 3.3));
    }

    @Test
    public void TestGetGetTottalPriceShouldReturnNullWhenIsEmpty() {
      assertEquals(0.0, this.computer.getTotalPrice(),0.0);
    }

    @Test
    public void TestGetGetTottalPriceShouldReturnValueWhenIsNotEmpty() {
        this.computer.addPart(new Part("test1",2.5));
        this.computer.addPart(new Part("test2",3.6));
        assertEquals(6.1, this.computer.getTotalPrice(),0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestAddPartShouldTrowExeptionWhenPartIsNull() {
        this.computer.addPart(null);
    }

    @Test
    public void TestAddPartShouldAddNewPart() {
        this.computer.addPart(new Part("Test", 2.89));
        assertNotNull(this.computer.getPart("Test"));
    }

    @Test
    public void TestRemoveShouldRemovePart() {
        Part part=new Part("Test", 2.89);
        assertFalse(this.computer.removePart(part));
        this.computer.addPart(part);
        assertTrue(this.computer.removePart(part));
    }

    @Test
    public void TestGetPartShouldReturnNull() {
        assertNull(this.computer.getPart("Test"));
    }

    @Test
    public void TestRemoveShouldReturnSamePart() {
        Part part=new Part("Test", 2.89);
        this.computer.addPart(part);
        assertNotNull(this.computer.getPart("Test"));
    }
}