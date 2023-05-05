package com.mygdx.game.ud405._1_3_03_Demo_DrawingLines;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Functions;
import com.mygdx.game.SplashScreen;
import com.mygdx.game.ud405.ud405;

/**
 * TODO: Start Here!
 *
 * In this demo, we'll use ShapeRenderer to draw some lines! We'll use most of the line drawing
 * methods offered by ShapeRenderer, but remember to check out the Javadocs for the full story. If
 * you're lazy, you can just Google "LibGDX ShapeRenderer", and you'll find what you're looking
 * for!
 */

public class DrawingLines implements Screen, InputProcessor {
    SplashScreen game;
    ShapeRenderer shapeRenderer;

    public DrawingLines(SplashScreen game) {
        this.game = game;

        // Remember we want to create our ShapeRenderer outside of our render callback
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        // Also remember to clean up
        shapeRenderer.dispose();
    }

    @Override
    public void render(float delta) {
        // As always, first we clear the screen
        ScreenUtils.clear(0, 0, 0, 1);
        // Then we start our shapeRenderer batch, this time with ShapeType.Line
        shapeRenderer.begin(ShapeType.Line);
        // A Simple white line
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.line(0, 0, 100, 100);
        // We can set different colors using two methods. We can use constants like so.
        shapeRenderer.setColor(Color.MAGENTA);
        shapeRenderer.line(10, 0, 110, 100);
        // We can also set a color using RGBA values
        shapeRenderer.setColor(0, 1, 0, 1);
        shapeRenderer.line(20, 0, 120, 100);
        // We can also do fancy things like gradients
        shapeRenderer.line(30, 0, 130, 100, Color.BLUE, Color.RED);
        // The last interesting thing we can do is draw a bunch of connected line segments using polyline
        // First we set up the list of vertices, where the even positions are x coordinates, and the odd positions are the y coordinates
        float[] vertices = {100, 200, 300, 300, 200, 300, 300, 200};
        shapeRenderer.polyline(vertices);
        // Finally, as always, we end the batch
        shapeRenderer.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

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