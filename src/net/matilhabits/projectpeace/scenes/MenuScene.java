package net.matilhabits.projectpeace.scenes;

import java.util.ArrayList;
import java.util.List;

import net.matilhabits.starlite.Game;
import net.matilhabits.starlite.audio.Audio;
import net.matilhabits.starlite.display.Color;
import net.matilhabits.starlite.display.Display;
import net.matilhabits.starlite.display.Font;
import net.matilhabits.starlite.input.Input;

public abstract class MenuScene extends Scene {
	protected final List<String> menuList;
	protected int selected;
	
	public MenuScene(Game game, Input input) {
		super(game, input);
		this.menuList = new ArrayList<String>();
		this.init();
	}
	
	public abstract void init();

	public void updateCursor() {
		if (input.down.clicked) {
			this.selected++;
			if (this.selected >= this.menuList.size()) {
				this.selected = 0;
			}
			Audio.select.play();
		}
		
		if (input.up.clicked) {
			this.selected--;
			if (this.selected < 0) {
				this.selected = this.menuList.size() - 1;
			}
			Audio.select.play();
		}
		
	}
	
	public void renderMenu(Display screen, int xo, int yo) {
		int sequence = 0;
		
		for (String item : this.menuList) {
			String cursor = "";
			if (this.selected == sequence) {
				cursor = ">";
			}
			Font.draw(cursor+item, screen, xo, yo + (sequence * 8), Color.get(-1, 444, 444, 444));
			sequence++;
		}
	}

}
