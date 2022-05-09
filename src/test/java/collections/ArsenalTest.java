package collections;

import java.util.ArrayList;
import java.util.Arrays;

import domain.entity.Weapon;
import types.Yardstick;

import static org.junit.jupiter.api.Assertions.*;

public class ArsenalTest {
	@org.junit.jupiter.api.Test
	void insert() {
		Arsenal arsenal = new Arsenal();
		Weapon w1 = new Weapon("Desert Eagle", "Handgun", null, "", 0, 0, 0);
		Weapon w2 = new Weapon("AK47", "Fusil", null, "", 0, 0, 0);
		Weapon w3 = new Weapon("Knife", "Melee", null, "", 0, 0, 0);

		arsenal.insert(w2);
		arsenal.insert(w3);
		
		assertEquals(null, arsenal.searchByName("Desert Eagle"));
		
		arsenal.insert(w1);
		
		assertEquals(w1, arsenal.searchByName("Desert Eagle"));
		assertEquals(w2, arsenal.searchByName("AK47"));
		assertEquals(w3, arsenal.searchByName("Knife"));
	}

	@org.junit.jupiter.api.Test
	void searchByName() {
		String weaponName = "AK47";
		Weapon ak47 = new Weapon(weaponName, "", null, "", 0, 0, 0);
		Arsenal arsenal = new Arsenal();

		arsenal.insert(new Weapon("", null, null, null, 0, 0, 0));
		arsenal.insert(ak47);

		assertEquals(ak47, arsenal.searchByName(weaponName));
	}

	@org.junit.jupiter.api.Test
	void sort() {
		ArrayList<String> specs = new ArrayList<>();
		Weapon w1 = new Weapon("Desert Eagle", "Handgun", specs, "", 3, 1, 9);

		specs.add("This is a spec!");

		Weapon w2 = new Weapon("AK47", "Fusil", specs, "", 9, 5, 15);

		specs.add("This is another spec!");

		Weapon w3 = new Weapon("Knife", "Melee", specs, "", 2, 4, 20);

		Arsenal arsenal = new Arsenal();
		ArrayList<Weapon> weaponsByName = new ArrayList<>(Arrays.asList(w2, w1, w3));
		ArrayList<Weapon> weaponsByCategory = new ArrayList<>(Arrays.asList(w2, w1, w3));
		ArrayList<Weapon> weaponsByNumberOfSpecs = new ArrayList<>(Arrays.asList(w3, w2, w1));
		ArrayList<Weapon> weaponsByRateOfFire = new ArrayList<>(Arrays.asList(w3, w1, w2));
		ArrayList<Weapon> weaponsByDamage = new ArrayList<>(Arrays.asList(w1, w3, w2));
		ArrayList<Weapon> weaponsByRating = new ArrayList<>(Arrays.asList(w1, w2, w3));

		arsenal.insert(w1);
		arsenal.insert(w2);
		arsenal.insert(w3);

		assertEquals(weaponsByName, arsenal.sort(Yardstick.NAME));
		assertEquals(weaponsByCategory, arsenal.sort(Yardstick.CATEGORY));
		assertEquals(weaponsByNumberOfSpecs, arsenal.sort(Yardstick.NUMBER_OF_SPECS));
		assertEquals(weaponsByRateOfFire, arsenal.sort(Yardstick.RATE_OF_FIRE));
		assertEquals(weaponsByDamage, arsenal.sort(Yardstick.DAMAGE));
		assertEquals(weaponsByRating, arsenal.sort(Yardstick.RATING));
	}

	@org.junit.jupiter.api.Test
	void searchByCategory() {
		Arsenal arsenal = new Arsenal();

		Weapon w1 = new Weapon("Handgun weapon", "Handgun", null, "", 0, 0, 0);
		Weapon w2 = new Weapon("Another handgun weapon", "Handgun", null, "", 0, 0, 0);
		Weapon w3 = new Weapon("Knife", "Melee", null, "", 0, 0, 0);

		ArrayList<Weapon> handguns = new ArrayList<>(Arrays.asList(w1, w2));

		arsenal.insert(w1);
		arsenal.insert(w2);
		arsenal.insert(w3);

		assertEquals(handguns, arsenal.searchByCategory("Handgun"));
	}

	@org.junit.jupiter.api.Test
	void empty() {
		Arsenal arsenal = new Arsenal();

		assertTrue(arsenal.empty());
		arsenal.insert(new Weapon("", "", null, "", 0, 0, 0));
		assertFalse(arsenal.empty());
	}
}
