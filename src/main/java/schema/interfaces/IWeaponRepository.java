package schema.interfaces;

import collections.interfaces.IArsenal;
import domain.interfaces.IWeapon;

public interface IWeaponRepository {
    IArsenal read();
    IWeapon readByName(String name);
}
