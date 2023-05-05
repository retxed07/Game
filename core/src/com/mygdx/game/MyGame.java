package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.ud405.ud405;

public class MyGame implements Screen, InputProcessor {
    SplashScreen game;
    MyButton button_online, button_offline, button_back;
    OrthographicCamera orthographicCamera;
    Viewport viewport;
    int screenWidth = 800;
    int screenHeight = 480;

    public MyGame(final SplashScreen game) {
        this.game = game;

        button_online = new MyButton();
        button_online.setTexture(game.button_idle);
        button_online.setText("ONLINE");

        button_offline = new MyButton();
        button_offline.setTexture(game.button_idle);
        button_offline.setText("OFFLINE");

        button_back = new MyButton();
        button_back.setTexture(game.button_idle);
        button_back.setText("BACK");

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
        game.func.drawButton(button_online);
        game.func.drawButton(button_offline);
        game.func.drawButton(button_back);
        game.batch.end();

        game.func.buttonListener(button_online, this, new MyGame(game));
        game.func.buttonListener(button_offline, this, new MyGame(game));
        game.func.buttonListener(button_back, this, new MainMenuScreen(game));
    }

    @Override
    public void resize(int width, int height) {
        screenWidth = width;
        screenHeight = height;
        game.func.repositionAtCenter(button_online, 0, 60, 30, 10);
        game.func.repositionAtCenter(button_offline, 0, 0, 30, 10);
        game.func.repositionAtCenter(button_back, 0, -60, 30, 10);
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
