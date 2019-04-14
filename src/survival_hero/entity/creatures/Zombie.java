package survival_hero.entity.creatures;

import java.awt.Graphics;

import survival_hero.engine.entity.creatures.Creatures;
import survival_hero.generic.Handler;
import survival_hero.res.gfx.Assets;

public class Zombie extends Creatures{

	public Zombie(Handler handler, float x, float y, int width, int height, int health) {
		super(handler, x, y, width, height, health);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.zombie_test, (int)(x - handler.getGameCam().getxOffset()),
				(int)(x - handler.getGameCam().getyOffset()), width, height, null);
		
	}

}
