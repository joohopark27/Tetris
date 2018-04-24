package org.joohopark;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener{
	
	public boolean down, left, right, space;
	
<<<<<<< HEAD
	public Input() {
		down = false;
		left = false;
		right = false;
		space = false;
=======
	public Input(){
		keyInput = new boolean[256];
	}
	
	public void keyPressed(){
		down = keyInput[KeyEvent.VK_S];//39
		left = keyInput[KeyEvent.VK_A];//37
		right = keyInput[KeyEvent.VK_D];//40
		space = keyInput[KeyEvent.VK_SPACE];//32
>>>>>>> 6312f280b4bd86aea0da5a92d67009832d8a47af
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_S:
			down = true;
			break;
		case KeyEvent.VK_A:
			left = true;
			break;
		case KeyEvent.VK_D:
			left = true;
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("spcae");
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_S:
			down = false;
			break;
		case KeyEvent.VK_A:
			left = false;
			break;
		case KeyEvent.VK_D:
			left = false;
			break;
		case KeyEvent.VK_SPACE:
			space = false;
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

}
