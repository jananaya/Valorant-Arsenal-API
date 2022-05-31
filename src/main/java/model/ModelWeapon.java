package model;

import collections.interfaces.IArsenal;
import domain.interfaces.IWeapon;
import types.Yardstick;
import schema.interfaces.IWeaponRepository;

import java.util.ArrayList;

public class ModelWeapon {
    private final IArsenal arsenal;
    private final IWeaponRepository repository;

    public ModelWeapon(IWeaponRepository repository) {
        this.repository = repository;
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

    public ArrayList<String> getCategories() {
        return this.repository.getCategories();
    }
}