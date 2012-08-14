package net.matilhabits.starlite.audio;

import java.applet.Applet;
import java.applet.AudioClip;

public class Audio {
	// Defined by the user application:
	public static final Audio select = new Audio("/select.wav");
	public static final Audio enter = new Audio("/enter.wav");
	public static final Audio talk = new Audio("/talk.wav");
	public static final Audio random1 = new Audio("/random1.wav");
	public static final Audio random2 = new Audio("/random2.wav");
	public static final Audio random3 = new Audio("/random3.wav");
	
	// The rest is part of the API:
	
	private AudioClip clip;
	
	private Audio(String name) {
		try {
			this.clip = Applet.newAudioClip(Audio.class.getResource(name));
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
