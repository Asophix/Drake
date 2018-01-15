package drake_worldmanager;

import java.awt.Point;
import java.awt.geom.Line2D;

public abstract class Weapon extends Item {

	int ammo = 100;
	float damage = 8;
	
	public Weapon(float x, float y, int ammo, float damage) {
		super(x, y);
		this.ammo = ammo;
		this.damage = damage;
		// TODO Auto-generated constructor stub
	}

	public void activate(float x, float y, float lookAt) {
	};

}
