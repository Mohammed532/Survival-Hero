package survival_hero.states;

import java.awt.Graphics;

import survival_hero.generic.Handler;
import survival_hero.worlds.DevWorld;
import survival_hero.worlds.Worlds;

public class DevState extends State {
	
	private DevWorld devWorld;

	public DevState(Handler handler) {
		super(handler);
		devWorld = new DevWorld(handler, "res/worlds/dev_world.xml");
		handler.setWorld(devWorld);
	}

	@Override
	public void tick() {
		devWorld.tick();
		
	}

	@Override
	public void render(Graphics g) {
		devWorld.render(g);
		
	}

}
