package net.matilhabits.projectpeace.scenes;

import net.matilhabits.starlite.Game;
import net.matilhabits.starlite.audio.Audio;
import net.matilhabits.starlite.display.Display;
import net.matilhabits.starlite.input.Input;

public class TheEndScene extends Scene {

	public TheEndScene(Game game, Input input) {
		super(game, input);
	}

	@Override
	public void update() {
		if (this.input.menu.clicked) {
			Audio.enter.play();
			this.game.setScene(new TitleScene(this.game, this.input));
		}
	}

	@Override
	public void render(Display screen) {
		screen.clear(0);
		
		screen.setOffset(0, 0);
	}

}
