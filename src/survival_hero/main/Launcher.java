package survival_hero.main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.concurrent.ThreadLocalRandom;

import survival_hero.engine.util.PerlinNoise;

public class Launcher {
	
	private static String title = "Suvival Hero";
	
	
	public static void main(String []args) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int width = d.width;
		int height = d.height;
		
		PerlinNoise pn = new PerlinNoise(30, 30, 8);
		
//		for(int i = 0; i < pn.getPerlinNoise().length; i += 10) {
//			float test = pn.getValue(i);
//			System.out.println(test * 5);
//		}
		
		Game game = new Game(title, width, height); 
		game.start();
	}
	
	
}
