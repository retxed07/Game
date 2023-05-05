package com.mygdx.game.ud405._1_3_09_Solution_DrawTheDragonCurve;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mygdx.game.Functions;
import com.mygdx.game.SplashScreen;
import com.mygdx.game.ud405.ud405;

/*

TODO: Start here

The Dragon Curve is a fractal made by a single line. It is formed of a series of turns, which can be constructed in the following way:

0: L
1: L + L + R
2: LLR + L + LRR
3: LLRLLRR + L + LLRRLRR

The nth dragon curve is the n-1th dragon curve plus L, plus the n-1th dragon curve reversed and reflected.

In this project we have split up the tasks of generating and drawing the dragon curve into separate classes.

 */

public class DragonCurve implements Screen, InputProcessor {
    SplashScreen game;
    private float[] dragonCurve;
    // Any more than 10 and we'll need to break up the polyline into multiple lines
    private static final int RECURSIONS = 10;

    private ShapeRenderer shapeRenderer;

    public DragonCurve(SplashScreen game) {
        this.game = game;
        dragonCurve = DragonCurveGenerator.generateDragonCurve(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), RECURSIONS);
        shapeRenderer = new ShapeRenderer();
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
        shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.polyline(dragonCurve);
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
