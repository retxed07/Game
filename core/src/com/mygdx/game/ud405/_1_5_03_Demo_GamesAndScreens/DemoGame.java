package com.mygdx.game.ud405._1_5_03_Demo_GamesAndScreens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.mygdx.game.SplashScreen;

/**
 * TODO: 1. Check out the Game class first
 * <p>
 * Instead of an ApplicationAdapter we're using a Game, which extends ApplicationListener.
 * <p>
 * If we check out Game, we see it's got a screen member variable, and it seems that, for every
 * callback that ApplicationListener implements, it checks to see if it's got a Screen, and if so,
 * it delegates that callback to the Screen.
 */


public class DemoGame implements Screen {
    SplashScreen game;
    public static final String TAG = DemoGame.class.getName();
    DeltaScreen deltaScreen;
    FPSScreen textScreen;

    public DemoGame(SplashScreen game) {
        this.game = game;

        Gdx.app.log(TAG, "create() called");
        deltaScreen = new DeltaScreen(game);
        textScreen = new FPSScreen(game);
    }

    /**
     * So let's see this in action. Here we've declared two screens. One of which displays the
     * number of frames displayed per second, and the other displays the number of seconds between
     * the current frame and the last one.
     * <p>
     * To set the active screen, we just need to call setScreen() on our Game.
     * <p>
     * Let's check out the DeltaScreen.
     */


    @Override
    public void show() {
        // We'll talk about this soon. This lets us hit spacebar to swap screens
        Gdx.input.setInputProcessor(new ScreenSwitcher(game, deltaScreen, textScreen));
        game.setScreen(deltaScreen);
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        Gdx.app.log(TAG, "dispose() called");
    }
}