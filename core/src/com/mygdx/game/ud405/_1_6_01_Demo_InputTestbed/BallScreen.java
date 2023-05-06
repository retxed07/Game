package com.mygdx.game.ud405._1_6_01_Demo_InputTestbed;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.Functions;
import com.mygdx.game.SplashScreen;
import com.mygdx.game.ud405.ud405;

/**
 * TODO: Start here
 *
 * This demo uses a ScreenAdapter to separate the particular bouncing ball content from the
 * ApplicationListener. A ScreenAdapter is a convenience implementation of Screen which provides
 * blank implementations of all the required methods. That way we only need to override what we
 * need.
 *
 * The BallScreen is responsible for setting up the drawing environment for the BouncingBall object,
 * which contains all the logic related to how the ball moves.
 *
 * One new concept is AutoShapeType on ShapeRenderer. When we're delegating drawing to other
 * objects, it's nice to allow those objects to set the ShapeType. With AutoShapeType enabled,
 * ShapeRenderer will automatically end its current batch and start a new one when asked to switch
 * shape types.
 *
 * After reviewing this file, check out the BouncingBall class
 */


public class BallScreen extends ScreenAdapter implements InputProcessor {
SplashScreen game;

    public static final float WORLD_SIZE = 480.0f;

    ShapeRenderer renderer;
    ExtendViewport viewport;
    BouncingBall ball;

    public BallScreen(SplashScreen game) {
        this.game = game;
    }

    @Override
    public void show() {
        renderer = new ShapeRenderer();
        // We use AutoShapeType so we can allow other objects to use our renderer safely
        renderer.setAutoShapeType(true);
        // We use an extend viewport to make the shortest axis of the world equal to WORLD_SIZE
        viewport = new ExtendViewport(WORLD_SIZE, WORLD_SIZE);
        ball = new BouncingBall(viewport);

        Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        // Every time the world changes size, we just reset the ball
        ball.init(viewport);
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }

    @Override
    public void render(float delta) {
        viewport.apply();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(viewport.getCamera().combined);
        ball.update(delta, viewport);

        renderer.begin(ShapeType.Filled);
        ball.render(renderer);
        renderer.end();
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