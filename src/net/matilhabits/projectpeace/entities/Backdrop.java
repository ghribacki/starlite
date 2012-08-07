package net.matilhabits.projectpeace.entities;

import net.matilhabits.projectpeace.gfx.Screen;
import net.matilhabits.projectpeace.level.Level;

public class Backdrop extends Entity {
	private int sprite;
	private int width;
	private int height;
	private boolean flip;
	private int color;

	public Backdrop(int sprite, int width, int height, Level level, boolean flip, int color) {
		super(level);
		this.sprite = sprite;
		this.width = width;
		this.height = height;
		this.flip = flip;
		this.color = color;
	}

	public void render(Screen screen) {		
		for (int x = 0; x < this.width; x++) {
			for (int y = 0; y < this.height; y++) {
				screen.render(this.x + x * 8, this.y + y * 8, this.sprite + x + (y * 32), this.color, this.flip);
			}
		}
	}

	public void update() {
	}

}
