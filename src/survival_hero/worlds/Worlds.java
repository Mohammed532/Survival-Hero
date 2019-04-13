package survival_hero.worlds;

import java.awt.Graphics;
import java.util.Random;

import survival_hero.entity.EntityManager;
import survival_hero.entity.creatures.Player;
import survival_hero.entity.statics.Tree;
import survival_hero.generic.Handler;
import survival_hero.generic.Utils;
import survival_hero.main.Game;
import survival_hero.res.gfx.tiles.Tile;

public class Worlds {
	
	private Handler handler;
	private int width, height;
	private int xSpawn, ySpawn;
	private int[][] tiles;
	private EntityManager entityManager;
	private Random treeGen = new Random();
	
	
	public Worlds(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100, 100));
		
		int i = 1;
		
		while(i < 50) {
			entityManager.addEntity(new Tree(handler, treeGen.nextInt(1000) + 200, treeGen.nextInt(600) + 200, 100, 130));
			i++;
		}
		
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(xSpawn);
		entityManager.getPlayer().setY(ySpawn);
	}
	
	private void loadWorld(String path) {
		
		String file = Utils.loadFileAsString(path);
		String[] token = file.split("\\s+");
		
		width = Utils.parseInt(token[0]);
		height = Utils.parseInt(token[1]);
		xSpawn = Utils.parseInt(token[2]);
		ySpawn = Utils.parseInt(token[3]);
		
		tiles = new int[width][height];
		
		tiles = new int[width][height];
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(token[(x + y * width) + 4]);
			}
		}
		
	}
	
	public Tile getTile(int x, int y) {
		
		if(x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.grassTile;
		}
		
		Tile t = Tile.tile[tiles[x][y]];
		
		if(t == null) {
			return Tile.dirtTile;
		}else {
			return t;
		}
	}
	
	public void tick() {
		entityManager.tick();
	}

	public void render(Graphics g) {
		int xStart = (int)Math.max(0, handler.getGameCam().getxOffset() / Tile.TILEWIDTH);
		int yStart = (int)Math.max(0, handler.getGameCam().getyOffset() / Tile.TILEHEIGHT);
		int xEnd = (int) Math.min(width, (handler.getGameCam().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yEnd = (int) Math.min(height, (handler.getGameCam().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		
		for(int y = yStart; y < height; y++) {
			for(int x = xStart; x < width; x++) {
				getTile(x, y).render(g, (int)(x*Tile.TILEWIDTH - handler.getGameCam().getxOffset()),
										(int)( y*Tile.TILEHEIGHT - handler.getGameCam().getyOffset()));
			}
		}
		
		entityManager.render(g);
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}


	
	
	
}
