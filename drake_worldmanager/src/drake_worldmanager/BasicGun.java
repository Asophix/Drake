package drake_worldmanager;

import java.awt.geom.Line2D;

public class BasicGun extends Weapon {
	
	World w;

	public BasicGun(float x, float y, int ammo, float damage, World w) {
		super(x, y, ammo, damage);
		this.w = w;
		// TODO Auto-generated constructor stub
	}

	public void activate(float x, float y, float lookAt) {
		float x2 = (float)(x + 8.0f * Math.cos(lookAt * Math.PI / 180));
		float y2 = (float)(y + 8.0f * Math.sin(lookAt * Math.PI / 180));
		Line2D.Float ray = new Line2D.Float(x, y, x2, y2);
		
	}

}
