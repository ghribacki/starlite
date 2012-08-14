package net.matilhabits.projectpeace.level.tiles;

import net.matilhabits.projectpeace.level.Level;
import net.matilhabits.starlite.display.Color;
import net.matilhabits.starlite.display.Display;

public abstract class Tile {
	public static Tile[] tiles = new Tile[5];
	public static Tile air = new AirTile(0);
	public static Tile grass = new BlockTile(1, 36, Color.get(-1, 141+111, 141, 141+111), true);
	public static Tile sand = new BlockTile(2, 37, Color.get(-1, 550-110, 550, 550-110), true);
	public static Tile iron = new BlockTile(3, 38, Color.get(-1, 444, 333, 444), false);
	public static Tile dirt = new BlockTile(4, 39, Color.get(-1, 367+111, 367, 367+111), true);
	
	public static int upBorder = 4;
	public static int downBorder = 5;
	public static int leftBorder = 6;
	public static int rightBorder = 7;
	public static int upLeftBorder = 8;
	public static int upRightBorder = 9;
	public static int downLeftBorder = 10;
	public static int downRightBorder = 11;
	
	public final int id;
	public int sprite;
	public int colors;
	public boolean blocks;
	public boolean climbable;
	
	public Tile(int id) {
		this.id = id;
		this.blocks = false;
		if (Tile.tiles[id] != null) {
			throw new RuntimeException("Duplicated tile ids!");
		}
		Tile.tiles[id] = this;
	}
	
	public abstract void render(Display screen, Level level, int x, int y);

}
