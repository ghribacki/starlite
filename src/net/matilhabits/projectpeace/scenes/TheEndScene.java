package net.matilhabits.projectpeace.scenes;

import net.matilhabits.projectpeace.Game;
import net.matilhabits.projectpeace.InputHandler;
import net.matilhabits.projectpeace.gfx.Screen;
import net.matilhabits.projectpeace.sound.SoundEffect;

public class TheEndScene extends Scene {

	public TheEndScene(Game game, InputHandler input) {
		super(game, input);
	}

	@Override
	public void update() {
		if (this.input.menu.clicked) {
			SoundEffect.enter.play();
			this.game.setScene(new TitleScene(this.game, this.input));
		}
	}

	@Override
	public void render(Screen screen) {
		screen.clear(0);
		
		screen.setOffset(0, 0);
	}

}
