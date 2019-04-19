package survival_hero.res.gfx.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	/////////////////////Tiles/////////////////////////
	
	public static Tile[] tile = new Tile[256];
	public static Tile waterTile = new WaterTile(0);
	public static Tile grassTile = new GrassTile(1);
	public static Tile grassRoseTile = new Grass_RoseTile(2);
	public static Tile dirtTile = new DirtTile(3);
	public static Tile stonetile = new StoneTile(4);
	public static Tile sandTile = new SandTile(5);
	
	///////////////////////////////////////////////////
	
	private int tileAmt = 5; //Amount of tiles
	public static final int TILEWIDTH = (int) (64 * 1.25), TILEHEIGHT = (int) (64 * 1.25);
	
	protected BufferedImage texture;
	protected final int id;

	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tile[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public int getId() {
		return id;
	}
	
	public int tileAmt() {
		return tileAmt;
	}
	
}
