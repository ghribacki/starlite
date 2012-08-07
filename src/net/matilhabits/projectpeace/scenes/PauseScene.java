package net.matilhabits.projectpeace.scenes;

import net.matilhabits.projectpeace.Game;
import net.matilhabits.projectpeace.InputHandler;
import net.matilhabits.projectpeace.gfx.Screen;
import net.matilhabits.projectpeace.sound.SoundEffect;

public class PauseScene extends MenuScene {
	private Scene parent;
	
	public PauseScene(Game game, InputHandler input, Scene parent) {
		super(game, input);
		this.parent = parent;
	}
	
	public void init() {
		this.menuList.add("Resume");
		//this.menuList.add("Achievements");
		this.menuList.add("Quit");
	}
	
	public void update() {
		this.updateCursor();
		
		if (this.input.menu.clicked || this.input.action.clicked) {
			switch (this.selected) {
				case 0:
					this.game.setScene(this.parent);
					break;
				case 1:
					this.game.setScene(new TitleScene(this.game, this.input));
					break;
				default:
			}
			SoundEffect.enter.play();
		}
	}

	public void render(Screen screen) {
		screen.clear(1);
		screen.setOffset(0, 0);
		//GameTitle.render(screen, 80, 4);
		this.renderMenu(screen, 78, 70);
		//Font.draw("by ghribacki", screen, 80, 24, Color.get(-1, 0, 0, 7));
		//Font.draw(Game.VERSION, screen, 48, 34, Color.get(-1, 0, 0, 7));
		
	}
}
