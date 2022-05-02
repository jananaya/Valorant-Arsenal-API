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
        Weapon ak47 = new Weapon("AK47", "", new ArrayList<String>(), "");
        Weapon mp5 = new Weapon("MP5", "", new ArrayList<String>(), "");

        assertEquals("AK47", ak47.getName());
        assertEquals("MP5", mp5.getName());
    }

    @org.junit.jupiter.api.Test
    void getCategory() {
        Weapon rifle = new Weapon("", "Rifle", new ArrayList<String>(), "");
        Weapon shotgun = new Weapon("", "Shotgun", new ArrayList<String>(), "");

        assertEquals("Rifle", rifle.getCategory());
        assertEquals("Shotgun", shotgun.getCategory());
    }

    @org.junit.jupiter.api.Test
    void getSpecs() {
        Weapon rifle = new Weapon("", "", this.specs(), "");

        assertEquals(this.specs(), rifle.getSpecs());
    }

    @org.junit.jupiter.api.Test
    void getImagePath() {
        Weapon weapon1 = new Weapon("", "", new ArrayList<String>(), "path_1");
        Weapon weapon2 = new Weapon("", "", new ArrayList<String>(), "path_2");

        assertEquals(weapon1.getImagePath(), "path_1");
        assertEquals(weapon2.getImagePath(), "path_2");
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        Weapon rifle = new Weapon("My rifle", "Rifle", this.specs(), "path");
        String strRifle = "Weapon{name=My rifle, category=Rifle, specs=[The weapon's category is \"Rifle\", This weapon has got many bullets], imagePath=path}";

        assertEquals(strRifle, rifle.toString());
    }
}