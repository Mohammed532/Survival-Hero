package survival_hero.main;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Launcher {
	
	
	private static String title = "Suvival Hero";
	
	
	public static void main(String []args) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int width = d.width;
		int height = d.height;
		
		Game game = new Game(title, width, height); 
		game.start();
	}
	
	
}
