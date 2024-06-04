package com.mygdx.tetris;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.tetris.Tetris;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Tetris");
		new Lwjgl3Application(new Tetris(), config);

//		Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
//		new Lwjgl3Application(new Tetris(), configuration);
	}
}
