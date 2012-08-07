package net.matilhabits.projectpeace.entities;

import net.matilhabits.projectpeace.InputHandler;
import net.matilhabits.projectpeace.gfx.Color;
import net.matilhabits.projectpeace.gfx.Screen;
import net.matilhabits.projectpeace.level.Level;

public class Player extends Entity {
	private InputHandler input;
	private boolean climbing;
	private boolean flip;
	private boolean walking;
	private int updates;
	public boolean down;
	//private int ySpeed;
	//private boolean jumping;
	//private final int GRAVITY = 1;
	//private final int TERMINAL_SPEED = 2;
	
	public String receivedMessage;
	
	public Player(Level level, InputHandler input) {
		super(level);
		this.input = input;
		this.width = 5;
		this.receivedMessage = null;
	}

	public void render(Screen screen) {
		int flipPix = 0;
		if (this.flip) {
			flipPix = 1;
		}
		int spriteDelta = 0;
		if (this.walking) {
			if (this.updates < 20) {
				spriteDelta = 64;
			}
		} else if (this.down) {
			spriteDelta = 2;
		}
		screen.render(this.x - 8 + (8 * flipPix), this.y - 16, 32 + spriteDelta, Color.get(-1, 5, 441, 5), flip);
		screen.render(this.x - (8 * flipPix), this.y - 16, 33 + spriteDelta, Color.get(-1, 5, 441, 5), flip);
		screen.render(this.x - 8 + (8 * flipPix), this.y - 8, 64 + spriteDelta, Color.get(-1, 5, 441, 5), flip);
		screen.render(this.x - (8 * flipPix), this.y - 8, 65 + spriteDelta, Color.get(-1, 5, 441, 5), flip);
	}

	public void update() {
		/*System.out.println(this.x);
		if (this.input.magicLeft.clicked) {
			this.x = this.x + 256;
		}
		if (this.input.magicRight.clicked) {
			this.x = this.x + 512;
		}*/
		
		if (this.walking) {
			this.updates++;
			if (this.updates > 40) {
				this.updates = 0;
			}
		} else {
			this.updates = 0;
		}
		
		if (this.input.action.clicked) {
			for (Entity entity : this.level.entities) {
				if (entity instanceof TinyPerson) {
					String msg = ((TinyPerson) entity).getMessage();
					if (msg != null) {
						this.receivedMessage = msg;
						break;
					}
				}
			}
		}
		
		// Horizontal.
		int dx = 0;
		
		if (this.input.left.down) {
			dx = -1;
			this.flip = true;
			this.walking = true;
			this.down = false;
		}
		if (this.input.right.down) {
			dx = 1;
			this.flip = false;
			this.walking = true;
			this.down = false;
		}
		if (!this.input.right.down && !this.input.left.down) {
			this.walking = false;
		}
		
		if (dx > 0) {
			if (this.level.getTile((this.x + this.width) / 8, (this.y - 1) / 8).blocks
					|| this.level.getTile((this.x + this.width) / 8, (this.y - 8) / 8).blocks
					|| this.level.getTile((this.x + this.width) / 8, (this.y - 16) / 8).blocks
					|| (this.x > (this.level.width * 8) - this.width)) {
				dx = 0;
			}
		} else if (dx < 0) {
			if (this.level.getTile((this.x - this.width - 1) / 8, (this.y - 1) / 8).blocks
					|| this.level.getTile((this.x - this.width - 1) / 8, (this.y - 8) / 8).blocks
					|| this.level.getTile((this.x - this.width - 1) / 8, (this.y - 16) / 8).blocks
					|| (this.x < this.width)) {
				dx = 0;
			}
		}
		
		this.x = this.x + dx;
		
		// Vertical.
		
		if (this.input.up.down && ((this.level.getTile((this.x - this.width - 2) / 8, (this.y - 1) / 8).climbable)
				|| (this.level.getTile((this.x + this.width + 2) / 8, (this.y - 1) / 8).climbable))) {
			this.climbing = true;
			this.y = this.y - 1;
		} else {
			this.climbing = false;
		}
		
		/*if (this.input.up.clicked && !this.jumping) {
			this.ySpeed = -5;
			this.jumping = true;
		}
		
		this.ySpeed = this.ySpeed + this.GRAVITY;
		if (this.ySpeed > this.TERMINAL_SPEED) {
			this.ySpeed = this.TERMINAL_SPEED;
		}
		if (this.ySpeed < -this.TERMINAL_SPEED) {
			this.ySpeed = -this.TERMINAL_SPEED;
		}*/
		
		if (!this.climbing) {
			this.y = this.y + 1;
			
			if (this.level.getTile((this.x + this.width - 1) / 8, (this.y - 1) / 8).blocks
					|| this.level.getTile((this.x - this.width) / 8, (this.y - 1) / 8).blocks
					|| this.level.getTile(this.x / 8, (this.y - 1) / 8).blocks) {
				this.y = this.y - 1;
				//this.jumping = false;
				//this.ySpeed = this.GRAVITY;
			}
		}
		
	}

}
