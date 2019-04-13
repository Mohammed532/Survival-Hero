package survival_hero.entity.statics;

import survival_hero.entity.Entity;
import survival_hero.generic.Handler;

public abstract class StaticEntity extends Entity{

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		
	}

}
