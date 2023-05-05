package com.mygdx.game.ud405._1_4_11_Solution_CyclicOverlap;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.Functions;
import com.mygdx.game.SplashScreen;
import com.mygdx.game.ud405.ud405;

/**
 * TODO: Start here
 * <p>
 * In this project we have three overlapping rectangles. They'd look nice and symmetrical if the
 * left end of the red one was on top of the blue one, but, constrained by the painter's algorithm
 * as we are, that would seem to be impossible. Can you figure out a way to make it happen?
 */


public class CyclicOverlap implements Screen, InputProcessor {
    SplashScreen game;
    static final float WORLD_SIZE = 10;

    ShapeRenderer renderer;
    FitViewport viewport;

    public CyclicOverlap(SplashScreen game) {
        this.game = game;

        renderer = new ShapeRenderer();
        viewport = new FitViewport(WORLD_SIZE, WORLD_SIZE);
    }

    @Override
    public void dispose() {
        renderer.dispose();
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

        viewport.apply();
        renderer.setProjectionMatrix(viewport.getCamera().combined);

        renderer.begin(ShapeType.Filled);
        renderer.setColor(Color.RED);
        renderer.rect(2, 3.5f, 3, 1.5f, 6, 1, 1, 1, 0);
        renderer.setColor(Color.GREEN);
        renderer.rect(2, 3.5f, 3, 1.5f, 6, 1, 1, 1, 120);
        renderer.setColor(Color.BLUE);
        renderer.rect(2, 3.5f, 3, 1.5f, 6, 1, 1, 1, 240);

        // TODO: Make it look like the left end of RED is on top of BLUE
        renderer.setColor(Color.RED);
        renderer.rect(2, 3.5f, 3, 1.5f, 3, 1, 1, 1, 0);
        renderer.end();
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