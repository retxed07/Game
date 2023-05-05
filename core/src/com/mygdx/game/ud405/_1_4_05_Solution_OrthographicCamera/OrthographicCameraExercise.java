package com.mygdx.game.ud405._1_4_05_Solution_OrthographicCamera;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.Functions;
import com.mygdx.game.SplashScreen;
import com.mygdx.game.ud405.ud405;


/**
 * TODO: Start here
 * <p>
 * In this exercise, you'll create an OrthographicCamera, and use it to zoom in on a moving circle
 */

public class OrthographicCameraExercise implements Screen, InputProcessor {
    SplashScreen game;
    private static final float BALL_RADIUS = 20;
    private static final float PERIOD = 2000;
    private static final float X_AMPLITUDE = 40;
    private static final float Y_AMPLITUDE = 20;
    private static final float X_CENTER = 100;
    private static final float Y_CENTER = 100;


    ShapeRenderer renderer;
    long timeCreated;

    //TODO: Declare an OrthographicCamera
    OrthographicCamera camera;

    public OrthographicCameraExercise(SplashScreen game) {
        this.game = game;

        renderer = new ShapeRenderer();
        timeCreated = TimeUtils.millis();

        // TODO: Initialize the camera
        camera = new OrthographicCamera();

        // TODO: Set the camera's position to the center of the circle's movement (X_CENTER, Y_CENTER)
        camera.position.set(X_CENTER, Y_CENTER, 0);
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

        // TODO: Call update() on the camera
        camera.update();

        // TODO: Set the SceneRenderer's projection matrix equal to the camera's combined matrix
        renderer.setProjectionMatrix(camera.combined);

        renderer.begin(ShapeType.Filled);
        float interval = TimeUtils.timeSinceMillis(timeCreated);
        float x = X_CENTER + X_AMPLITUDE * MathUtils.sin(MathUtils.PI2 * interval / PERIOD);
        float y = Y_CENTER + Y_AMPLITUDE * MathUtils.sin(2 * MathUtils.PI2 * interval / PERIOD);
        renderer.circle(x, y, BALL_RADIUS);
        renderer.end();
    }

    @Override
    public void resize(int width, int height) {

        // TODO: Calculate the aspect ratio (width / height)
        float aspectRatio = 1.0f * width / height;

        // TODO: Set the camera's viewport height taking into account the ball's movement and radius
        camera.viewportHeight = 2 * (Y_AMPLITUDE + BALL_RADIUS);

        // TODO: Set the camera's viewport width to maintain the aspect ratio
        camera.viewportWidth = aspectRatio * camera.viewportHeight;
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