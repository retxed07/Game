package com.mygdx.game.ud405._1_6_09_Solution_BubbleLevel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Functions;
import com.mygdx.game.SplashScreen;
import com.mygdx.game.ud405.ud405;

import java.util.Locale;


public class BubbleLevelScreen extends ScreenAdapter implements InputProcessor {
SplashScreen game;
    public static final String TAG = BubbleLevelScreen.class.getName();

    private static final float WORLD_SIZE = 100.0f;
    private static final float TEXT_SCALE = 5.0f;
    private static final Color AXIS_COLOR = Color.RED;
    private static final float AXIS_WIDTH = 1.0f;

    ShapeRenderer renderer;
    FitViewport axisViewport;

    SpriteBatch batch;
    ScreenViewport textViewport;
    BitmapFont font;

    float maxAcceleration;
    float minAcceleration;

    public BubbleLevelScreen(SplashScreen game) {
        this.game = game;
    }

    @Override
    public void show() {
        axisViewport = new FitViewport(WORLD_SIZE, WORLD_SIZE);
        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);
        batch = new SpriteBatch();
        textViewport = new ScreenViewport();
        font = new BitmapFont();
        font.getData().setScale(TEXT_SCALE);
        font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
        maxAcceleration = 0;
        minAcceleration = Float.MAX_VALUE;

        Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
    }

    @Override
    public void resize(int width, int height) {
        axisViewport.update(width, height, true);
        textViewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        renderer.dispose();
        batch.dispose();
    }

    @Override
    public void render(float delta) {
        textViewport.apply();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // TODO: Get accelerometer readings
        float xAxis = Gdx.input.getAccelerometerX();
        float yAxis = Gdx.input.getAccelerometerY();
        float zAxis = Gdx.input.getAccelerometerZ();


        float totalAcceleration = (float) Math.sqrt(xAxis * xAxis + yAxis * yAxis + zAxis * zAxis);
        totalAcceleration += 0.00001f;

        maxAcceleration = Math.max(maxAcceleration, totalAcceleration);
        minAcceleration = Math.min(minAcceleration, totalAcceleration);


        batch.setProjectionMatrix(textViewport.getCamera().combined);

        batch.begin();


        String message = String.format(Locale.ENGLISH,"Accelerometer reads:\nx = %.2f\ny = %.2f\nz = %.2f\ntotal = %.2f\nmax = %.2f\nmin = %.2f", xAxis, yAxis, zAxis, totalAcceleration, maxAcceleration, minAcceleration);

        font.draw(batch, message, 40, textViewport.getWorldHeight() - 40);
        batch.end();

        axisViewport.apply();
        renderer.setProjectionMatrix(axisViewport.getCamera().combined);


        renderer.begin(ShapeType.Line);

        renderer.setColor(Color.RED);

        // TODO: Draw a circle to indicate 9.8m/s^2
        renderer.circle(WORLD_SIZE / 2,
                WORLD_SIZE / 2,
                WORLD_SIZE / 4 + WORLD_SIZE / 50, 64);

        renderer.setColor(Color.GREEN);

        // TODO: Draw a circle to hold the bubble when the phone is flat
        renderer.circle(WORLD_SIZE / 2,
                WORLD_SIZE / 2,
                WORLD_SIZE / 40,
                64);

        renderer.set(ShapeType.Filled);

        // TODO: Draw the bubble
        renderer.circle(
                WORLD_SIZE * (.5f - .25f * yAxis / totalAcceleration),
                WORLD_SIZE * (.5f + .25f * xAxis / totalAcceleration),
                WORLD_SIZE / 50,
                64
        );

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