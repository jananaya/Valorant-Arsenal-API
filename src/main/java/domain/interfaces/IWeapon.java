package domain.interfaces;

import java.util.ArrayList;

public interface IWeapon {
    int getId();
    String getName();
    String getCategory();
    ArrayList<String> getSpecs();
    String getImagePath();
    float getRateOfFire();
    int getDamage();
    float getRating();
}
