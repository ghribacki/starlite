package net.matilhabits.projectpeace.entities;

import net.matilhabits.projectpeace.level.Level;
import net.matilhabits.starlite.display.Color;
import net.matilhabits.starlite.display.Display;

public class TinyPerson extends Entity {
	private boolean flip;
	private int updates;
	private boolean walking;
	private int color;
	private String message;
	private boolean playerClose;

	public TinyPerson(Level level, int color, String message) {
		super(level);
		this.width = 2;
		this.color = color;
		this.message = message;
	}

	public void render(Display screen) {
		int spriteDelta = 0;
		if (this.walking) {
			if (this.updates < 20) {
				spriteDelta = 1;
			}
		}
		screen.render(this.x - 4, this.y - 8, 0 + spriteDelta, this.color, flip);
		
		if (playerClose) {
			screen.render(this.x - 10, this.y - 14, 3, Color.get(-1, 0, 0, 555), false);
		}
	}

	public void update() {
		// Vertical.		
		this.y = this.y + 1;
		
		if (this.level.getTile((this.x + this.width - 1) / 8, (this.y - 1) / 8).blocks
				|| this.level.getTile((this.x - this.width) / 8, (this.y - 1) / 8).blocks) {
			this.y = this.y - 1;
		}
		
		// Player is close?
		
		if (this.message != null) {
			if (((this.level.player.x - this.x) < 25) && ((this.level.player.x - this.x) > -25)) {
				this.playerClose = true;
			} else {
				this.playerClose = false;
			}
		}
	}

	public String getMessage() {
		String message = null;
		if (this.playerClose) {
			message = this.message;
		}
		return message;
	}
}
