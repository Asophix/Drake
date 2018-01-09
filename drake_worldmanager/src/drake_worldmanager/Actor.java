package drake_worldmanager;

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
		if (!isRight && !moveX(1*FRAME)) {
			isRight = true;
		}
		else if (isRight && !moveX(1*FRAME)) {
			isRight = false;
		}
		if (!isUp && !moveY(1*FRAME)) {
			isUp = true;
		}
		else if (isUp && !moveY(1*FRAME)) {
			isUp = false;
		}
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

}
