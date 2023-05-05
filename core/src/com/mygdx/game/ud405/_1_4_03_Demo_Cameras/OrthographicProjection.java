package com.mygdx.game.ud405._1_4_03_Demo_Cameras;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mygdx.game.Functions;
import com.mygdx.game.SplashScreen;
import com.mygdx.game.ud405.ud405;

/**
 * TODO: Start here
 */


public class OrthographicProjection implements Screen {
    SplashScreen game;
    ShapeRenderer renderer;
    DemoCamera demoCamera;

    public OrthographicProjection(SplashScreen game) {
        this.game = game;

        renderer = new ShapeRenderer();
        demoCamera = new DemoCamera(game, this);
        // Tell LibGDX that demoCamera knows what to do with keypresses
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(demoCamera);
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        demoCamera.update();
        demoCamera.setCamera(renderer);
        renderTestScene(renderer);
        demoCamera.render(renderer);
    }

    @Override
    public void resize(int width, int height) {
        demoCamera.resize(width, height);
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

    /**
     * This method renders a few shapes for us to try our camera on. Note that we're using a Bezier
     * curve, which is a way to draw smooth curves. For more information on Bezier curves, check
     * out: https://en.wikipedia.org/wiki/B%C3%A9zier_curve
     * <p>
     * Also note that a line is a line is a line. No matter how much we zoom in, a line is always
     * just one pixel wide.
     */
    private void renderTestScene(ShapeRenderer renderer) {
        renderer.begin(ShapeType.Filled);
        renderer.setColor(Color.GREEN);
        renderer.circle(100, 100, 90);
        renderer.setColor(Color.RED);
        renderer.rect(200, 10, 200, 200);
        renderer.setColor(Color.YELLOW);
        renderer.triangle(10, 200, 200, 200, 100, 400);
        renderer.end();
        renderer.begin(ShapeType.Line);

        renderer.setColor(Color.CYAN);

        // Here's another shape ShapeRenderer
        renderer.curve(
                210, 210,
                400, 210,
                210, 400,
                400, 300,
                20);
        renderer.end();
    }
}