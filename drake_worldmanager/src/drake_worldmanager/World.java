package drake_worldmanager;


import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class World {
	
	ArrayList<Item> items;
	ArrayList<Actor> actors;
	ArrayList<Projectile> projectiles;
	ArrayList<Wall> walls;
	long storedTime;
	int totalframes = 0;
	
	final int SIZE = 200;
	final long FRAME = 1000/60; //1 frame = 16,67 ms = 1/60 s
	
	
	public World() {
		items = new ArrayList<>(0);
		actors = new ArrayList<>(0);
		projectiles = new ArrayList<>(0);
		walls = new ArrayList<>(0);
	}

	public void init(String path) throws IOException, InterruptedException {
		storedTime = System.currentTimeMillis();
		BufferedReader buf = new BufferedReader(new FileReader(path));
		items.clear();
		actors.clear();
		projectiles.clear();
		walls.clear();
		
		String line;
		while ((line = buf.readLine()) != null) {
			String[] cmd = line.split(" ");
			String[] params = cmd[1].split(";");
			String[] coords = params[0].split(",");
			String[] coords2 = null;
			if (params.length > 1)
				 coords2 = params[1].split(",");
			switch (cmd[0]) {
			case "A":
				actors.add(new Actor(Float.parseFloat(coords[0]), 
									 Float.parseFloat(coords[1]),
									 125,0));
				break;
			case "I":
				items.add(new Item(Float.parseFloat(coords[0]), 
								   Float.parseFloat(coords[1])));
				break;
			case "W":
				walls.add(new Wall(Float.parseFloat(coords[0]), 
								   Float.parseFloat(coords[1]),
								   Float.parseFloat(coords2[0]),
								   Float.parseFloat(coords2[1])));
				break;
			}
		}
		buf.close();
		
		while (true) {
			//System.out.println("while iteration");
			if (!actActors())
				break;
		}
	}
	
	public boolean actActors() {
		long actualTime = System.currentTimeMillis();
		//System.out.println("Actual time:" + actualTime + "; current time: " + currTime);
		if (actualTime - storedTime >= FRAME) {
			totalframes++;
			storedTime = actualTime;
			for (int i = 0; i < actors.size(); i++) {
				Actor actor = actors.get(i);
				actor.randomshit();
				ArrayList<Item> items;
				if (!((items = getItemsInRange(actor.x, actor.y)).isEmpty())) {
					for (Item item : items) {
						actor.pickupItem(item);
					}
				}
			}
		}
		if (totalframes < 120)
			return true;
		return false;
	}

	protected ArrayList<Item> getItemsInRange(float x, float y) {
		ArrayList<Item> ret = new ArrayList<>(0);
		for (Item item : items) {
			Rectangle2D.Float rect = new Rectangle2D.Float(item.x - 2.5f, item.y - 2.5f, 5.0f, 5.0f);
			for (float alpha = 0.0f; alpha < 360.0f; alpha+=1.0f) {
				Line2D.Float line = new Line2D.Float(x, y, 
						(float)(x + 2.5f * Math.sin(alpha*Math.PI/180)), 
						(float)(y + 2.5f * Math.cos(alpha*Math.PI/180)));
				//System.out.println(line.x1 + "," + line.y1 + "," + line.x2 + "," + line.y2);
				if (rect.intersectsLine(line)) {
					ret.add(item);
					System.out.println("intersects");
					break;
				}
			}
		}
		//System.out.println(ret.size());
		return ret;
	}

}
