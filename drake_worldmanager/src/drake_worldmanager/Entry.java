package drake_worldmanager;

import java.io.IOException;

public class Entry {

	public static void main(String[] args) throws IOException, InterruptedException {
		World w = new World();
		w.init("demo.lvl");
	}

}
