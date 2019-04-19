package survival_hero.engine.entity_manager.creatures;

import survival_hero.engine.entity_manager.Entity;
import survival_hero.generic.Handler;
import survival_hero.main.Game;
import survival_hero.res.gfx.tiles.Tile;

public abstract class Creatures extends Entity {

	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 70;
	public static final int DEFAULT_CREATURE_HEIGHT = 70;
	
	protected int health;
	protected float speed;
	protected float xMove, yMove;
	
	
	public Creatures(Handler handler,float x, float y, int width, int height, int health) {
		super(handler, x, y, width, height);
		this.health = health;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		
	}
	
	protected boolean tileCollision(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}

	
	public void move() {
		moveX();
		moveY();
	}
	
	public void moveX() {
		if(xMove > 0) {
			int tx = (int)(x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			
			if(!tileCollision(tx, (int)(y + bounds.y) / Tile.TILEHEIGHT) && 
					!tileCollision(tx, (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}
		}else if(xMove < 0) {
			int tx = (int)(x + xMove + bounds.x) / Tile.TILEWIDTH;
			
			if(!tileCollision(tx, (int)(y + bounds.y) / Tile.TILEHEIGHT) && 
					!tileCollision(tx, (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}
		}
		
	}
	
	public void moveY() {
		if(yMove < 0) {
			int ty = (int)(y + yMove + bounds.y) / Tile.TILEHEIGHT;
			
			if(!tileCollision((int)(x + bounds.x) / Tile.TILEWIDTH, ty) && 
					!tileCollision((int)(x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}
		}else if(yMove > 0) {
			int ty = (int)(y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			
			if(!tileCollision((int)(x + bounds.x ) / Tile.TILEWIDTH, ty) && 
					!tileCollision((int)(x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
				y += yMove;
		}
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	

}
