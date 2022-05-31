package schema.interfaces;


import collections.interfaces.IArsenal;
import domain.interfaces.IWeapon;

import java.util.ArrayList;

public interface IWeaponRepository {
    IArsenal read();
    IWeapon readByName(String name);
    ArrayList<String> getCategories();
}
