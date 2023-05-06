package com.mygdx.game.ud405._1_5_03_Demo_GamesAndScreens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Input.Keys;
import com.mygdx.game.Functions;
import com.mygdx.game.SplashScreen;
import com.mygdx.game.ud405.ud405;

/**
 * We'll talk about input handling in the next level!
 */

public class ScreenSwitcher extends InputAdapter {
    SplashScreen game;
    Screen screen1;
    Screen screen2;
    int currentScreen;

    public ScreenSwitcher(SplashScreen game, Screen screen1, Screen screen2) {
        this.game = game;
        this.screen1 = screen1;
        this.screen2 = screen2;
        currentScreen = 1;
    }

    @Override
    public boolean keyUp(int keycode) {
        System.out.println("ScreenSwitcher keyup: " + keycode);
        Screen screen;
        if (keycode == Input.Keys.SPACE) {
            if (currentScreen == 1) {
                currentScreen = 2;
                game.setScreen(screen2);
            } else {
                currentScreen = 1;
                game.setScreen(screen1);
            }
        } else if (keycode == Input.Keys.ESCAPE) {
            if (currentScreen == 1) {
                screen = screen2;
            } else {
                screen = screen1;
            }
            Functions.onEscapeOrBack(screen, game, new ud405(game), keycode);
        }
        return true;
    }

    @Override
    public boolean keyDown(int keycode) {
        return true;
    }
}