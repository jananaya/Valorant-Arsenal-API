package domain.entity;

import domain.interfaces.IWeapon;
import java.util.ArrayList;

public class Weapon implements IWeapon {
    private final String name;
    private final String category;
    private final ArrayList<String> specs;
    private final String imagePath;

    public Weapon(String name, String category, ArrayList<String> specs, String imagePath) {
        this.category = category;
        this.name = name;
        this.specs = specs;
        this.imagePath = imagePath;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public ArrayList<String> getSpecs() {
        return specs;
    }

    @Override
    public String getImagePath() {
        return imagePath;
    }

    @Override
    public String toString() {
        return "Weapon{" + "name=" + name + ", category=" + category + ", specs=" + specs + ", imagePath=" + imagePath + '}';
    }
}
