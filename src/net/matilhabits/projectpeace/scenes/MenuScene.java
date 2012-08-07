package net.matilhabits.projectpeace.scenes;

import java.util.ArrayList;
import java.util.List;

import net.matilhabits.projectpeace.Game;
import net.matilhabits.projectpeace.InputHandler;
import net.matilhabits.projectpeace.gfx.Color;
import net.matilhabits.projectpeace.gfx.Font;
import net.matilhabits.projectpeace.gfx.Screen;
import net.matilhabits.projectpeace.sound.SoundEffect;

public abstract class MenuScene extends Scene {
	protected final List<String> menuList;
	protected int selected;
	
	public MenuScene(Game game, InputHandler input) {
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
			SoundEffect.select.play();
		}
		
		if (input.up.clicked) {
			this.selected--;
			if (this.selected < 0) {
				this.selected = this.menuList.size() - 1;
			}
			SoundEffect.select.play();
		}
		
	}
	
	public void renderMenu(Screen screen, int xo, int yo) {
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
