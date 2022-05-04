package domain.interfaces;

import java.util.ArrayList;

public interface IWeapon {
    String getName();
    String getCategory();
    ArrayList<String> getSpecs();
    String getImagePath();
    float getRateOfFire();
    float getDamage();
    float getRating();
}
