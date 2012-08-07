package net.matilhabits.projectpeace.level.tiles;

import net.matilhabits.projectpeace.gfx.Screen;
import net.matilhabits.projectpeace.level.Level;

public class BlockTile extends Tile {

	public BlockTile(int id, int sprite, int colors, boolean climbable) {
		super(id);
		this.blocks = true;
		this.sprite = sprite;
		this.colors = colors;
		this.climbable = climbable;
	}

	public void render(Screen screen, Level level, int x, int y) {
		boolean up = !level.getTile(x, y - 1).blocks;
		boolean down = !level.getTile(x, y + 1).blocks;
		boolean left = !level.getTile(x - 1, y).blocks;
		boolean right = !level.getTile(x + 1, y).blocks;
		
		screen.render(x * 8, y * 8, this.sprite, this.colors, false);
		
		if (up) {
			screen.render(x * 8, (y - 1) * 8, Tile.upBorder, this.colors, false);
		}
		if (down) {
			screen.render(x * 8, (y + 1) * 8, Tile.downBorder, this.colors, false);
		}
		if (left) {
			screen.render((x - 1) * 8, y * 8, Tile.leftBorder, this.colors, false);
		}
		if (right) {
			screen.render((x + 1) * 8, y * 8, Tile.rightBorder, this.colors, false);
		}
		
		// TODO (canceled) Borders on corners!
	}

}
