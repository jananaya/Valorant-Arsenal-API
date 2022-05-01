package domain.interfaces;

import java.util.ArrayList;

public interface IWeapon {
    String getName();
    String getCategory();
    ArrayList<String> getSpecs();
    String getImagePath();
    @Override
    String toString();
}