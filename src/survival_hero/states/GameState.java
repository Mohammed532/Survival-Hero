package survival_hero.states;

import java.awt.Color;
import java.awt.Graphics;

import survival_hero.entity.creatures.Player;
import survival_hero.entity.creatures.Zombie;
import survival_hero.entity.statics.Tree;
import survival_hero.generic.Handler;
import survival_hero.main.Game;
import survival_hero.res.gfx.Assets;
import survival_hero.res.gfx.tiles.Tile;
import survival_hero.worlds.Worlds;

public class GameState extends State{
	
	

	int width = Game.width;
	int height = Game.height;
	private Worlds mainWorld;

		
	public GameState(Handler handler) {
		super(handler);
		mainWorld = new Worlds(handler, "res/worlds/world1.txt");
		handler.setWorld(mainWorld);
		//player2 = new Player(handler, width/2, (height/2)-32, 50);

		
		
		
	}

	
	@Override
	public void tick() {
		
		mainWorld.tick();

		
		
		
	}

	@Override
	public void render(Graphics g) {
		
		//////////////////Canvas////////////////////
		
		mainWorld.render(g);
		//g.setColor(Color.red);
		//g.drawLine(0, height/2, width, height/2);
		
		////////////////////////////////////////////

	}

}
