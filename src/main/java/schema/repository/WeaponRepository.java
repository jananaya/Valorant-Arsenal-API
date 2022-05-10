package schema.repository;

import collections.interfaces.IArsenal;
import domain.interfaces.IWeapon;
import schema.Database;
import schema.interfaces.IWeaponRepository;

public class WeaponRepository implements IWeaponRepository {
    private Database database;

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
}
