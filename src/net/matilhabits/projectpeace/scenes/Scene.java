package net.matilhabits.projectpeace.scenes;

import net.matilhabits.projectpeace.Game;
import net.matilhabits.projectpeace.InputHandler;
import net.matilhabits.projectpeace.gfx.Screen;
import net.matilhabits.projectpeace.level.Dialog;

public abstract class Scene {
	protected Game game;
	protected InputHandler input;
	protected Dialog dialog;
	
	public Scene(Game game, InputHandler input) {
		this.game = game;
		this.input = input;
	}
	
	public abstract void update();
	
	public abstract void render(Screen screen);
	
	public void setDialog(Dialog dialog) {
		this.dialog = dialog;
	}
}
