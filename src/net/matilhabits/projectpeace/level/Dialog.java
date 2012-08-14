package net.matilhabits.projectpeace.level;

import net.matilhabits.projectpeace.scenes.Scene;
import net.matilhabits.starlite.audio.Audio;
import net.matilhabits.starlite.display.Color;
import net.matilhabits.starlite.display.Display;
import net.matilhabits.starlite.display.Font;

public class Dialog {
	private Scene parent;
	public String message;
	private String line1;
	private String line2;
	private int counter;
	private Dialog nextDialog;
	private boolean finished;
	private int typeTimer;
	private boolean flash;
	private int flashTimer;
	public int x;
	
	public Dialog(Scene parent, String message, Dialog nextDialog) {
		this.parent = parent;
		this.message = message;
		this.line1 = "";
		this.line2 = "";
		this.counter = 0;
		this.nextDialog = nextDialog;
		this.typeTimer = 0;
		this.finished = false;
		this.flash = false;
	}
	
	public void update() {
		this.typeTimer++;
		
		if (this.typeTimer == 2) {
			if (this.counter < this.message.length()) {
				if (this.line1.length() < 31) {
					this.line1 = this.line1 + this.message.charAt(this.counter);
				} else if (this.line2.length() < 31) {
					this.line2 = this.line2 + this.message.charAt(this.counter);
				}
				this.counter++;
				// TODO (canceled) Plays sound!
			} else {
				this.finished = true;
			}
			this.typeTimer = 0;
		}
		
		if (this.finished) {			
			this.flashTimer++;
			if (this.flashTimer > 15) {
				this.flashTimer = 0;
				this.flash = !this.flash;
			}
		}
	}
	
	public boolean hit() {
		boolean wasHit = false;
		if (this.finished) {
			this.parent.setDialog(this.nextDialog);
			wasHit = true;
			Audio.select.play();
		}
		return wasHit;
	}
	
	public void render(Display screen) {
		this.x = screen.xOffset;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < 3; j++) {
				if (j < 2) {
					screen.render(x+i*8, j*8, 71, Color.get(-1, 0, 1, 2), false);
				} else {
					screen.render(x+i*8, j*8, 5, Color.get(-1, 0, 1, 2), false);
				}
			}
		}
		
		// Sprite 38 for the background;
		// Sprite 5 for the bottom borders!
		
		if (this.flash) {
			if (this.nextDialog != null) {
				screen.render(this.x+242, 9, 1022, Color.get(-1, 9, 9, 9), false);
			} else {
				screen.render(this.x+242, 9, 1023, Color.get(-1, 9, 9, 9), false);
			}
		}
		
		Font.draw(this.line1, screen, this.x+1, 1, Color.get(-1, 9, 9, 9));
		Font.draw(this.line2, screen, this.x+1, 9, Color.get(-1, 9, 9, 9));
	}
}
