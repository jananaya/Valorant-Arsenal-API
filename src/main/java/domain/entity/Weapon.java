package domain.entity;

import domain.interfaces.IWeapon;
import java.util.ArrayList;

public class Weapon implements IWeapon {
	private final String name;
	private final String category;
	private final ArrayList<String> specs;
	private final String imagePath;
	private final float rateOfFire;
	private final int damage;
	private final float rating;

	public Weapon(String name, String category, ArrayList<String> specs, String imagePath, float rateOfFire,
			int damage, float rating) {
		this.category = category;
		this.name = name;
		this.specs = specs;
		this.imagePath = imagePath;
		this.rateOfFire = rateOfFire;
		this.damage = damage;
		this.rating = rating;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getCategory() {
		return category;
	}

	@Override
	public ArrayList<String> getSpecs() {
		return specs;
	}

	@Override
	public String getImagePath() {
		return imagePath;
	}
	
	@Override
	public float getRateOfFire() {
		return rateOfFire;
	}

	@Override
	public int getDamage() {
		return damage;
	}

	@Override
	public float getRating() {
		return rating;
	}

	@Override
	public String toString() {
		return "Weapon{" + "name=" + name + ", category=" + category + ", specs=" + specs + ", imagePath=" + imagePath
				+ ", rateOfFire=" + rateOfFire + ", damage=" + damage + ", rating=" + rating + '}';
	}
}
