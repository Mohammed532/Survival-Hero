package survival_hero.entity.creatures;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import survival_hero.engine.entity.creatures.Creatures;
import survival_hero.engine.res.gfx.Animation;
import survival_hero.generic.Handler;
import survival_hero.main.Game;
import survival_hero.res.gfx.Assets;

public class Player extends Creatures{
	
	
	private static double playerWidth = Creatures.DEFAULT_CREATURE_WIDTH * 1.25;
	private static double playerHeight = Creatures.DEFAULT_CREATURE_HEIGHT * 1.25;
	
	private int face = 0;
	
	//Animations//
	private Animation playerUpAnim;
	private Animation playerDownAnim;
	private Animation playerLeftAnim;
	private Animation playerRightAnim;

	public Player(Handler handler, float x, float y, int health) {
		super(handler, x, y, (int) playerWidth, (int) playerHeight, health);
		
		bounds.x = 29;
		bounds.y = 35;
		bounds.width = 30;
		bounds.height = 49;
		
		playerUpAnim = new Animation(1000/10, Assets.player_up);
		playerDownAnim = new Animation(1000/10, Assets.player_down);
		playerLeftAnim = new Animation(1000/2, Assets.player_left);
		playerRightAnim = new Animation(1000/2, Assets.player_right);
		
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up) {
			yMove = -speed;
		}
		
		if(handler.getKeyManager().down) {
			yMove = speed;
		}
		
		if(handler.getKeyManager().left) {
			xMove = -speed;
		}
		
		if(handler.getKeyManager().right) {
			xMove = speed;
		}
	}
	
	@Override
	public void tick() {

		getInput();
		move();
		handler.getGameCam().centerOnEntity(this);
		playerUpAnim.tick();
		playerDownAnim.tick();
		playerLeftAnim.tick();
		playerRightAnim.tick();
	}

	public void render(Graphics g) {
		
		///////////////Canvas/////////////////
		
		g.drawImage(getCurrentAnim(), (int)(x - handler.getGameCam().getxOffset()), 
				   					(int)(y - handler.getGameCam().getyOffset()), width, height, null);
	
		g.drawImage(Assets.compass, handler.getWidth() - 120, 20, 100, 100, null);
		
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		g.drawString(Integer.toString(handler.getFps()), 10, 30);
		
		
	
		g.setColor(Color.CYAN);
		g.fillRect((int)(x + bounds.x - handler.getGameCam().getxOffset()),
					(int)(y + bounds.y - handler.getGameCam().getyOffset()), bounds.width, bounds.height);
		
		/////////////////////////////////////
		
	}
	
	private BufferedImage getCurrentAnim() {
		
		if(xMove != 0 || yMove != 0) {
			if(yMove > 0) {
				face = 1;
				return playerUpAnim.getCurrentFrame();
			}else if(yMove < 0){
				face = 0;
				return playerDownAnim.getCurrentFrame();
			}else if(xMove > 0) {
				face = 3;
				return playerRightAnim.getCurrentFrame();
			}else {
				face = 2;
				return playerLeftAnim.getCurrentFrame();
			}
		}else { 
			if(face ==  0){
				return Assets.player1_backFace;
			}else if(face == 3) {
				return Assets.player1_rightFace;
			}else if(face == 2) {
				return Assets.player1_leftFace;
			}else {
				return Assets.player1_frontFace;
			}
		}
	
		
	}

}
