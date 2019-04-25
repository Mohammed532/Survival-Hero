package survival_hero.engine.user_input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	
	private boolean[] keys;
	public boolean up, down, left, right, enter, space, esc, numb1, 
					numb2, t_key, home, end;
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	public void tick() {
		
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		enter = keys[KeyEvent.VK_ENTER];
		space = keys[KeyEvent.VK_SPACE];
		esc = keys[KeyEvent.VK_ESCAPE];
		numb1 = keys[KeyEvent.VK_1] || keys[KeyEvent.VK_NUMPAD1];
		numb2 = keys[KeyEvent.VK_2] || keys[KeyEvent.VK_NUMPAD2];
		t_key = keys[KeyEvent.VK_T];
		home = keys[KeyEvent.VK_HOME];
		end = keys[KeyEvent.VK_END];
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
