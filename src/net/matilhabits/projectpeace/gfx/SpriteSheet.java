package net.matilhabits.projectpeace.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	public int width;
	public int height;
	public int[] pixels;
	
	public static final int SHEET_WIDTH = 32;
	public static final int TILE_WIDTH = 8;
	
	public SpriteSheet(BufferedImage image) {
		this.width = image.getWidth();
		this.height = image.getHeight();
		this.pixels = image.getRGB(0, 0, this.width, this.height, null, 0, this.width);
		for (int i = 0; i < this.pixels.length; i++) {
			this.pixels[i] = (pixels[i] & 0xff) / 64;
		}
	}
}
