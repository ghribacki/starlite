package net.matilhabits.projectpeace.scenes;

import net.matilhabits.projectpeace.Game;
import net.matilhabits.projectpeace.GameTitle;
import net.matilhabits.projectpeace.InputHandler;
import net.matilhabits.projectpeace.gfx.Color;
import net.matilhabits.projectpeace.gfx.Font;
import net.matilhabits.projectpeace.gfx.Screen;
import net.matilhabits.projectpeace.sound.SoundEffect;

public class AboutScene extends Scene {
	private MenuScene parent;

	public AboutScene(Game game, InputHandler input, MenuScene parent) {
		super(game, input);
		this.parent = parent;
	}

	public void update() {
		if (this.input.menu.clicked) {
			SoundEffect.enter.play();
			this.game.setScene(this.parent);
		}
		
	}

	public void render(Screen screen) {
		screen.clear(1);
		
		GameTitle.render(screen, 80, 4);
		Font.draw("This game was made in 48h by", screen, 9, 49, Color.get(-1, 44, 44, 44));
		Font.draw("ghRibacki for the 23th Ludum", screen, 9, 57, Color.get(-1, 44, 44, 44));
		Font.draw("Dare compo in April 2012.", screen, 9, 65, Color.get(-1, 44, 44, 44));
		Font.draw("The proposed theme was Tiny", screen, 9, 81, Color.get(-1, 44, 44, 44));
		Font.draw("World.", screen, 9, 89, Color.get(-1, 44, 44, 44));
		Font.draw("Press ENTER to go back.", screen, 9, 113, Color.get(-1, 444, 444, 444));
		
	}

}
