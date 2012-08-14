package net.matilhabits.starlite;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import net.matilhabits.projectpeace.scenes.Scene;
import net.matilhabits.projectpeace.scenes.TitleScene;
import net.matilhabits.starlite.display.Color;
import net.matilhabits.starlite.display.Display;
import net.matilhabits.starlite.display.Font;
import net.matilhabits.starlite.display.SpriteSheet;
import net.matilhabits.starlite.input.Input;

/**
 * The main component of the engine.
 * Needs to be extended by the user application to run it.
 * 
 * @author ghribacki
 */
public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	
	// Defined by the user application:
	public static final String TITLE = "Project Peace";
	public static final String VERSION = "LUDUM DARE 23: Day 3";
	
	// Resolution shall be static, scale shall be defined by the applet parameters.
	public static final int WIDTH = 250;
	public static final int HEIGHT = 150;
	public static final int SCALE = 2;
	
	public String debugString = "";
	
	private BufferedImage screenBuffer;
	private int[] pixels;
	private boolean running;
	private Display display;
	private Input input;
	
	private int[] colors;
	
	private Scene scene;
	
	public Game() {
		this.screenBuffer = new BufferedImage(Game.WIDTH, Game.HEIGHT, BufferedImage.TYPE_INT_RGB);
		this.pixels = ((DataBufferInt) screenBuffer.getRaster().getDataBuffer()).getData();
		this.running = false;
		this.input = new Input(this);
		this.colors = new int[256];
	}
	
	private void init() {
		// Initiate that color array?
		int pp = 0;
		for (int r = 0; r < 6; r++) {
			for (int g = 0; g < 6; g++) {
				for (int b = 0; b < 6; b++) {
					int rr = (r * 255 / 5);
					int gg = (g * 255 / 5);
					int bb = (b * 255 / 5);
					int mid = (rr * 30 + gg * 59 + bb * 11) / 100;

					int r1 = ((rr + mid * 1) / 2) * 230 / 255 + 10;
					int g1 = ((gg + mid * 1) / 2) * 230 / 255 + 10;
					int b1 = ((bb + mid * 1) / 2) * 230 / 255 + 10;
					colors[pp++] = r1 << 16 | g1 << 8 | b1;
				}
			}
		}		
		
		try {
			this.display = new Display(Game.WIDTH, Game.HEIGHT, new SpriteSheet(ImageIO.read(Game.class.getResourceAsStream("/spritesheet.png"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Creates the first scene.
		this.setScene(new TitleScene(this, this.input));
	}

	public void run() {
		long lastTime = System.nanoTime();
		double unprocessed = 0;
		double nsPerUpdate = 1000000000.0/60.0;
		int frames = 0;
		int updates = 0;
		long lastTimer = System.currentTimeMillis();
		
		this.init();

		this.debugString = "0 updates, 0 fps";
		
		while (this.running) {
			long now = System.nanoTime();
			unprocessed = unprocessed + (now - lastTime) / nsPerUpdate;
			lastTime = now;
			boolean shouldRender = true;
			while (unprocessed >= 1) {
				updates++;
				this.update();
				unprocessed -= 1;
				shouldRender = true; // What the..?
			}
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (shouldRender) {
				frames++;
				this.render();
			}
			
			if ((System.currentTimeMillis() - lastTimer) > 1000) {
				lastTimer += 1000;
				this.debugString = updates + " updates, " + frames + " fps";
				frames = 0;
				updates = 0;
			}
		}
	}
	
	private void update() {
		if (!this.hasFocus()) {
			this.input.releaseAll();
		} else {
			this.input.update();
			this.scene.update();
		}
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			this.requestFocus();
			return;
		}
		
		// Render the current scene.
		this.scene.render(this.display);
		
		if (!this.hasFocus()) {
			display.setOffset(0, 0);
			for (int i = 0; i < 32; i++) {
				for (int j = 0; j < 3; j++) {
					if (j > 0) {
						display.render(i*8, 126+j*8, 71, Color.get(-1, 0, 9, 2), false);
					} else {
						display.render(i*8, 133+j*8, 5, Color.get(-1, 0, 1, 2), false);
					}
				}
			}
			Font.draw("CLICK TO FOCUS!", display, 67, 139, Color.get(-1, 0, 0, 44));
		}
		
		// Flushes the screen to the buffer.
		for (int y = 0; y < Game.HEIGHT; y++) {
			for (int x = 0; x < Game.WIDTH; x++) {
				int cc = this.display.pixels[x + y * this.display.width];
				if (cc < 255) {
					pixels[x + y * Game.WIDTH] = colors[cc];
				}
			}
		}
		
		Graphics g = bs.getDrawGraphics();
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		int ww = Game.WIDTH * Game.SCALE;
		int hh = Game.HEIGHT * Game.SCALE;
		int xo = (this.getWidth() - ww) / 2;
		int yo = (this.getHeight() - hh) / 2;
		g.drawImage(screenBuffer, xo, yo, ww, hh, null);
		g.dispose();
		bs.show();
	}
	
	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public void start() {
		this.running = true;
		new Thread(this).start();
	}
	
	public void stop() {
		this.running = false;
	}
	
	// Maybe remove this one...
	public static void main(String args[]) {
		Game game = new Game();
		Dimension dimension = new Dimension(Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE);
		game.setMinimumSize(dimension);
		game.setMaximumSize(dimension);
		game.setPreferredSize(dimension);
	
		JFrame frame = new JFrame(Game.TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(game, BorderLayout.CENTER);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();	
	}

}
