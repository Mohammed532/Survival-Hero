package survival_hero.engine.entity_manager.statics;

import survival_hero.engine.entity_manager.Entity;
import survival_hero.generic.Handler;

public abstract class StaticEntity extends Entity{

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		
	}

}
