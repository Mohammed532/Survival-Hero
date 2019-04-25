package survival_hero.states;

import java.awt.Color;
import java.awt.Graphics;

import survival_hero.engine.util.PerlinNoise;
import survival_hero.generic.Handler;
import survival_hero.worlds.DevWorld;
import survival_hero.worlds.Worlds;

public class DevState extends State {
	
	private DevWorld devWorld;
	private PerlinNoise pn = new PerlinNoise(handler.getGame().width, 
													handler.getGame().height, 8);
	private float[] perlinNoise = pn.getPerlinNoise();
	public boolean ready = false;

	public DevState(Handler handler) {
		super(handler);
		devWorld = new DevWorld(handler, "res/worlds/dev_world.xml");
		handler.setWorld(devWorld);
		
//		Thread t = new Thread() {
//			public void run(Graphics g) {
//				render(g);
//			}
//		};
	}

	@Override
	public void tick() {
		devWorld.tick();
		
	}

	@Override
	public void render(Graphics g) {
//		devWorld.render(g);
		test(g);
		
	}
	
	private void test(Graphics g) {
		float[] rn = pn.createRandomNoise();
		int scale = 50;
//		g.setColor(grayscale(0));
//		
//		for(int i = 0; i < handler.getGame().width; i++) {
//			g.fillRect(i, (int) (handler.getGame().height * perlinNoise[i]), 1, 1);
//		}
//		
		for(int y = 0; y < handler.getGame().height; y++) {
			for(int x = 0; x < handler.getGame().width; x++) {
				g.setColor(grayscale((perlinNoise[x + y * handler.getGame().width])));
				System.out.println(perlinNoise[x + y * handler.getGame().width]);
				g.fillRect(x, y, scale, scale);
				
			}
		}
	
		
	}
	
	private Color grayscale(float num) {
		int rgbNum = (int) (255 * num);
		return new Color(rgbNum, rgbNum, rgbNum);
	}

}
