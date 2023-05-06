package com.mygdx.game.ud405._1_5_05_Solution_FPSCounter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Functions;
import com.mygdx.game.SplashScreen;
import com.mygdx.game.ud405.ud405;

public class FPSCounterScreen extends ScreenAdapter implements InputProcessor {
    SplashScreen game;
    // TODO: Declare a SpriteBatch, a BitmapFont, and a ScreenViewport
    SpriteBatch batch;
    BitmapFont font;
    ScreenViewport viewport;

    public FPSCounterScreen(SplashScreen game) {
        this.game = game;
    }

    @Override
    public void show() {

        // TODO: Initialize the SpriteBatch
        batch = new SpriteBatch();

        // TODO: Initialize the BitmapFont
        font = new BitmapFont();
        font.getData().setScale(2);
        font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);

        // TODO: Initialize the ScreenViewport
        viewport = new ScreenViewport();

        Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
    }

    @Override
    public void resize(int width, int height) {
        // TODO: Update the viewport. Be sure to center the camera
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        // TODO: Dispose of the SpriteBatch and the BitmapFont
        batch.dispose();
        font.dispose();
    }

    @Override
    public void render(float delta) {
        // TODO: Apply the viewport
        viewport.apply();

        // TODO: Set the clear color
        Gdx.gl.glClearColor(0, 0, 0, 1);

        // TODO: Clear the color buffer
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // TODO: Set the SpriteBatch's projection matrix
        batch.setProjectionMatrix(viewport.getCamera().combined);

        // TODO: Begin a new batch
        batch.begin();

        // TODO: Use delta to figure out the number of frames per second
        float fps = 1 / delta;

        // TODO: Use the BitmapFont to draw the FPS
        font.draw(batch, "FPS = " + fps,
                viewport.getWorldWidth() / 4,
                viewport.getWorldHeight() / 2);

        // TODO: End the batch
        batch.end();
    }

    @Override
    public boolean keyDown(int keycode) {
        return Functions.onEscapeOrBack(this, game, new ud405(game), keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}