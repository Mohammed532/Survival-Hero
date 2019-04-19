package survival_hero.generic;

import survival_hero.engine.user_input.KeyManager;
import survival_hero.engine.user_input.MouseManager;
import survival_hero.main.Game;
import survival_hero.res.gfx.GameCam;
import survival_hero.res.gfx.tiles.Tile;
import survival_hero.states.MainMenu;
import survival_hero.worlds.OverWorld;
import survival_hero.worlds.Worlds;

public class Handler {
	
	private Game game;
	private Worlds world;
	private OverWorld overWorld;
	private MainMenu mainMenu;
	private Tile tile;
	
	public Handler(Game game) {
		
		this.game = game;
		
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager(){
		return game.getMouseManager();
	}
	
	public GameCam getGameCam() {
		return game.getGameCam();
	}
	
	public int getWidth() {
		return game.width;
	}
	
	public int getHeight() {
		return game.height;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	public int getFps() {
		return game.getFps();
	}

	public Worlds getWorld() {
		return world;
	}

	public void setWorld(Worlds world) {
		this.world = world;
	}
	
	public int tileAmt() {
		return tile.tileAmt();
	}
	
//	public boolean isPlayTrue() {
//		return mainMenu.getPlay();
//	}

}
