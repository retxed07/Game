package com.mygdx.game.ud405._1_5_02_Solution_ReciprocatingMotion;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.Functions;
import com.mygdx.game.SplashScreen;
import com.mygdx.game.ud405.ud405;

/**
 * TODO: Start Here
 * <p>
 * In this exercise we'll make a circle move back and forth smoothly. We'll pick a period and and
 * amplitude, the set the circle x position to the center of the screen plus the amplitude times the
 * sin of 2Pi the elapsed time divided by the period.
 */


public class ReciprocatingMotion implements Screen, InputProcessor {
    SplashScreen game;
    private static final float WORLD_SIZE = 480;
    private static final float CIRCLE_RADIUS = WORLD_SIZE / 20;
    private static final float MOVEMENT_DISTANCE = WORLD_SIZE / 4;

    // TODO: Define a constant that fixes how long a cycle of the animation should take in seconds
    private static final float PERIOD = 2;

    ShapeRenderer renderer;
    ExtendViewport viewport;

    // TODO: Create a long to hold onto ApplicationAdapter creation time
    long startTime;

    public ReciprocatingMotion(SplashScreen game) {
        this.game = game;

        renderer = new ShapeRenderer();
        viewport = new ExtendViewport(WORLD_SIZE, WORLD_SIZE);

        // TODO: Save current value of TimeUtils.nanoTime()
        startTime = TimeUtils.nanoTime();
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

        renderer.setProjectionMatrix(viewport.getCamera().combined);
        renderer.begin(ShapeType.Filled);

        // Since we're using an extend viewport, the world might be bigger than we expect
        float worldCenterX = viewport.getWorldWidth() / 2;
        float worldCenterY = viewport.getWorldHeight() / 2;

        // TODO: Figure out how long it's been since the animation started using TimeUtils.nanoTime()
        long elapsedNanos = TimeUtils.nanoTime() - startTime;

        // TODO: Use MathUtils.nanoToSec to figure out how many seconds the animation has been running
        float elapsedSeconds = MathUtils.nanoToSec * elapsedNanos;

        // TODO: Figure out how many cycles have elapsed since the animation started running
        float cycles = elapsedSeconds / PERIOD;

        // TODO: Figure out where in the cycle we are
        float cyclePosition = cycles % 1;

        // TODO: Use MathUtils.sin() to set the x position of the circle
        float x = worldCenterX + MOVEMENT_DISTANCE * MathUtils.sin(MathUtils.PI2 * cyclePosition);

        float y = worldCenterY;
        renderer.circle(x, y, CIRCLE_RADIUS);
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
    public void dispose() {
        renderer.dispose();
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