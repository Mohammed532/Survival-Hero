package survival_hero.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import survival_hero.generic.Handler;
import survival_hero.main.Game;
import survival_hero.res.gfx.Assets;

public class MainMenu extends State{

	int width = Game.width;
	int height = Game.height;
	public static boolean play = false;
	
	public MainMenu(Handler handler) {
		super(handler);
	}	

	@Override
	public void tick() {
//		System.out.println(handler.getMouseManager().getMouseX() + " " + handler.getMouseManager().getMouseY());
		
		
	}

	@Override
	public void render(Graphics g) {
		
		
		////////////////Canvas////////////////
				
//		g.drawImage(Assets.menu, 0, 0, null);
		g.setColor(Color.RED);
		g.fillRect(0, 0, width, height);
		
		g.drawImage(Assets.title_text, 150, 0, 1000, 500, null);
		
		if(handler.getMouseManager().getMouseX() >= 450 && handler.getMouseManager().getMouseX() <= 800) {
			if(handler.getMouseManager().getMouseY() >= 325 && handler.getMouseManager().getMouseY() <= 445) {
				g.setColor(new Color(155, 10, 16));
				g.fillRect(450, 325, 380, 140);
				if(handler.getMouseManager().isLeftPressed()) {
					play = true;
					System.out.println(play);
				}
			}
		}else {
			g.setColor(Color.RED);
			g.fillRect(450, 325, 380, 140);
		}
		
		g.drawImage(Assets.play_text, 150, 150, 1000, 500, null);
		
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		g.drawString(Integer.toString(handler.getFps()), 10, 30);
		
		
		
		//////////////////////////////////////
	}
	
//	public static boolean getPlay() {
//		return play;
//	}

}
