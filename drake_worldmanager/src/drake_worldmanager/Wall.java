package drake_worldmanager;

public class Wall extends Element {
	
	protected float x2 = 0.0f; //second x coordinate of parallel side
	protected float y2 = 0.0f; //second y coordinate of parallel side
	
	//let's assume if x2 & y2 are negative, it is a basic line wall
	public Wall(float x, float y, float x2, float y2) {
		super(x, y);
		this.x2 = x2;
		this.y2 = y2;
		System.out.println("New Wall created.");
		System.out.println("coords:" + this.x + "," + this.y + "," + this.x2 + "," + this.y2);
	}

}
