package com.mygdx.game.ud405._1_5_01_Demo_CircularMotion;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.Functions;
import com.mygdx.game.SplashScreen;
import com.mygdx.game.ud405.ud405;

/**
 * TODO: Start here
 *
 * In this demo, we'll explore how to create basic motion. Really all we need to know how to do is
 * find out how much time has passed since we started rendering the scene. And then figure out what
 * our scene should look like after that much time has passed.
 *
 * To accomplish the first task, LibGDX provides a great TimeUtils class, which has two methods of
 * interest. TimeUtils.millis() returns the number of milliseconds (thousandths of a second) that
 * have passed since January 1, 1970 UTC. This is great if you want to know the wall-clock time, but
 * individual milliseconds start to matter when games are rendered at 60 frames per second.
 *
 * If we want more precision when comparing times (which we generally do), we can use
 * TimeUtils.nanoTime(), which will give the number of nanoseconds (billionths of a second), since
 * (or until) some arbitrary reference time. Again, you can't tell the wall-clock time using
 * nanoTime. You can only tell time intervals, which is usually all we want.
 */


public class CircularMotion implements Screen, InputProcessor {
SplashScreen game;
    public static final String TAG = CircularMotion.class.getName();
    private static final float WORLD_SIZE = 480.0f;
    private static final float CIRCLE_RADIUS = WORLD_SIZE / 20;
    private static final float MOVEMENT_RADIUS = WORLD_SIZE / 4;

    // How many seconds until the circular motion repeats
    private static final float PERIOD = 1.0f;

    private ShapeRenderer renderer;
    private FitViewport viewport;

    // We set up a variable to hold the nanoTime at which the application was created.
    private long initialTime;

    public CircularMotion(SplashScreen game) {
        this.game = game;

        renderer = new ShapeRenderer();
        viewport = new FitViewport(WORLD_SIZE, WORLD_SIZE);

        // Set the initialTime
        initialTime = TimeUtils.nanoTime();
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
        viewport.apply();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(viewport.getCamera().combined);
        renderer.begin(ShapeType.Filled);

        float elapsedNanoseconds = TimeUtils.nanoTime() - initialTime;
        float elapsedSeconds = MathUtils.nanoToSec * elapsedNanoseconds;
        float elapsedPeriods = elapsedSeconds / PERIOD;
        float cyclePosition = elapsedPeriods % 1;

        float x = WORLD_SIZE / 2 + MOVEMENT_RADIUS * MathUtils.cos(MathUtils.PI2 * cyclePosition);
        float y = WORLD_SIZE / 2 + MOVEMENT_RADIUS * MathUtils.sin(MathUtils.PI2 * cyclePosition);

        renderer.circle(x, y, CIRCLE_RADIUS);

        // Uncomment the next line to see the sort of beautiful things you can create with simple movement
//         drawFancyCircles(renderer, elapsedPeriods, 20);
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

    private void drawFancyCircles(ShapeRenderer renderer, float elapsedPeriods, int circleCount) {
        for (int i = 1; i <= circleCount; i++) {
            float centerX = WORLD_SIZE / 2 + WORLD_SIZE / 4 * MathUtils.cos(MathUtils.PI2 * i / circleCount);
            float centerY = WORLD_SIZE / 2 + WORLD_SIZE / 4 * MathUtils.sin(MathUtils.PI2 * i / circleCount);

            float x = centerX + WORLD_SIZE / 5 * MathUtils.cos(MathUtils.PI2 * (elapsedPeriods * i / circleCount));
            float y = centerY + WORLD_SIZE / 5 * MathUtils.sin(MathUtils.PI2 * (elapsedPeriods * i / circleCount));

            renderer.circle(x, y, 10);
        }
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