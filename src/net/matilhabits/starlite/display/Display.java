package net.matilhabits.starlite.display;

public class Display {
	public int width;
	public int height;
	public int[] pixels;
	
	public SpriteSheet sheet;
	
	// For scrolling!
	public int xOffset;
	public int yOffset;
	
	public Display(int width, int height, SpriteSheet spriteSheet) {
		this.width = width;
		this.height = height;
		
		this.sheet = spriteSheet;
		this.pixels = new int[this.width * this.height];
	}
	
	public void clear(int color) {
		for (int i = 0; i < this.pixels.length; i++) {
			this.pixels[i] = color;
		}
	}
	
	public void render(int xp, int yp, int tile, int colors, boolean mirrorX) {
		xp = xp - this.xOffset;
		yp = yp - this.yOffset;
		
		int xTile = tile % SpriteSheet.SHEET_WIDTH;
		int yTile = tile / SpriteSheet.SHEET_WIDTH;
		int tileOffset = (xTile * 8) + (yTile * 8 * this.sheet.width);
		
		for (int y = 0; y < SpriteSheet.TILE_WIDTH; y++) {
			int ys = y;
			if (((y + yp) < 0) || ((y + yp) >= this.height)) {
				continue;
			}
			for (int x = 0; x < SpriteSheet.TILE_WIDTH; x++) {
				if (((x + xp) < 0) || ((x + xp) >= this.width)) {
					continue;
				}
				
				int xs = x;
				if (mirrorX) {
					xs = 7 - x;
				}
				int col = (colors >> (this.sheet.pixels[xs + ys * this.sheet.width + tileOffset] * 8)) & 255;
				if (col < 255) {
					this.pixels[(x + xp) + (y + yp) * this.width] = col;
				}
			}
		}
	}
	
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}