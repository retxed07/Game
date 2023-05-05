package com.mygdx.game.ud405._1_4_07_Solution_Viewports;

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
 * In this exercise, you'll use a fit viewport to make sure the entire game world is onscreen and
 * at the right aspect ratio.
 * <p>
 * One new concept is the fact that a viewport will happily create its own camera if you don't
 * provide it with one. To get the camera (to set a ShapeRenderer's projection matrix, for
 * instance), you can just call getCamera() on the viewport.
 * <p>
 * When you're done, change up the WORLD_WIDTH and WORLD_HEIGHT, and see how the world still fits on
 * screen.
 */


public class ViewportsExercise implements Screen, InputProcessor {
    SplashScreen game;
    private static final float WORLD_WIDTH = 100.0f;
    private static final float WORLD_HEIGHT = 100.0f;
    private static final int RECURSIONS = 3;

    ShapeRenderer renderer;
    // TODO: Declare a FitViewport
    FitViewport viewport;

    public ViewportsExercise(SplashScreen game) {
        this.game = game;

        renderer = new ShapeRenderer();
        // TODO: Initialize the viewport with the world width and height
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT);
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

        // TODO: Apply the viewport
        viewport.apply();

        // TODO: Set the projection matrix of the ShapeRenderer to the combined matrix of the viewport's camera
        renderer.setProjectionMatrix(viewport.getCamera().combined);

        renderer.begin(ShapeType.Filled);
        renderer.setColor(Color.WHITE);
        renderer.rect(0, 0, WORLD_WIDTH, WORLD_HEIGHT);
        renderer.setColor(Color.BLACK);
        punchCantorGasket(0, 0, WORLD_WIDTH, WORLD_HEIGHT, RECURSIONS);
        renderer.setColor(Color.WHITE);
        renderer.circle(WORLD_WIDTH / 2, WORLD_HEIGHT / 2, Math.min(WORLD_WIDTH, WORLD_HEIGHT) / 6.5f, 20);
        renderer.end();
    }

    @Override
    public void resize(int width, int height) {
        // TODO: update the viewport and center the camera by passing true as the third argument
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

    private void punchCantorGasket(float x, float y, float width, float height, int recursions) {
        if (recursions == 0) {
            return;
        }

        float newWidth = width / 3;
        float newHeight = height / 3;

        renderer.rect(x + newWidth, y + newHeight, newWidth, newHeight);

        punchCantorGasket(x, y, newWidth, newHeight, recursions - 1);
        punchCantorGasket(x + newWidth, y, newWidth, newHeight, recursions - 1);
        punchCantorGasket(x + 2 * newWidth, y, newWidth, newHeight, recursions - 1);
        punchCantorGasket(x, y + newHeight, newWidth, newHeight, recursions - 1);
        punchCantorGasket(x + 2 * newWidth, y + newHeight, newWidth, newHeight, recursions - 1);
        punchCantorGasket(x, y + 2 * newHeight, newWidth, newHeight, recursions - 1);
        punchCantorGasket(x + newWidth, y + 2 * newHeight, newWidth, newHeight, recursions - 1);
        punchCantorGasket(x + 2 * newWidth, y + 2 * newHeight, newWidth, newHeight, recursions - 1);
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