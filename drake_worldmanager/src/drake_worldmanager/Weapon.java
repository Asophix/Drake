package drake_worldmanager;

import java.awt.geom.Line2D;

public abstract class Weapon extends Item {

	int ammo = 100;
	
	public Weapon(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void activate() {
		Line2D.Float line = new Line2D.Float(arg0, arg1, arg2, arg3);
	}

}
