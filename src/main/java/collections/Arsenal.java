package collections;

import java.util.ArrayList;
import types.BinaryTree;

import domain.interfaces.IArsenal;
import domain.interfaces.IWeapon;
import domain.types.Yardstick;

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

        public ArrayList<IWeapon> getWeapons() {
            if (this.root == null)
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
		// TODO
		return null;
	}

	@Override
	public void insert(IWeapon weapon) {
		if (this.root == null) {
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
}
