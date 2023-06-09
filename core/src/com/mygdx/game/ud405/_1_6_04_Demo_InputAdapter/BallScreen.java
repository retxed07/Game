package com.mygdx.game.ud405._1_6_04_Demo_InputAdapter;

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

    /**
     * TODO: Register our InputProcessor with LibGDX
     * <p>
     * This is super simple, we just call Gdx.input.setInputProcessor() with our new subclass of
     * InputAdapter.
     * <p>
     * Now if we run the game, everything still works as before: we can scale the ball, we can move
     * the ball around, but we can also hit space to give the ball a kick!
     */
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
}