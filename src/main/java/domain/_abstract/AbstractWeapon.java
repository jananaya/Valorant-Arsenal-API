package domain._abstract;

import domain.interfaces.IWeapon;
import java.util.ArrayList;

public abstract class AbstractWeapon implements IWeapon {
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

	@Override
	public int getId() {
		return id;
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
}
