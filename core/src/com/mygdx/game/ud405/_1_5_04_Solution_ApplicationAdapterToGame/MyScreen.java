package com.mygdx.game.ud405._1_5_04_Solution_ApplicationAdapterToGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Functions;
import com.mygdx.game.SplashScreen;
import com.mygdx.game.ud405.ud405;

/**
 * TODO: Start Here!
 * <p>
 * TODO: First run what we've got so far.
 * <p>
 * TODO: Declare that MyScreen implements Screen (com.badlogic.gdx.Screen), and hit Ctrl-i to insert all required methods.
 * <p>
 * TODO: Move all member variables from MyGame to MyScreen
 * <p>
 * TODO: Move everything from MyGame.create() to MyScreen.show()
 * <p>
 * TODO: Move everything from MyGame.dispose() to MyScreen.hide()
 * <p>
 * TODO: Move everything from MyGame.resize() to MyScreen.resize()
 * <p>
 * TODO: Move everything from MyGame.render() to MyScreen.render()
 * <p>
 * MyScreen is now ready. Next we'll set up MyGame to make use of MyScreen
 */

public class MyScreen implements Screen, InputProcessor {
    SplashScreen game;
    SpriteBatch batch;
    BitmapFont font;
    ScreenViewport viewport;

    public MyScreen(SplashScreen game) {
        this.game = game;

        batch = new SpriteBatch();
        font = new BitmapFont();
        font.getData().setScale(2);
        font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
        viewport = new ScreenViewport();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
    }

    @Override
    public void render(float delta) {
        viewport.apply();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();

        font.draw(batch, "Hello from " + this.getClass().getSimpleName(),
                viewport.getWorldWidth() / 2,
                viewport.getWorldHeight() / 2,
                0,
                Align.center,
                false);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
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