package domain.interfaces;

import domain.types.Yardstick;
import java.util.ArrayList;

public interface IArsenal {
    IWeapon searchByName(String name);
    ArrayList<IWeapon> searchByCategory(String category);
    ArrayList<IWeapon> sort(Yardstick yardstick);
    void insert(IWeapon weapon);
    ArrayList<IWeapon> getWeapons();
    boolean empty();
}
