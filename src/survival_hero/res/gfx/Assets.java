package survival_hero.res.gfx;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;


public class Assets {
	private static final int width = 32, height = 32;
	
	//Tiles//
	public static BufferedImage test_player1, test_player2, dirt, grass, grass_rose, stone, tree, water,
								sand, test;
	//Creatures//
	public static BufferedImage player1_frontFace, player1_backFace, player1_leftFace, player1_rightFace,
								player2, zombie_test;
	
	public static BufferedImage[] player1_still = new BufferedImage[4];
	
	//Others//
	public static BufferedImage menu, setting, compass, title_text, play_text;
	
	//Animations//
	public static BufferedImage[] player_up;
	public static BufferedImage[] player_down;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;

	//public static BufferedImage[][] player1Animation;
	
	public static void init() {
		
		//Others
		menu = ImageLoader.loadImage("/textures/MainMenu.jpg");
		setting = ImageLoader.loadImage("/textures/Settings_test.png");
		compass = ImageLoader.loadImage("/textures/SH_compass.png");
		title_text = ImageLoader.loadImage("/textures/Survival_Hero_Text.png");
		play_text = ImageLoader.loadImage("/textures/Play_Text.png");
		
		//Tiles//
		Spritesheet tileSprite1 = new Spritesheet(ImageLoader.loadImage("/textures/tile_spritesheet1.png"));
		
		test_player1 = tileSprite1.select(0, 0, width, height);
		test_player2 = tileSprite1.select(32, 0, width, height);
		dirt = tileSprite1.select(64, 0, width, height);
		grass = tileSprite1.select(96, 0, width, height);
		grass_rose = tileSprite1.select(128, 0, width, height);
		stone = tileSprite1.select(160, 0, width, height);
		tree = tileSprite1.select(192, 0, width, height);
		water = tileSprite1.select(224, 0, width, height);
		sand = tileSprite1.select(256, 0, width, height);
		test = tileSprite1.select(288, 0, width, height);
		
		//Creatures//
		 BufferedImage[] player1_still = {player1_frontFace, player1_backFace, 
					player1_leftFace, player1_rightFace};
		
		Spritesheet chrSprite1 = new Spritesheet(ImageLoader.loadImage("/textures/chr_spritesheet1.png"));
		
		player1_frontFace = chrSprite1.select(0, 0, width, height);
		player1_backFace = chrSprite1.select(0, 32, width, height);
		player1_leftFace = chrSprite1.select(0, 64, width, height);
		player1_rightFace = chrSprite1.select(0, 96, width, height);
		
		zombie_test = chrSprite1.select(0, 128, width, height);
		
		//Animations//
		player_up = new BufferedImage[8];
		
		player_up[0] = chrSprite1.select(32, 0, width, height);
		player_up[1] = chrSprite1.select(64, 0, width, height);
		player_up[2] = chrSprite1.select(96, 0, width, height);
		player_up[3] = chrSprite1.select(128, 0, width, height);
		player_up[4] = chrSprite1.select(160, 0, width, height);
		player_up[5] = chrSprite1.select(192, 0, width, height);
		player_up[6] = chrSprite1.select(224, 0, width, height);
		player_up[7] = chrSprite1.select(256, 0, width, height);
		
		player_down = new BufferedImage[8];
		
		player_down[0] = chrSprite1.select(32, 32, width, height);
		player_down[1] = chrSprite1.select(64, 32, width, height);
		player_down[2] = chrSprite1.select(96, 32, width, height);
		player_down[3] = chrSprite1.select(128, 32, width, height);
		player_down[4] = chrSprite1.select(160, 32, width, height);
		player_down[5] = chrSprite1.select(192, 32, width, height);
		player_down[6] = chrSprite1.select(224, 32, width, height);
		player_down[7] = chrSprite1.select(256, 32, width, height);
		
		player_left = new BufferedImage[2];
		
		player_left[0] = chrSprite1.select(0, 64, width, height);
		player_left[1] = chrSprite1.select(32, 64, width, height);
		
		player_right = new BufferedImage[2];
		
		player_right[0] = chrSprite1.select(0, 96, width, height);
		player_right[1] = chrSprite1.select(32, 96, width, height);
		
		/*for(int i = 0, x = 32; i >= 7 && x == 32*8; i++, x += 32) {
			player_forward[i] = chrSprite1.select(x, 32, width, height);
		}*/
		
		/*player1Animation[0] = player1;
		player1Animation[1] = player_forward;*/
	}
	
	public Image ScaledImage(Image img, int w, int h){
		BufferedImage resizedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = resizedImage.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(img, 0, 0, w, h, null);
		g2.dispose();
		
		return resizedImage;
	}
	

}
