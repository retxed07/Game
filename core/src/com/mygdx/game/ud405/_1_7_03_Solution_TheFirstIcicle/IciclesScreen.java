package com.mygdx.game.ud405._1_7_03_Solution_TheFirstIcicle;

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

    // TODO: Add an ExtendViewport
    ExtendViewport iciclesViewport;

    // TODO: Add a ShapeRenderer
    ShapeRenderer renderer;

    // TODO: Add an Icicle
    Icicle icicle;

    public IciclesScreen(SplashScreen game) {
        this.game = game;
    }

    @Override
    public void show() {
        // TODO: Initialize the viewport using the world size constant
        iciclesViewport = new ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);

        // TODO: Initialize the ShapeRenderer
        renderer = new ShapeRenderer();

        // TODO: Set autoShapeType(true) on the ShapeRenderer
        renderer.setAutoShapeType(true);

        // TODO: Create a new Icicle in the middle of the world
        icicle = new Icicle(new Vector2(Constants.WORLD_SIZE / 2, Constants.WORLD_SIZE / 2));

        Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
    }

    @Override
    public void resize(int width, int height) {
        // TODO: Ensure that the viewport updates correctly
        iciclesViewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }


    @Override
    public void render(float delta) {

        // TODO: Apply the viewport
        iciclesViewport.apply(true);

        // TODO: Clear the screen to the background color
        Gdx.gl.glClearColor(Constants.BACKGROUND_COLOR.r, Constants.BACKGROUND_COLOR.g, Constants.BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // TODO: Set the ShapeRenderer's projection matrix
        renderer.setProjectionMatrix(iciclesViewport.getCamera().combined);

        // TODO: Draw the Icicle

        renderer.begin(ShapeType.Filled);
        icicle.render(renderer);
        renderer.end();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    // TODO: Dispose of the ShapeRenderer
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