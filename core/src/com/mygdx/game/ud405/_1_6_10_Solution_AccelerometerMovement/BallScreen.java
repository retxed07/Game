package com.mygdx.game.ud405._1_6_10_Solution_AccelerometerMovement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.SplashScreen;


public class BallScreen extends ScreenAdapter {
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
        renderer.setAutoShapeType(true);
        viewport = new ExtendViewport(WORLD_SIZE, WORLD_SIZE);
        ball = new BouncingBall(game, this, viewport);
        Gdx.input.setInputProcessor(ball);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        ball.init();
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
        ball.update(delta);

        renderer.begin(ShapeType.Filled);
        ball.render(renderer);
        renderer.end();
    }
}