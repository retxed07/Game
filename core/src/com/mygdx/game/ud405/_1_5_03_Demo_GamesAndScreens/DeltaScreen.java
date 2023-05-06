package com.mygdx.game.ud405._1_5_03_Demo_GamesAndScreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.Functions;
import com.mygdx.game.SplashScreen;
import com.mygdx.game.ud405.ud405;


/**
 * TODO: 2 Check out this screen class second
 * <p>
 * Screens are very similar to ApplicationListeners, with a couple differences. Instead of create(),
 * screens get a show() call, and anything you would do in dispose() should usually be done in
 * hide(). Finally, the render() call received by a screen includes an argument called delta.
 * <p>
 * The argument delta is the number of seconds after the previous frame that this frame is expected
 * to hit the screen. In a normal game, running at 60 frames per second, this will almost always be
 * 0.0167 seconds, or 16.7 milli-seconds. However, if your game is running on old hardware, or is
 * just drawing way too much stuff, you may end up with a delta that is larger.
 * <p>
 * In this screen, we're creating a BitmapFont and a SpriteBatch, and displaying the delta passed
 * into the render function. Also, we've included logging on all the Screen callbacks.
 * <p>
 * Let's check out FPSScreen.
 */

public class DeltaScreen implements Screen {
    SplashScreen game;
    public static final String TAG = DeltaScreen.class.getName();
    private static final Float FONT_SCALE = 3.0f;
    BitmapFont font;
    SpriteBatch batch;

    public DeltaScreen(SplashScreen game) {
        this.game = game;

        batch = new SpriteBatch();
        font = new BitmapFont();
        font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
        font.getData().setScale(FONT_SCALE);
    }

    @Override
    public void show() {
        Gdx.app.log(TAG, "show() called");
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
    }

    @Override
    public void dispose() {
        Gdx.app.log(TAG, "dispose() called");
        batch.dispose();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log(TAG, "resize(" + width + ", " + height + ") called");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        font.draw(batch, "Delta = " + delta, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 2, 0, Align.left, false);
        batch.end();
    }

    @Override
    public void pause() {
        Gdx.app.log(TAG, "pause() called");
    }

    @Override
    public void resume() {
        Gdx.app.log(TAG, "resume() called");
    }

    @Override
    public void hide() {
        Gdx.app.log(TAG, "hide() called");
    }
}