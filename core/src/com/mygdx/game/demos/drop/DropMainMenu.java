package com.mygdx.game.demos.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Functions;
import com.mygdx.game.MyButton;
import com.mygdx.game.SplashScreen;
import com.mygdx.game.demos.Demos;
import com.mygdx.game.ud405.ud405;

public class DropMainMenu implements Screen, InputProcessor {
    SplashScreen game;
    OrthographicCamera orthographicCamera;
    Viewport viewport;
    int screenWidth = 800;
    int screenHeight = 480;
    MyButton button_back;

    public DropMainMenu(SplashScreen game) {
        this.game = game;

        button_back = new MyButton();
        button_back.setTexture(game.button_idle);
        button_back.setText("BACK");

        orthographicCamera = new OrthographicCamera();
        orthographicCamera.setToOrtho(false, screenWidth, screenHeight);
        viewport = new ScreenViewport(orthographicCamera);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0.2f, 1);

        orthographicCamera.update();
        game.batch.setProjectionMatrix(orthographicCamera.combined);
        game.func.getTouchPos().set(Gdx.input.getX(), Gdx.input.getY(), 0);
        orthographicCamera.unproject(game.func.getTouchPos());

        game.batch.begin();
        game.func.drawButton(button_back);
        game.asepriteFont.draw(game.batch, "Welcome to Drop!!! ", 50, 150);
        game.asepriteFont.draw(game.batch, "Tap anywhere to begin!", 50, 100);
        game.asepriteFont.draw(game.batch, "Press 'escape' if you want to quit the game!", 50, 50);
        game.batch.end();

        game.func.buttonListener(button_back, this, new Demos(game));

        if (Gdx.input.isTouched() && !button_back.getRect().contains(game.func.getTouchPos().x, game.func.getTouchPos().y)) {
            this.hide();
            dispose();
            game.setScreen(new DropGameScreen(game));
        }
    }

    @Override
    public void resize(int width, int height) {
        screenWidth = width;
        screenHeight = height;
        game.func.reposition(button_back, (screenWidth - button_back.getWidth()) - 2, (screenHeight - button_back.getHeight()) - 2, 30, 10);
        orthographicCamera.setToOrtho(false, screenWidth, screenHeight);
        viewport.update(width, height);
    }

    @Override
    public void dispose() {

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
