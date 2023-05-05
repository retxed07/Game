package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.demos.Demos;
import com.mygdx.game.ud405.ud405;

public class MainMenuScreen implements Screen, InputProcessor {
    SplashScreen game;
    MyButton button_my_game, button_demos, button_ud405;
    OrthographicCamera orthographicCamera;
    Viewport viewport;
    int screenWidth = 800;
    int screenHeight = 480;

    public MainMenuScreen(SplashScreen game) {
        this.game = game;

        button_my_game = new MyButton();
        button_my_game.setTexture(game.button_idle);
        button_my_game.setText("MY GAME");

        button_demos = new MyButton();
        button_demos.setTexture(game.button_idle);
        button_demos.setText("DEMOS");

        button_ud405 = new MyButton();
        button_ud405.setTexture(game.button_idle);
        button_ud405.setText("UD405");

        orthographicCamera = new OrthographicCamera();
        orthographicCamera.setToOrtho(false, screenWidth, screenHeight);
        viewport = new ScreenViewport(orthographicCamera);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);

        orthographicCamera.update();
        game.batch.setProjectionMatrix(orthographicCamera.combined);
        game.func.getTouchPos().set(Gdx.input.getX(), Gdx.input.getY(), 0);
        orthographicCamera.unproject(game.func.getTouchPos());

        game.batch.begin();
        game.func.drawButton(button_my_game);
        game.func.drawButton(button_demos);
        game.func.drawButton(button_ud405);
        game.batch.end();

        game.func.buttonListener(button_my_game, this, new MyGame(game));
        game.func.buttonListener(button_demos, this, new Demos(game));
        game.func.buttonListener(button_ud405, this, new ud405(game));
    }

    @Override
    public void resize(int width, int height) {
        screenWidth = width;
        screenHeight = height;
        game.func.repositionAtCenter(button_my_game, 0, 60, 30, 10);
        game.func.repositionAtCenter(button_demos, 0, 0, 30, 10);
        game.func.repositionAtCenter(button_ud405, 0, -60, 30, 10);
        orthographicCamera.setToOrtho(false, screenWidth, screenHeight);
        viewport.update(width, height);
    }

    @Override
    public void dispose() {
        game.batch.dispose();
        game.asepriteFont.dispose();
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
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
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
