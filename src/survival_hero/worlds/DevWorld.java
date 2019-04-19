package survival_hero.worlds;

import java.awt.Graphics;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import survival_hero.engine.entity_manager.EntityManager;
import survival_hero.engine.util.PerlinNoise;
import survival_hero.engine.util.Utils;
import survival_hero.entity.creatures.Player;
import survival_hero.generic.Handler;
import survival_hero.res.gfx.tiles.Tile;

public class DevWorld extends Worlds{
	
	private PerlinNoise pn;
	private Handler handler;
	private EntityManager entityManager;
	private Random treeGen = new Random();
	
	private int width, height;
	private int xSpawn, ySpawn;
	private int[][] tiles;
	private int[][] noise;
	
	public DevWorld(Handler handler, String path) {
		super(handler, path);
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100, 100));
		
//		int i = 1;
//		
//		while(i < 50) {
//			entityManager.addEntity(new Tree(handler, treeGen.nextInt(1000) + 200, treeGen.nextInt(600) + 200, 100, 130));
//			i++;
//		}
		
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(xSpawn);
		entityManager.getPlayer().setY(ySpawn);
	}
	

	
	protected void loadWorld(String path) {
//		Document doc = Utils.readXMLFile(path);
		Document doc = Utils.readXMLFile("res/worlds/dev_world.xml");
		
		Node worldData = doc.getElementsByTagName("data").item(0);
		if(worldData.getNodeType() == Node.ELEMENT_NODE) {	
			Element eWorldData = (Element) worldData;
			width = Utils.parseInt(
					eWorldData.getElementsByTagName("width").item(0).getTextContent());
			height = Utils.parseInt(
					eWorldData.getElementsByTagName("height").item(0).getTextContent());
			xSpawn = Utils.parseInt(
					eWorldData.getElementsByTagName("xSpawn").item(0).getTextContent());
			ySpawn = Utils.parseInt(
					eWorldData.getElementsByTagName("ySpawn").item(0).getTextContent());
			
		}
		
		pn = new PerlinNoise(width, height, 8);
		float[] perlinNoise = pn.getPerlinNoise();
		
		tiles = new int[width][height];
		
//		loadRandomNoise(doc, worldMap, width, height);
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
//				tiles[x][y] = Utils.parseInt(worldMapString.charAt(x + y * width));
				tiles[x][y] = (int)(6 * perlinNoise[x + y * width]);
				

				
			}
			
		}
		
		for(int i = 0; i < perlinNoise.length; i++) {
			System.out.println(perlinNoise[i] * 6);
		}
		
		
		
		
		
	}
	
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
