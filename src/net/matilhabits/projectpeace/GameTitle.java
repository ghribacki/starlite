package net.matilhabits.projectpeace;

import net.matilhabits.starlite.display.Color;
import net.matilhabits.starlite.display.Display;

public class GameTitle {
	public static void render(Display screen, int xo, int yo) {
		int width = 11;
		int height = 2;
		int xTitleTile = 28;
		int color = Color.get(-1, 0, 7, 9);
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				screen.render(xo + x * 8, yo + y * 8, x + (y + xTitleTile) * 32, color, false);
			}
		}
	}
}
