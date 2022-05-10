package domain.interfaces;

import types.Yardstick;
import java.util.ArrayList;

public interface IArsenal {
    IWeapon searchByName(String name);
    ArrayList<IWeapon> sort(Yardstick yardstick);
    void insert(IWeapon weapon);
}
