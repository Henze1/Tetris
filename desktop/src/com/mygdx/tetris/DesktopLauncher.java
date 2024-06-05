package com.mygdx.tetris;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.tetris.Tetris;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle("Tetris");
		config.setWindowSizeLimits( 1152, 648, 1920, 1080 );

		new Lwjgl3Application(new Tetris(), config);
	}
}
