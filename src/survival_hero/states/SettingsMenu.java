package survival_hero.states;

import java.awt.Color;
import java.awt.Graphics;

import survival_hero.generic.Handler;
import survival_hero.main.Game;
import survival_hero.res.gfx.Assets;

public class SettingsMenu extends State{

	public SettingsMenu(Handler handler) {
		super(handler);
	}

	@Override
	public void tick() {
		
		
		
	}

	@Override
	public void render(Graphics g) {
		
	g.drawImage(Assets.setting, 0, 0, null);
		
	}

}
