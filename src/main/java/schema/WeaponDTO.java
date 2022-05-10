package schema;

import domain._abstract.AbstractWeapon;

import java.util.ArrayList;

public class WeaponDTO extends AbstractWeapon {

    public WeaponDTO(int id, String name, String category, ArrayList<String> specs, String imagePath, float rateOfFire, int damage, float rating) {
        super(id, name, category, specs, imagePath, rateOfFire, damage, rating);
    }
}
