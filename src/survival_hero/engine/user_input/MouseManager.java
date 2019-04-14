package survival_hero.engine.user_input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener{
	private boolean leftPressed,middlePressed, rightPressed;
	private int mouseX, mouseY;
	
	public MouseManager(){
		
	}
	
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			leftPressed = true;
		}else if(e.getButton() == MouseEvent.BUTTON2) {
			middlePressed = true;
		}else if(e.getButton() == MouseEvent.BUTTON3) {
			rightPressed = true;
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			leftPressed = false;
		}else if(e.getButton() == MouseEvent.BUTTON2) {
			middlePressed = false;
		}else if(e.getButton() == MouseEvent.BUTTON3) {
			rightPressed = false;
		}
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	///////////////GETTERS////////////////
	
	public boolean isLeftPressed(){
		return leftPressed;
	}
	
	public boolean isRightPressed(){
		return rightPressed;

	}
	
	public int getMouseX() {
		return mouseX;
	}
	
	public int getMouseY() {
		return mouseY;
	}
	
	
	////////IMPLEMENTED METHODS//////////

	
}