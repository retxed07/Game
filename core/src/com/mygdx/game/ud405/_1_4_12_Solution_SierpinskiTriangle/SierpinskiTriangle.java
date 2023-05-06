package com.mygdx.game.ud405._1_4_12_Solution_SierpinskiTriangle;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.Functions;
import com.mygdx.game.SplashScreen;
import com.mygdx.game.ud405.ud405;

/**
 * TODO: Start here
 *
 * Your challenge, should you choose to accept it, is to draw a Serpinski Triangle. I offer no hints
 * beyond the fact that ShapeRenderer has a very convenient triangle() function, and that using a
 * FitViewport can simplify matters considerably. Good luck!
 */


public class SierpinskiTriangle implements Screen, InputProcessor {
SplashScreen game;
    static final float SIZE = 10;
    private static final int RECURSIONS = 7;
    ShapeRenderer renderer;
    FitViewport viewport;

    public SierpinskiTriangle(SplashScreen game) {
        this.game = game;

        renderer = new ShapeRenderer();
        viewport = new FitViewport(SIZE, SIZE);
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
        viewport.apply();
        renderer.setProjectionMatrix(viewport.getCamera().combined);
        renderer.begin(ShapeType.Filled);
        inscribeSierpinskiTriangle(renderer, SIZE, RECURSIONS);
        renderer.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
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

    private void inscribeSierpinskiTriangle(ShapeRenderer shapeRenderer, float size, int recursions) {
        Vector2 corner1 = new Vector2(0, 0);
        Vector2 corner2 = new Vector2(size, 0);
        Vector2 corner3 = new Vector2(size / 2, size * MathUtils.sin(MathUtils.PI/3f));
        drawSierpinskiTriangle(shapeRenderer, corner1, corner2, corner3, recursions);
    }

    private void drawSierpinskiTriangle(ShapeRenderer shapeRenderer, Vector2 corner1, Vector2 corner2, Vector2 corner3, int recursions) {

        Vector2 midpoint12 = new Vector2((corner1.x + corner2.x) / 2, (corner1.y + corner2.y) / 2);
        Vector2 midpoint23 = new Vector2((corner2.x + corner3.x) / 2, (corner2.y + corner3.y) / 2);
        Vector2 midpoint31 = new Vector2((corner3.x + corner1.x) / 2, (corner3.y + corner1.y) / 2);

        if (recursions == 1) {
            shapeRenderer.triangle(corner1.x, corner1.y, midpoint12.x, midpoint12.y, midpoint31.x, midpoint31.y);
            shapeRenderer.triangle(corner2.x, corner2.y, midpoint23.x, midpoint23.y, midpoint12.x, midpoint12.y);
            shapeRenderer.triangle(corner3.x, corner3.y, midpoint31.x, midpoint31.y, midpoint23.x, midpoint23.y);
        } else {
            drawSierpinskiTriangle(shapeRenderer, corner1, midpoint12, midpoint31, recursions - 1);
            drawSierpinskiTriangle(shapeRenderer, corner2, midpoint23, midpoint12, recursions - 1);
            drawSierpinskiTriangle(shapeRenderer, corner3, midpoint31, midpoint23, recursions - 1);
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