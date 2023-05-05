package com.mygdx.game.demos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Functions;
import com.mygdx.game.MainMenuScreen;
import com.mygdx.game.MyButton;
import com.mygdx.game.SplashScreen;
import com.mygdx.game.demos.drop.DropMainMenu;
import com.mygdx.game.ud405.ud405;

public class Demos implements Screen, InputProcessor {
    SplashScreen game;
    MyButton button_drop, button_sample, button_back;
    OrthographicCamera orthographicCamera;
    Viewport viewport;
    int screenWidth = 800;
    int screenHeight = 480;

    public Demos(SplashScreen game) {
        this.game = game;

        button_drop = new MyButton();
        button_drop.setTexture(game.button_idle);
        button_drop.setText("DROP");

        button_sample = new MyButton();
        button_sample.setTexture(game.button_idle);
        button_sample.setText("SAMPLE");

        button_back = new MyButton();
        button_back.setTexture(game.button_idle);
        button_back.setText("BACK");

        orthographicCamera = new OrthographicCamera();
        orthographicCamera.setToOrtho(false, screenWidth, screenHeight);
        viewport = new ScreenViewport(orthographicCamera);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);

        orthographicCamera.update();
        game.batch.setProjectionMatrix(orthographicCamera.combined);
        game.func.getTouchPos().set(Gdx.input.getX(), Gdx.input.getY(), 0);
        orthographicCamera.unproject(game.func.getTouchPos());

        game.batch.begin();
        game.func.drawButton(button_drop);
        game.func.drawButton(button_sample);
        game.func.drawButton(button_back);
        game.batch.end();

        game.func.buttonListener(button_drop, this, new DropMainMenu(game));
        game.func.onHover(button_sample);
        game.func.buttonListener(button_back, this, new MainMenuScreen(game));
    }

    @Override
    public void resize(int width, int height) {
        screenWidth = width;
        screenHeight = height;
        game.func.repositionAtCenter(button_drop, 0, 60, 30, 10);
        game.func.repositionAtCenter(button_sample, 0, 0, 30, 10);
        game.func.repositionAtCenter(button_back, 0, -60, 30, 10);
        orthographicCamera.setToOrtho(false, screenWidth, screenHeight);
        viewport.update(width, height);
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
        game.batch.dispose();
        game.asepriteFont.dispose();
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
