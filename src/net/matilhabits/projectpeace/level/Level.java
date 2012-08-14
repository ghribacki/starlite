package net.matilhabits.projectpeace.level;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import net.matilhabits.projectpeace.entities.Entity;
import net.matilhabits.projectpeace.entities.Player;
import net.matilhabits.projectpeace.level.tiles.Tile;
import net.matilhabits.starlite.Game;
import net.matilhabits.starlite.display.Display;

public class Level {
	public int width;
	public int height;
	
	public byte[] tiles;
	public List<Entity> entities;
	
	public Player player;
	
	public Level(Level parentLevel) {
		this.tiles = Level.loadLevel("desert");
		this.width = this.tiles.length/19;
		this.height = 19;
		
		this.entities = new ArrayList<Entity>();
	}
	
	public void renderBackground(Display screen) {
		int xo = screen.xOffset / 8;
		int yo = screen.yOffset / 8;
		int width = (screen.width + 15) / 8;
		int height = (screen.height + 15) / 8;
		
		for (int y = yo; y < height + yo; y++) {
			for (int x = xo; x < width + xo; x++) {
				this.getTile(x, y).render(screen, this, x, y);
			}
		}
	}
	
	public void renderSprites(Display screen) {
		for (Entity entity : this.entities) {
			if ((entity.x >= (screen.xOffset - 16)) && (entity.x < (screen.xOffset + screen.width + 16)) && (entity.y >= (screen.yOffset - 16)) && (entity.y < (screen.yOffset + screen.height))) {
				entity.render(screen);
			}
		}
		this.player.render(screen);
	}
	
	public Tile getTile(int x, int y) {
		if ((x < 0) || (y < 0) || (x >= this.width) || (y >= this.height)) {
			return Tile.air;
		} else {
			return Tile.tiles[this.tiles[x + y * this.width]];
		}
	}
	
	public static byte[] loadLevel(String levelName) {
		byte[] tilemap;
		BufferedImage levelData = null;
		
		try {
			levelData = ImageIO.read(Game.class.getResourceAsStream("/level1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int size = levelData.getWidth()*levelData.getHeight();
		
		tilemap = new byte[size];

		for (int j = 0; j < levelData.getHeight(); j++) {
			for (int i = 0; i < levelData.getWidth(); i++) {
				int tile = 0;
				switch (levelData.getRGB(i, j)) {
					case -14254336:
						tile = Tile.grass.id;
						break;
					case -8427008:
						tile = Tile.sand.id;
						break;
					case -12566464:
						tile = Tile.iron.id;
						break;
					case -8441088:
						tile = Tile.dirt.id;
						break;
					case -16777216:
					default:
						tilemap[i + j * levelData.getWidth()] = 0;
				}
				tilemap[i + j * levelData.getWidth()] = (byte) tile;
			}
		}
		
		return tilemap;
	}

	public void update() {
		for (Entity entity : this.entities) {
			entity.update();
		}
		this.player.update();
	}
	
	public void addPlayer(Player player) {
		this.player = player;
	}

	public void addEntity(Entity entity) {
		this.entities.add(entity);
	}
}
