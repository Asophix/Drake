package drake_worldmanager;

import java.awt.Point;
import java.util.ArrayList;

public class Actor extends Element {

	int health = 125;
	int armor = 0;
	ArrayList<Item> inventory;
	
	public Actor(float x, float y, int health, int armor) {
		super(x, y);
		this.health = health;
		this.armor = armor;
		this.inventory = new ArrayList<>(0);
		System.out.println("New actor created.");
		System.out.println("coords:" + x + "," + y);
		System.out.println("health:" + health + "/" + armor);
		//this.randomshit();
	}
	
	public void randomshit() {
		this.moveFree(new Point(8, 8), FRAME);
		this.lookAt = (float)(Math.random() * 360 - 180);
		System.out.println("lookAt: " + this.lookAt);
	}

	public void pickupItem(Item item) {
		if (item.pickup(10000)) {
			inventory.add(item);
		}
	}
	
	public void useItem(Item item) {
		item.activate();
		inventory.remove(item);
	}
	
	public void useWeapon(Weapon weapon) {
		weapon.activate(this.x, this.y, this.lookAt);
	}

}
