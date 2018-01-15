package drake_worldmanager;

import java.awt.Point;

public class Element {
	protected float x = 0.0f; //x coordinate
	protected float y = 0.0f; //y coordinate
	protected float lookAt = 0.0f; //view in degrees, 0 looking at right
	protected float speed_x, speed_y = 0.0f;
	
	final int PEAK_SPEED = 50;
	protected final long FRAME = 1000/60; //1 frame = 16,67 ms = 1/60 s

	public Element(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean moveConstFree(float t) {
		return moveFree(new Point(0, 0), t);
	}
	
	//Gradual acceleration until peak speed for both axis
	public boolean moveFree(Point v, float t) {
		//TODO lookAt
		this.speed_x += Math.min(speed_x + v.getX(), PEAK_SPEED);
		this.speed_y += Math.min(speed_y + v.getY(), PEAK_SPEED);
		//already increased speed
		
		this.x += speed_x / t;
		this.y += speed_y / t;
		adjustBounds();
		
		System.out.println("Element new position: " + this.x + "," + this.y);
		System.out.println("Speed vector " + speed_x + "," + speed_y);
		return true;
	}

	private void adjustBounds() {
		boolean hSkipRight = (speed_x > 0 && x >= 200);
		boolean hSkipLeft = (speed_x < 0 && x <= 0);
		boolean vSkipTop = (speed_y > 0 && y >= 200);
		boolean vSkipBottom = (speed_y < 0 && y <= 0);
		if (hSkipRight) {
			this.x = 200;
			this.speed_x = 0;
		}
		if (hSkipLeft) {
			this.x = 0;
			this.speed_x = 0;
		}
		if (vSkipTop) {
			this.y = 200;
			this.speed_y = 0;
		}
		if (vSkipBottom) {
			this.y = 0;
			this.speed_y = 0;
		}
	}

}
