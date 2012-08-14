package net.matilhabits.projectpeace.entities;

import net.matilhabits.projectpeace.level.Level;
import net.matilhabits.starlite.display.Display;

public abstract class Entity {
	public int x;
	public int y;
	public int width;
	public int height;
	
	public boolean alive;
	public Level level;
	
	public Entity(Level level) {
		this.level = level;
	}
	
	public abstract void render(Display screen);
	
	public abstract void update();
	
	public void remove() {
		this.alive = false;
	}
	
	public boolean intersects(int x0, int y0, int x1, int y1) {
		return !(((x + width) < x0) || ((y + height) < y0) || ((x - width) > x1) || ((y - height) > y1));
	}
}
