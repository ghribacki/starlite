package net.matilhabits.projectpeace;

import java.applet.Applet;
import java.awt.BorderLayout;

public class GameApplet extends Applet {
	private static final long serialVersionUID = 1L;

	private Game game;
	
	public void init() {
		this.game = new Game();
		this.setLayout(new BorderLayout());
		this.add(this.game, BorderLayout.CENTER);
	}
	
	public void start() {
		this.game.start();
	}
	
	public void stop() {
		this.game.stop();
	}
}
