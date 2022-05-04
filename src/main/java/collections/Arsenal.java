package collections;

import java.util.ArrayList;
import types.BinaryTree;

import domain.interfaces.IArsenal;
import domain.interfaces.IWeapon;
import domain.types.Yardstick;


public class Arsenal implements IArsenal {
	private BinaryTree<IWeapon> root;
	private IWeapon weapon;
	
	public Arsenal() {
		this.root = null;
		this.weapon = null;
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
		}
		
		searchByName(name, r.left());
		searchByName(name, r.right());
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
		if (weapon.getDamage() > r.getData().getDamage()) {
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
