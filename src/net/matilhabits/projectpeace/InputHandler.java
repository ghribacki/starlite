package net.matilhabits.projectpeace;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class InputHandler implements KeyListener {
	public class Key {
		public int presses, absorbs;
		public boolean down, clicked;
		
		public Key() {
			keys.add(this);
		}
		
		public void toggle(boolean pressed) {
			if (pressed != this.down) {
				this.down = pressed;
			}
			if (pressed) {
				this.presses++;
			}
		}
		
		public void update() {
			if (this.absorbs < this.presses) {
				this.absorbs++;
				this.clicked = true;
			} else {
				this.clicked = false;
			}
		}
	}
	
	public List<Key> keys = new ArrayList<Key>();
	
	public Key up = new Key();
	public Key down = new Key();
	public Key left = new Key();
	public Key right = new Key();
	public Key action = new Key();
	public Key menu = new Key();
	public Key magicLeft = new Key();
	public Key magicRight = new Key();
	
	public InputHandler(Game game) {
		game.addKeyListener(this);
	}
	
	public void releaseAll() {
		for (int i = 0; i < keys.size(); i++) {
			keys.get(i).down = false;
		}
	}
	
	public void update() {
		for (int i = 0; i < keys.size(); i++) {
			keys.get(i).update();
		}
	}

	public void keyPressed(KeyEvent ke) {
		this.toggle(ke, true);
	}

	public void keyReleased(KeyEvent ke) {
		this.toggle(ke, false);
	}

	private void toggle(KeyEvent ke, boolean pressed) {
		switch (ke.getKeyCode()) {
			case KeyEvent.VK_UP:
				this.up.toggle(pressed);
				break;
			case KeyEvent.VK_DOWN:
				this.down.toggle(pressed);
				break;
			case KeyEvent.VK_LEFT:
				this.left.toggle(pressed);
				break;
			case KeyEvent.VK_RIGHT:
				this.right.toggle(pressed);
				break;
			case KeyEvent.VK_D:
				this.action.toggle(pressed);
				break;
			case KeyEvent.VK_ENTER:
				this.menu.toggle(pressed);
				break;
			case KeyEvent.VK_A:
				this.magicLeft.toggle(pressed);
				break;
			case KeyEvent.VK_S:
				this.magicRight.toggle(pressed);
				break;
		}
	}

	public void keyTyped(KeyEvent ke) {
	}

}
