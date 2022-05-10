package model;

import collections.interfaces.IArsenal;
import domain.interfaces.IWeapon;
import types.Yardstick;
import schema.interfaces.IWeaponRepository;

import java.util.ArrayList;

public class ModelWeapon {
    private final IArsenal arsenal;

    public ModelWeapon(IWeaponRepository repository) {
        this.arsenal = repository.read();
    }

    public IWeapon searchByName(String name) {
        return this.arsenal.searchByName(name);
    }

    public ArrayList<IWeapon> sort(Yardstick yardstick) {
        return this.arsenal.sort(yardstick);
    }

    public ArrayList<IWeapon> getWeapons() {
        return this.arsenal.getWeapons();
    }

    public ArrayList<IWeapon> searchByCategory(String category) {
        return this.arsenal.searchByCategory(category);
    }
}