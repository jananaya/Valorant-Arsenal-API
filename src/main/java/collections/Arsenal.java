package collections;

import java.util.ArrayList;
import java.util.Collections;

import types.BinaryTree;

import collections.interfaces.IArsenal;
import domain.interfaces.IWeapon;
import types.Yardstick;

public class Arsenal implements IArsenal {
    private BinaryTree<IWeapon> root;
    private ArrayList<IWeapon> weapons;
    private IWeapon weapon;

    public Arsenal() {
        this.root = null;
        this.weapon = null;
        this.weapons = new ArrayList<>();
    }

    @Override
    public IWeapon searchByName(String name) {
        this.weapon = null;

        searchByName(name, this.root);

        return this.weapon;
    }

    private void searchByName(String name, BinaryTree<IWeapon> r) {
        if (r == null) {
            return;
        }

        if (r.getData().getName().equals(name)) {
            this.weapon = r.getData();
            return;
        } else if (name.compareTo(r.getData().getName()) > 0) {
            if (r.right() == null) {
                return;
            }
            searchByName(name, r.right());
        } else {
            if (r.left() == null) {
                return;
            }
            searchByName(name, r.left());
        }
    }

    @Override
    public ArrayList<IWeapon> searchByCategory(String category) {
        if (empty())
            return null;

        this.weapons.clear();
        searchByCategory(category, this.root);
        return this.weapons;
    }

    private void searchByCategory(String category, BinaryTree<IWeapon> r) {
        if (r == null)
            return;

        if (r.getData().getCategory().equals(category)) {
            this.weapons.add(r.getData());
        }

        searchByCategory(category, r.left());
        searchByCategory(category, r.right());
    }

    @Override
    public ArrayList<IWeapon> getWeapons() {
        if (empty())
            return null;

        this.weapons.clear();
        getWeapons(this.root);

        return this.weapons;
    }

    private void getWeapons(BinaryTree<IWeapon> r) {
        if (r == null)
            return;

        getWeapons(r.left());
        this.weapons.add(r.getData());
        getWeapons(r.right());
    }

    @Override
    public ArrayList<IWeapon> sort(Yardstick yardstick) {
        this.weapons.clear();

        if (yardstick == Yardstick.NAME) {
            return this.getWeapons();
        }

        this.getWeapons(this.root);
        Collections.sort(this.weapons, yardstick);

        return this.weapons;
    }

    @Override
    public void insert(IWeapon weapon) {
        if (empty()) {
            this.root = new BinaryTree<IWeapon>(weapon);
            return;
        }

        insert(weapon, this.root);
    }

    private void insert(IWeapon weapon, BinaryTree<IWeapon> r) {
        if (weapon.getName().compareTo(r.getData().getName()) > 0) {
            if (r.right() == null) {
                r.linkRight(new BinaryTree<IWeapon>(weapon));
                return;
            }

            insert(weapon, r.right());
        } else {
            if (r.left() == null) {
                r.linkLeft(new BinaryTree<IWeapon>(weapon));
                return;
            }

            insert(weapon, r.left());
        }
    }

    @Override
    public boolean empty() {
        return this.root == null;
    }
}