package com.mygdx.game.ud405._1_4_06_Demo_Viewports;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Functions;
import com.mygdx.game.SplashScreen;
import com.mygdx.game.ud405.ud405;


/**
 * TODO: Start Here!
 *
 * In this demo we'll explore the effect of using a Viewport to manage a camera.
 *
 * We start with a world containing a 16x9 checkerboard, with an apron of neon green.
 */



public class ViewportsDemo implements Screen, InputProcessor {
SplashScreen game;
    public static final String TAG = ViewportsDemo.class.getName();

    private static final float WORLD_WIDTH = 16;
    private static final float WORLD_HEIGHT = 9;

    OrthographicCamera camera;
    Viewport viewport;

    ShapeRenderer renderer;

    /**
     * Uncomment the following viewports one at a time, and check out the effect when you resize the desktop window.
     */
    public ViewportsDemo(SplashScreen game) {
        this.game = game;

        camera = new OrthographicCamera();

        // Makes the size of the world match the size of the screen
        viewport = new ScreenViewport(camera);

        // Make the world fill the screen, regardless of aspect ratio
//        viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

        // Make the world fill the screen, maintaining aspect ratio, but bits of the world may be cut off
//        viewport = new FillViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

        // Fit the world inside the screen, adding black bars to pad out the extra space, maintaining aspect ratio
//        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

        // Make the short axis of the world larger to fill the screen, maintaining aspect ratio
//        viewport = new ExtendViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);


        viewport.setScreenBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        renderer = new ShapeRenderer();
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

    /**
     * When using a viewport, instead of calling camera.update(), we just call viewport.apply()
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        viewport.apply();
        renderer.setProjectionMatrix(camera.combined);
        renderer.begin(ShapeType.Filled);
        renderer.setColor(Color.GREEN);
        renderer.rect(-10, -10, WORLD_WIDTH + 20, WORLD_HEIGHT + 20);
        renderWorld();
        renderer.end();
    }

    /**
     * When the screen is resized, we need to inform the viewport. Note that when using an
     * ExtendViewport, the world size might change as well.
     */
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        Gdx.app.log(TAG, "Viewport world dimensions: (" + viewport.getWorldHeight() + ", " + viewport.getWorldWidth() + ")");
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

    void renderWorld() {
        for (int yStart = 0; yStart < WORLD_HEIGHT; yStart += 1) {
            for (int xStart = 0; xStart < WORLD_WIDTH; xStart += 1) {
                if ((yStart + xStart) % 2 == 0) {
                    renderer.setColor(Color.WHITE);
                } else {
                    renderer.setColor(Color.BLACK);
                }
                renderer.rect(xStart, yStart, 1, 1);
            }
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