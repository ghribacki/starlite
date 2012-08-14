package net.matilhabits.projectpeace.scenes;

import net.matilhabits.projectpeace.level.Dialog;
import net.matilhabits.starlite.Game;
import net.matilhabits.starlite.display.Display;
import net.matilhabits.starlite.input.Input;

public abstract class Scene {
	protected Game game;
	protected Input input;
	protected Dialog dialog;
	
	public Scene(Game game, Input input) {
		this.game = game;
		this.input = input;
	}
	
	public abstract void update();
	
	public abstract void render(Display screen);
	
	public void setDialog(Dialog dialog) {
		this.dialog = dialog;
	}
}
