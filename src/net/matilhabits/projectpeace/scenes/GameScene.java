package net.matilhabits.projectpeace.scenes;

import net.matilhabits.projectpeace.Game;
import net.matilhabits.projectpeace.InputHandler;
import net.matilhabits.projectpeace.entities.Backdrop;
import net.matilhabits.projectpeace.entities.Player;
import net.matilhabits.projectpeace.entities.TinyPerson;
import net.matilhabits.projectpeace.gfx.Color;
import net.matilhabits.projectpeace.gfx.Screen;
import net.matilhabits.projectpeace.level.Dialog;
import net.matilhabits.projectpeace.level.Level;
import net.matilhabits.projectpeace.sound.SoundEffect;

public class GameScene extends Scene {
	private Level level;
	private Player player;
	//private BackgroundNoise bgNoise;

	public GameScene(Game game, InputHandler input) {
		super(game, input);
		this.level = new Level(null);

		this.player = new Player(this.level, this.input);
		this.level.addPlayer(this.player);
		this.player.x = 52;
		this.player.y = 112;
		this.player.down = true;
		
		//this.bgNoise = new BackgroundNoise(this.player);
		//this.bgNoise.start();
		
		Backdrop house = new Backdrop(40, 2, 2, this.level, false, Color.get(-1, 500, 422, 0));
		house.x = 450;
		house.y = 120;
		this.level.addEntity(house);
		
		house = new Backdrop(40, 2, 2, this.level, false, Color.get(-1, 500, 422, 0));
		house.x = 470;
		house.y = 120;
		this.level.addEntity(house);
		
		house = new Backdrop(40, 2, 2, this.level, false, Color.get(-1, 500, 422, 0));
		house.x = 500;
		house.y = 120;
		this.level.addEntity(house);
		
		house = new Backdrop(40, 2, 2, this.level, false, Color.get(-1, 500, 422, 0));
		house.x = 530;
		house.y = 120;
		this.level.addEntity(house);
		
		house = new Backdrop(40, 2, 2, this.level, false, Color.get(-1, 500, 422, 0));
		house.x = 560;
		house.y = 120;
		this.level.addEntity(house);
		
		house = new Backdrop(40, 2, 2, this.level, false, Color.get(-1, 500, 422, 0));
		house.x = 580;
		house.y = 120;
		this.level.addEntity(house);
		
		house = new Backdrop(40, 2, 2, this.level, false, Color.get(-1, 500, 422, 0));
		house.x = 810;
		house.y = 112;
		this.level.addEntity(house);
		
		house = new Backdrop(40, 2, 2, this.level, false, Color.get(-1, 500, 422, 0));
		house.x = 830;
		house.y = 112;
		this.level.addEntity(house);
		
		house = new Backdrop(40, 2, 2, this.level, false, Color.get(-1, 17, 88, 0));
		house.x = 2100;
		house.y = 120;
		this.level.addEntity(house);
		
		Backdrop building = new Backdrop(42, 2, 4, this.level, false, Color.get(-1, 500, 422, 0));
		building.x = 1075;
		building.y = 96;
		this.level.addEntity(building);
		
		Backdrop earth = new Backdrop(68, 3, 3, this.level, false, Color.get(-1, 5, 77, 0));
		earth.x = 8050;
		earth.y = 80;
		this.level.addEntity(earth);
		
		TinyPerson person = new TinyPerson(this.level, Color.get(-1, 500, 422, 0), "Are you really ok?");
		person.x = 80;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 500, 422, 0), "You're too big to jump, but youcan climb using the up arrow.");
		person.x = 260;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 500, 422, 0), "Hey! I'm not tiny, you are big!");
		person.x = 440;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 500, 422, 0), null);
		person.x = 450;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 500, 422, 0), null);
		person.x = 466;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 500, 422, 0), null);
		person.x = 473;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 500, 422, 0), "I wanted to work on Time Traveland Parallel Universes...#but it's not my call.");
		person.x = 500;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 500, 422, 0), null);
		person.x = 510;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 500, 422, 0), null);
		person.x = 515;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 500, 422, 0), "Welcome to our humble village.");
		person.x = 550;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 500, 422, 0), "What do you mean you wanna knowhow you ended up here?#You fell!");
		person.x = 600;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 500, 422, 0), "What is a \"planet\"?");
		person.x = 800;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 500, 422, 0), "What is a \"star\"?");
		person.x = 850;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 500, 422, 0), "I wish I could help you, but weare too busy right now.");
		person.x = 1070;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 500, 422, 0), "I'm calling it \"Project Peace\",but the guys are too busy to#bother.");
		person.x = 1120;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 500, 422, 0), "Some of us might end up living in a hole for all our lives.");
		person.x = 1730;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 17, 88, 0), "What do you mean you miss your wife?#Well, I'm sorry to hear that.");
		person.x = 2080;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 17, 88, 0), "What is a \"son\"?#There is a tiny version of you?I mean, \"normal\" version...");
		person.x = 2140;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 17, 88, 0), "Iron is cold, that's why you   can't climb it.");
		person.x = 2802;
		person.y = 15;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 500, 422, 0), "Don't worry, everything is     going to be alright.#Maybe the guys at the complex  can help you.");
		person.x = 4116;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 500, 422, 0), "The complex is right after thisdesert.");
		person.x = 5116;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 5, 779, 0), "I wish I could help you, but weare too busy right now.");
		person.x = 6200;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 5, 779, 0), null);
		person.x = 6208;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 5, 779, 0), null);
		person.x = 7146;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 5, 779, 0), "Sorry for the long hallways, weare just amused by them.");
		person.x = 7150;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 5, 779, 0), "Did you like the letters?#We change them every month,    when we start working on#something else.");
		person.x = 7238;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 5, 779, 0), null);
		person.x = 7244;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 5, 779, 0), "Look at you, came from so far  away...#I hope you find what you're    looking for!");
		person.x = 7596;
		person.y = 15;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 5, 779, 0), "Do you know how to fix it?");
		person.x = 8020;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 5, 779, 0), "Don't be so mean, this is my   first time doing this.");
		person.x = 8070;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 5, 779, 0), "What do you mean this is where you came from?#Are you telling us you are fromEarth? How is that possible?#You see, our April 2012 work isto fix your home.#So you want to help?#Good.");
		person.x = 8125;
		person.y = 112;
		this.level.addEntity(person);
		
		person = new TinyPerson(this.level, Color.get(-1, 5, 779, 0), null);
		person.x = 8100;
		person.y = 112;
		this.level.addEntity(person);

		person = new TinyPerson(this.level, Color.get(-1, 5, 779, 0), null);
		person.x = 8090;
		person.y = 112;
		this.level.addEntity(person);

		person = new TinyPerson(this.level, Color.get(-1, 5, 779, 0), null);
		person.x = 8040;
		person.y = 112;
		this.level.addEntity(person);
		
		Dialog dialog3 = new Dialog(this, "Now try walking using the left and right arrows.", null);
		Dialog dialog2= new Dialog(this, "Good! With D you can talk and  interact with stuff.", dialog3);
		this.dialog = new Dialog(this, "Are you ok?                    Try pressing D to get up.", dialog2);
	}
	
	public void update() {
		if (this.dialog != null) {
			this.dialog.update();
			if (this.input.action.clicked) {
				if (this.dialog.message.equals("Good.")) {
					this.game.setScene(new TheEndScene(this.game, this.input));
				}
				if (this.dialog.hit()) {
					if (this.player.down) {
						this.player.down = false;
					}
				}
			}
		} else {
			this.level.update();
			
			if (this.input.menu.clicked) {
				this.game.setScene(new PauseScene(this.game, this.input, this));
			}
			
			if (this.player.receivedMessage != null) {
				SoundEffect.talk.play();
				String[] messages = this.player.receivedMessage.split("#");
				Dialog nextDialog = null;
				for (int i = messages.length - 1; i >= 0; i--) {
					this.dialog = new Dialog(this, messages[i], nextDialog);
					nextDialog = this.dialog;
				}
				this.player.receivedMessage = null;
			}
		}
	}

	public void render(Screen screen) {
		screen.clear(17);
		
		int xScroll = this.player.x - (screen.width/2);
		if (xScroll < 0) {
			xScroll = 0;
		} else if (xScroll > ((level.width * 8) - screen.width)) {
			xScroll = (level.width * 8) - screen.width;
		}
		int yScroll = 0;//this.player.y - (screen.height/2);
		screen.setOffset(xScroll, yScroll);
		
		this.level.renderBackground(screen);
		this.level.renderSprites(screen);
		
		if (this.dialog != null) {
			this.dialog.render(screen);
		}

		/*screen.render(144, 120, 0, Color.get(-1, 500, 422, 0), false);
		screen.render(138, 114, 3, Color.get(-1, 0, 0, 555), false);
		screen.render(32, 128, 0, Color.get(-1, 5, 779, 0), false);
		screen.render(192, 128, 0, Color.get(-1, 17, 88, 0), false);*/
		
		//Font.draw(this.game.debugString, screen, xScroll + 1, 1, Color.get(-1, 55, 55, 55));
	}

}
