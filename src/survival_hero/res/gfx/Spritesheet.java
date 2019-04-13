package survival_hero.res.gfx;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class Spritesheet {
	
	private BufferedImage sprite;
	
	public Spritesheet(BufferedImage sprite) {
		this.sprite = sprite;
		
	}
	
	public BufferedImage select(int x, int y, int width, int height) {
		return sprite.getSubimage(x, y, width, height);
		
	}



}
