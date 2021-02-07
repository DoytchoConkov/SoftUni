package halfLife;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTests {

    @Test(expected = NullPointerException.class)
    public void TestConstructorShouldTrowExeptionWithEmptyName(){
        Player player=new Player(null,100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorShouldTrowExeptionWithInvalidHealth(){
        Player player=new Player("Pesho",-5);
    }

    @Test
    public void TestGetNameShouldWork(){
        Player player=new Player("Pesho",5);
        Assert.assertEquals("Pesho",player.getUsername());
    }

    @Test
    public void TestGetHealthShouldWork(){
        Player player=new Player("Pesho",5);
        Assert.assertEquals(5,player.getHealth());
    }

    @Test(expected = NullPointerException.class)
    public void TestAddGunShouldTrowExeptionWithNull(){
        Player player=new Player("Pesho",5);
        player.addGun(null);
    }

    @Test
    public void TestAddGunShouldWork(){
        Player player=new Player("Pesho",5);
        Gun gun=new Gun("Avtomat",1000);
        player.addGun(gun);
        Assert.assertNotNull(player.getGun("Avtomat"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void TestGetGunsShouldThrowErrorWhenModifireResult(){
        Player player=new Player("Pesho",5);
        Gun gun=new Gun("Avtomat",1000);
        player.addGun(gun);
        player.getGuns().add(new Gun("Pistolet",10));
    }

    @Test
    public void TestRemoveGunsShouldWork(){
        Player player=new Player("Pesho",5);
        Gun gun=new Gun("Avtomat",1000);
        player.addGun(gun);
        player.removeGun(gun);
        Assert.assertNull(player.getGun("Avtomat"));
    }

    @Test(expected = IllegalStateException.class)
    public void TestTakeDamageShouldThrowErrorWhenModifireResult(){
        Player player=new Player("Pesho",5);
        player.takeDamage(3);
        player.takeDamage(3);
        player.takeDamage(3);
    }

    @Test
    public void TestTakeDamageShouldWork(){
        Player player=new Player("Pesho",5);
        player.takeDamage(3);
        Assert.assertEquals(2,player.getHealth());
    }

}
