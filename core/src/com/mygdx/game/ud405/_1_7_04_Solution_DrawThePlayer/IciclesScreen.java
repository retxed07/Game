package com.mygdx.game.ud405._1_7_04_Solution_DrawThePlayer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.Functions;
import com.mygdx.game.SplashScreen;
import com.mygdx.game.ud405.ud405;

public class IciclesScreen implements Screen, InputProcessor {
    SplashScreen game;
    public static final String TAG = IciclesScreen.class.getName();

    ExtendViewport iciclesViewport;
    ShapeRenderer renderer;

    // TODO: Add a Player (complete Player.java first)
    Player player;

    Icicle icicle;

    public IciclesScreen(SplashScreen game) {
        this.game = game;
    }

    @Override
    public void show() {
        iciclesViewport = new ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);

        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);

        // TODO: Initialize the player
        player = new Player(iciclesViewport);

        icicle = new Icicle(new Vector2(Constants.WORLD_SIZE / 2, Constants.WORLD_SIZE / 2));

        Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
    }

    @Override
    public void resize(int width, int height) {
        iciclesViewport.update(width, height, true);
        // TODO: Reset the player (using init())
        player.init();
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }


    @Override
    public void render(float delta) {

        iciclesViewport.apply(true);
        Gdx.gl.glClearColor(Constants.BACKGROUND_COLOR.r, Constants.BACKGROUND_COLOR.g, Constants.BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(iciclesViewport.getCamera().combined);
        renderer.begin(ShapeType.Filled);
        renderer.setColor(Constants.ICICLE_COLOR);
        icicle.render(renderer);
        // TODO: Call render() on the player
        player.render(renderer);
        renderer.end();
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