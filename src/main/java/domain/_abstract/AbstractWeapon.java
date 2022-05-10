package domain._abstract;

import java.util.ArrayList;

public abstract class AbstractWeapon {
    	protected int id;
	protected final String name;
	protected final String category;
	protected final ArrayList<String> specs;
	protected final String imagePath;
	protected final float rateOfFire;
	protected final int damage;
	protected final float rating;

	public AbstractWeapon (int id, String name, String category, ArrayList<String> specs, String imagePath, float rateOfFire,
			int damage, float rating) {
		this.id = id;
		this.category = category;
		this.name = name;
		this.specs = specs;
		this.imagePath = imagePath;
		this.rateOfFire = rateOfFire;
		this.damage = damage;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public ArrayList<String> getSpecs() {
		return specs;
	}

	public String getImagePath() {
		return imagePath;
	}
	
	public float getRateOfFire() {
		return rateOfFire;
	}

	public int getDamage() {
		return damage;
	}

	public float getRating() {
		return rating;
	}
}
