package net.matilhabits.projectpeace.sound;

import java.applet.Applet;
import java.applet.AudioClip;

public class SoundEffect {
	//public static final SoundEffect type = new SoundEffect("/type.wav");
	//public static final SoundEffect ok = new SoundEffect("/ok.wav");
	//public static final SoundEffect start = new SoundEffect("/start.wav");
	public static final SoundEffect select = new SoundEffect("/select.wav");
	public static final SoundEffect enter = new SoundEffect("/enter.wav");
	public static final SoundEffect talk = new SoundEffect("/talk.wav");
	public static final SoundEffect random1 = new SoundEffect("/random1.wav");
	public static final SoundEffect random2 = new SoundEffect("/random2.wav");
	public static final SoundEffect random3 = new SoundEffect("/random3.wav");
	
	private AudioClip clip;
	
	private SoundEffect(String name) {
		try {
			this.clip = Applet.newAudioClip(SoundEffect.class.getResource(name));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void play() {
		try {
			new Thread() {
				public void run() {
					clip.play();
				}
			}.start();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
