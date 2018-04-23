package org.joohopark;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener{
	
	private boolean[] keyInput;
	public boolean down, left, right, space;
	
	public Input(){
		keyInput = new boolean[256];
	}
	
	public void keyPressed(){
		down = keyInput[KeyEvent.VK_S];//39
		left = keyInput[KeyEvent.VK_A];//37
		right = keyInput[KeyEvent.VK_D];//40
		space = keyInput[KeyEvent.VK_SPACE];//32
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keyInput[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keyInput[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {}

}
