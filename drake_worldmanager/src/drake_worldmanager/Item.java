package drake_worldmanager;

import java.util.Timer;
import java.util.TimerTask;

public class Item extends Element {

	Timer t;
	boolean phased = false;
	
	public Item(float x, float y) {
		super(x, y);
		System.out.println("New item created.");
		System.out.println("coords:" + x + "," + y);
	}

	private void removeFromGame(long phaseTime) {
		phased = true;
		System.out.println("Item removed from the game.");
		if (phaseTime > 0) {
			t = new Timer();
			t.scheduleAtFixedRate(new TimerTask() {
				float elapse = 0.0f;
				@Override
				public void run() {
					elapse += 1*FRAME;
					//System.out.println("Elapsed time:" + elapse + "ms");
					if (elapse >= phaseTime) {
						addToGame();
						this.cancel();
					}
				}
				
			}, 0, 1*FRAME);
		}
	}

	private void addToGame() {
		phased = false;
		System.out.println("Item added.");
	}

	public boolean pickup(long phaseTime) {
		if (!phased) {
			System.out.println("Item picked up.");
			removeFromGame(phaseTime);
			return true;
		}
		return false;
	}
	
	public void activate() {
		
	}

}
