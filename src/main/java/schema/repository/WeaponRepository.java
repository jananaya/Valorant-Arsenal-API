package schema.repository;

import collections.interfaces.IArsenal;
import domain.interfaces.IWeapon;
import schema.Database;
import schema.interfaces.IWeaponRepository;

import java.util.ArrayList;

public class WeaponRepository implements IWeaponRepository {
    private final Database database;

    public WeaponRepository() {
        this.database = Database.getInstance();
    }

    @Override
    public IArsenal read() {
        return this.database.read();
    }

    @Override
    public IWeapon readByName(String name) {
        return this.database.readByName(name);
    }

    @Override
    public ArrayList<String> getCategories() {
        return this.database.getCategories();
    }
}
