package com.mygdx.game.ud405._1_4_01_Demo_CirclesAndArcs;

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
 * TODO: Start here!
 *
 * Everything in this class should seem pretty familiar. We're just creating a ShapeRenderer, and
 * asking it to draw us some shapes. The interesting new things are, one, drawing circles and arcs
 * (partial circles), and two, using multiple ShapeRenderer batches!
 *
 * Circles can be drawn using either ShapeType.Filled, or ShapeType.Line. The former draws a solid
 * circle, the latter draws just the outline of the circle.
 *
 * If we want to draw both filled and outlined circles in the same frame, we need to use two
 * different batches. We just start one batch with ShapeType.Filled, draw our shapes, and end the
 * batch. Then we start another batch, this time with ShapeType.Line, draw again, and again,
 * remember to end the batch.
 *
 * Circles have a dirty little secret though. They're not really circles. They're a fan of
 * triangles, where all the triangles have their points at the center of the circle. ShapeRenderer
 * will pick how many triangles to use so the circle looks smooth, but if you make super small
 * circles, it might choose to use too few. You can use the optional last parameter to bump up the
 * number of segments.
 */

public class CirclesAndArcs implements Screen, InputProcessor {
SplashScreen game;
    ShapeRenderer renderer;

    public CirclesAndArcs(SplashScreen game) {
        this.game = game;
        renderer = new ShapeRenderer();
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

        renderer.begin(ShapeType.Filled);
        renderer.setColor(Color.WHITE);

        // The most basic circle you can draw, with the segment count set for you
        renderer.circle(100, 100, 90);
        renderer.setColor(Color.YELLOW);

        // We can also draw partial circle, or arc
        renderer.arc(300, 100, 90, 45, 270);

        // What happens when we set the segments count too low
        renderer.circle(500, 100, 90, 10);
        renderer.end();

        // Circles can be drawn in either Filled or Line mode!
        renderer.begin(ShapeType.Line);
        renderer.circle(100, 300, 90);

        // Let's draw target rings
        for (int radius = 80; radius > 0; radius -= 10) {
            renderer.circle(100, 300, radius);
        }

        // We can also draw the outline of an arc
        renderer.arc(300, 300, 90, 0, 90);

        // Let's draw some a funky snail shell
        final int arcs = 20;
        for (int i = 1; i < arcs; i++) {
            renderer.arc(300, 300, (1 - 1.0f * i / arcs) * 90, 360.0f * i / arcs, 90);
        }
        renderer.end();
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
    public void hide() {

    }

    @Override
    public void dispose() {

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