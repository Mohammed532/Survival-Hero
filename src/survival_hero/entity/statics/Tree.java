package survival_hero.entity.statics;

import java.awt.Graphics;

import survival_hero.engine.entity_manager.statics.StaticEntity;
import survival_hero.generic.Handler;
import survival_hero.res.gfx.Assets;

public class Tree extends StaticEntity{

	public Tree(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int)(x - handler.getGameCam().getxOffset()), (int)(x - handler.getGameCam().getyOffset()), width, height, null);
		
	}

}
