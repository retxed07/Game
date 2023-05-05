package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		defaultLauncher();
	}

	private static void defaultLauncher() {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);		config.setTitle("SplashScreen");
		config.setWindowedMode(800, 480);
		config.useVsync(true);
		new Lwjgl3Application(new SplashScreen(), config);
	}

//	private static void dropLauncher() {
//		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
//		config.setTitle("Drop");
//		config.setWindowedMode(800, 480);
//		config.useVsync(true);
//		config.setForegroundFPS(60);
//		new Lwjgl3Application(new Drop(), config);
//	}
}
