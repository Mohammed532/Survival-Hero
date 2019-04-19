package survival_hero.engine.entity_manager;

import java.awt.Graphics;
import java.util.ArrayList;

import survival_hero.entity.creatures.Player;
import survival_hero.generic.Handler;

public class EntityManager {
	
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entity;
	
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entity = new ArrayList<Entity>();
	}
	
	public void tick() {
		for(int i = 0; i < entity.size(); i++) {
			Entity e = entity.get(i);
			e.tick();
		}
		player.tick();
		
	}
	
	public void render(Graphics g) {
		for(Entity e : entity) {
			e.render(g);
		}
		
		player.render(g);
	}
	
	public void addEntity(Entity e) {
		entity.add(e);
	}
	
	//GETTERS & SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	

	
	

}
