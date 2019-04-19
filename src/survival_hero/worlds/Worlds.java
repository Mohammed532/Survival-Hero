package survival_hero.worlds;

import java.awt.Graphics;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import survival_hero.engine.entity_manager.EntityManager;
import survival_hero.engine.util.Utils;
import survival_hero.entity.creatures.Player;
import survival_hero.entity.statics.Tree;
import survival_hero.generic.Handler;
import survival_hero.main.Game;
import survival_hero.res.gfx.tiles.Tile;

public abstract class Worlds {
	
	private Handler handler;
	private String path;
	private boolean loadRandom = false;
	private int width, height;
	private int xSpawn, ySpawn;
	private int[][] tiles;
	private int[][] noise;
	private EntityManager entityManager;
	private Random treeGen = new Random();
	
	
	public Worlds(Handler handler, String path) {
		this.handler = handler;
		this.path = path;
//		entityManager = new EntityManager(handler, new Player(handler, 100, 100, 100));
//		
////		int i = 1;
////		
////		while(i < 50) {
////			entityManager.addEntity(new Tree(handler, treeGen.nextInt(1000) + 200, treeGen.nextInt(600) + 200, 100, 130));
////			i++;
////		}
//		
//		
//		loadWorld(path);
//		
//		entityManager.getPlayer().setX(xSpawn);
//		entityManager.getPlayer().setY(ySpawn);
	}
	
//	@Deprecated
//	private void loadWorld(String path) {
//		
//		String file = Utils.loadFileAsString(path);
//		String[] token = file.split("\\s+");
//		
//		
//		width = Utils.parseInt(token[0]);
//		height = Utils.parseInt(token[1]);
//		xSpawn = Utils.parseInt(token[2]);
//		ySpawn = Utils.parseInt(token[3]);
//		
//		tiles = new int[width][height];
//		
////		for(int i = 0; i < token.length; i++) {
////			System.out.print(token[i] + " ");
////		}
//		
//		for(int y = 0; y < height; y++) {
//			for(int x = 0; x < width; x++) {
//				tiles[x][y] = Utils.parseInt(token[(x + y * width) + 4]);
//			}
//		}
//			
//	}

	
	protected abstract void loadWorld(String path);
	
	public void loadRandomNoise(Document doc, Node worldMap, int width, int height) {
		noise = new int[width][height];
		String worldMapString;
		
		for(int y = 0; y < height; y++) {
			worldMapString = "";
			for(int x = 0; x < width; x++) {
				tiles[x][y] = ThreadLocalRandom.current().nextInt(0, 6);
				
//				worldMapString = worldMapString.concat(Integer.toString(noise[x][y]) + " ");
			}
////			worldMap.appendChild(doc.createTextNode(worldMapString));
//			worldMap.appendChild(doc.createTextNode("3 3 3 3 3"));
		}
		
	}
	
	public abstract Tile getTile(int x, int y);
	
	public abstract void tick();

	public abstract void render(Graphics g);
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}


	
	
	
}
