package com.mygdx.game.ud405._1_4_09_Demo_Text;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Functions;
import com.mygdx.game.SplashScreen;
import com.mygdx.game.ud405.ud405;

/**
 * TODO: Start here
 * <p>
 * Let's do the minimal text example! Note that we use a SpriteBatch to draw, instead of a
 * ShapeRenderer.
 * <p>
 * One more concept we haven't yet covered is filtering. That's how we determine what to do when we
 * draw a bitmap at a larger size than it was intended. Our options are Linear, and Nearest. Nearest
 * is what you want for pixel art, where you want things to maintain their sharp individual pixels.
 * For everything else, you want the Linear filter, as that will smooth between adjacent pixels.
 */

public class TextDemo implements Screen, InputProcessor {
    SplashScreen game;
    SpriteBatch batch;
    BitmapFont font;

    public TextDemo(SplashScreen game) {
        this.game = game;

        batch = new SpriteBatch();
        // Create the default font
        font = new BitmapFont();
        // Scale it up
        font.getData().setScale(3);
        // Set the filter
        font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // We begin batches just like with a ShapeRenderer, though there's no mode
        batch.begin();
        font.draw(batch, "Text", 100, 100);
        // Remember to end the batch
        batch.end();
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

    /**
     * Remember to dispose of SpriteBatches and fonts!
     */
    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
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