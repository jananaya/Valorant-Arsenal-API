package domain.entity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {
    private ArrayList<String> specs() {
        ArrayList<String> rifleSpecs = new ArrayList<>();

        rifleSpecs.add("The weapon's category is \"Rifle\"");
        rifleSpecs.add("This weapon has got many bullets");

        return rifleSpecs;
    }

    @org.junit.jupiter.api.Test
    void getName() {;
        Weapon ak47 = new Weapon("AK47", "", null, "", 0, 0, 0);
        Weapon mp5 = new Weapon("MP5", "", null, "", 0, 0, 0);

        assertEquals("AK47", ak47.getName());
        assertEquals("MP5", mp5.getName());
    }

    @org.junit.jupiter.api.Test
    void getCategory() {
        Weapon rifle = new Weapon("", "Rifle", null, "", 0, 0, 0);
        Weapon shotgun = new Weapon("", "Shotgun", null, "", 0, 0, 0);

        assertEquals("Rifle", rifle.getCategory());
        assertEquals("Shotgun", shotgun.getCategory());
    }

    @org.junit.jupiter.api.Test
    void getSpecs() {
        Weapon rifle = new Weapon("", "", this.specs(), "", 0, 0, 0);

        assertEquals(this.specs(), rifle.getSpecs());
    }

    @org.junit.jupiter.api.Test
    void getImagePath() {
        Weapon weapon1 = new Weapon("", "", null, "path_1", 0, 0, 0);
        Weapon weapon2 = new Weapon("", "", null, "path_2", 0, 0, 0);

        assertEquals(weapon1.getImagePath(), "path_1");
        assertEquals(weapon2.getImagePath(), "path_2");
    }
    
    @org.junit.jupiter.api.Test
    void getRateOfFire() {
    	Weapon weapon1 = new Weapon("", "", null, "", 10, 0, 0);
    	Weapon weapon2 = new Weapon("", "", null, "", 5, 0, 0);
    	
    	assertEquals(10, weapon1.getRateOfFire());
    	assertEquals(5, weapon2.getRateOfFire());
    }
    
    @org.junit.jupiter.api.Test
    void getDamage() {
    	Weapon weapon1 = new Weapon("", "", null, "", 0, 20, 0);
    	Weapon weapon2 = new Weapon("", "", null, "", 0, 10, 0);
    	
    	assertEquals(20, weapon1.getDamage());
    	assertEquals(10, weapon2.getDamage());
    }
    
    @org.junit.jupiter.api.Test
    void getRating() {
    	Weapon weapon1 = new Weapon("", "", null, "", 0, 0, 30);
    	Weapon weapon2 = new Weapon("", "", null, "", 0, 0, 15);
    	
    	assertEquals(30, weapon1.getRating());
    	assertEquals(15, weapon2.getRating());
    }
    
    @org.junit.jupiter.api.Test
    void testToString() {
        Weapon rifle = new Weapon("My rifle", "Rifle", this.specs(), "path", 0, 0, 0);
        String strRifle = "Weapon{name=My rifle, category=Rifle, specs=[The weapon's category is \"Rifle\", This weapon has got many bullets], imagePath=path, rateOfFire=0.0, damage=0, rating=0.0}";

        assertEquals(strRifle, rifle.toString());
    }
}