package net.matilhabits.projectpeace.scenes;

import net.matilhabits.starlite.Game;
import net.matilhabits.starlite.display.Color;
import net.matilhabits.starlite.display.Display;
import net.matilhabits.starlite.display.Font;
import net.matilhabits.starlite.input.Input;

public class DebugScene extends Scene {
	private String inputString = "";
	
	public DebugScene(Game game, Input input) {
		super(game, input);
	}

	public void update() {
		this.inputString = "";
		if (this.input.up.down) {
			this.inputString = this.inputString + "UP ";
		} else {
			this.inputString = this.inputString + "   ";
		}
		if (this.input.down.down) {
			this.inputString = this.inputString + "DOWN ";
		} else {
			this.inputString = this.inputString + "     ";
		}
		if (this.input.left.down) {
			this.inputString = this.inputString + "LEFT ";
		} else {
			this.inputString = this.inputString + "     ";
		}
		if (this.input.right.down) {
			this.inputString = this.inputString + "RIGHT ";
		} else {
			this.inputString = this.inputString + "      ";
		}
		if (this.input.action.down) {
			this.inputString = this.inputString + "ACTION ";
		} else {
			this.inputString = this.inputString + "       ";
		}
		if (this.input.menu.down) {
			this.inputString = this.inputString + "MENU ";
		} else {
			this.inputString = this.inputString + "     ";
		}
	}

	public void render(Display screen) {
		screen.clear(0);
		Font.draw("   "+Game.TITLE, screen, 1, 1, Color.get(0, 0, 0, 800));
		Font.draw("     "+Game.VERSION, screen, 1, 9, Color.get(0, 0, 0, 500));
		Font.draw(this.game.debugString, screen, 1, Game.HEIGHT-8, Color.get(0, 0, 0, 25));
		
		Font.draw("Arrows             D      Enter", screen, 1, 65, Color.get(0, 0, 0, 155));
		Font.draw("UP DOWN LEFT RIGHT ACTION MENU", screen, 1, 73, Color.get(0, 0, 0, 77));
		Font.draw(this.inputString, screen, 1, 81, Color.get(0, 0, 0, 333));
		
		if (!this.game.hasFocus()) {
			Font.draw("        Click to focus!", screen, 1, 81, Color.get(0, 0, 0, 333));
		}
	}

}
