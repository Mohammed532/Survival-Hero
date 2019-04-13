package survival_hero.states;

import java.awt.Graphics;

import survival_hero.generic.Handler;
import survival_hero.main.Game;

public abstract class State {
	
	protected Handler handler;
	private static State currentState = null;
	
	///////////////////ABSTRACT///////////////////////
	public abstract void tick();
	
	public abstract void render(Graphics g);
	//////////////////////////////////////////////////
	
	public State(Handler handler) {
		this.handler = handler;
	}
	
	public static void setState(State state) {
		currentState = state;
	}

	public static State getState() {
		return currentState;
	}
}
