package domain.entity;

import domain._abstract.AbstractWeapon;
import java.util.ArrayList;

public class Weapon extends AbstractWeapon {

        public Weapon(int id, String name, String category, ArrayList<String> specs, String imagePath, float rateOfFire, int damage, float rating) {
            super(id, name, category, specs, imagePath, rateOfFire, damage, rating);
        }
    
	@Override
	public String toString() {
		return "Weapon{" + "id=" + id + ", name=" + name + ", category=" + category + ", specs=" + specs + ", imagePath=" + imagePath
				+ ", rateOfFire=" + rateOfFire + ", damage=" + damage + ", rating=" + rating + '}';
	}
}
