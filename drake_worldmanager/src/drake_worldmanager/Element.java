package drake_worldmanager;

public class Element {
	float x = 0.0f; //x coordinate
	float y = 0.0f; //y coordinate
	protected float lookAt = 0.0f; //view in degrees, 0 looking at right
	float speed_x, speed_y = 0.0f;
	
	boolean isRight = false;
	boolean isUp = false;
	
	final int PEAK_SPEED = 50;
	protected final long FRAME = 1000/60; //1 frame = 16,67 ms = 1/60 s

	public Element(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean moveX(float t) {
		if ((isRight && x >= 0 && x < 200) || (!isRight && x > 0 && x <= 200))  {
			if (isRight && (speed_x <= PEAK_SPEED - 2.5f))
				speed_x += 2.5f;
			else if (!isRight && (speed_x >= -PEAK_SPEED + 2.5f))
				speed_x -= 2.5f;
			x += speed_x / t;
			if (x < 0) {
				x = 0;
			}
			if (x > 200) {
				x = 200;
			}
			//System.out.println("Element position:" + x + "," + y);
			//System.out.println("Velocity: " + speed_x);
		}
		else {
			speed_x = 0;
			return false;
		}
		return true;
	}
	
	public boolean moveY(float t) {
		if ((isUp && y >= 0 && y < 200) || (!isUp && y > 0 && y <= 200))  {
			if (isUp && (speed_y <= PEAK_SPEED - 2.5f))
				speed_y += 2.5f;
			else if (!isUp && (speed_y >= -PEAK_SPEED + 2.5f))
				speed_y -= 2.5f;
			y += speed_y / t;
			if (y < 0) {
				y = 0;
			}
			if (y > 200) {
				y = 200;
			}
			//System.out.println("Element position:" + x + "," + y);
			//System.out.println("Velocity: " + speed_y);
		}
		else {
			speed_y = 0;
			return false;
		}
		return true;
	}
	
	public boolean moveFree() {
		return true;
	}

}
