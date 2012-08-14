package net.matilhabits.starlite.display;

public class Font {
	private static String chars = "" + //
			"ABCDEFGHIJKLMNOPQRSTUVWXYZ      " + //
			"0123456789.,!?'\"-+=/\\%()<>:;     " + //
			"";
	
	public static void draw(String msg, Display screen, int x, int y, int col) {
		msg = msg.toUpperCase();
		for (int i = 0; i < msg.length(); i++) {
			int ix = chars.indexOf(msg.charAt(i));
			if (ix >= 0) {
				screen.render(x + i * 8, y, ix + 30 * 32, col, false);
			}
		}
	}
	
	public static void renderFrame(Display screen, String title, int x0, int y0, int x1, int y1) {
		// TODO (canceled) Render a frame for text! AKA dialog box.
	}
}
