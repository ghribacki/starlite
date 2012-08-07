package net.matilhabits.projectpeace;

import net.matilhabits.starlite.Cartridge;
import net.matilhabits.starlite.Starlite;

public class Main {
	public static void main(String args[]) {
		Starlite device = new Starlite();
		Cartridge projectPeace = new ProjectPeace();
		device.insertCartridge(projectPeace);
	}
}
