package net.matilhabits.projectpeace.scenes;

import net.matilhabits.projectpeace.GameTitle;
import net.matilhabits.starlite.Game;
import net.matilhabits.starlite.audio.Audio;
import net.matilhabits.starlite.display.Display;
import net.matilhabits.starlite.input.Input;

public class TitleScene extends MenuScene {
	public TitleScene(Game game, Input input) {
		super(game, input);
	}
	
	public void init() {
		this.menuList.add("Play game");
		//this.menuList.add("Achievements");
		this.menuList.add("About");
	}
	
	public void update() {
		this.updateCursor();
		
		if (this.input.menu.clicked || this.input.action.clicked) {
			switch (this.selected) {
				case 0:
					this.game.setScene(new GameScene(this.game, this.input));
					break;
				case 1:
					this.game.setScene(new AboutScene(this.game, this.input, this));
					break;
				default:
			}
			Audio.enter.play();
		}
	}

	public void render(Display screen) {
		screen.clear(1);
		GameTitle.render(screen, 80, 4);
		this.renderMenu(screen, 78, 70);
		//Font.draw("by ghribacki", screen, 80, 24, Color.get(-1, 0, 0, 7));
		//Font.draw(Game.VERSION, screen, 48, 34, Color.get(-1, 0, 0, 7));
		
	}
}
