package com.mygdx.game.ud405._1_2_01_Demo_GettingStartedWithLibGDX;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Functions;
import com.mygdx.game.SplashScreen;
import com.mygdx.game.ud405.ud405;

public class UdacityScreen implements Screen, InputProcessor {
    SplashScreen game;
    Texture logo;
    ParticleEffectPool touchEffectPool;
    Array<PooledEffect> effects = new Array<PooledEffect>();

    private static final Color UDACITY_ORANGE = new Color(228.0f / 225.0f, 127.0f / 225.0f, 57.0f / 225.0f, 1.0f);
    private static final Color UDACITY_BLUE = new Color(36.0f / 225.0f, 73.0f / 225.0f, 96.0f / 225.0f, 1.0f);
    private static final float LOGO_WIDTH = 200.0f;
    private final float logoHeight;

    public UdacityScreen(SplashScreen game) {
        this.game = game;

        logo = new Texture("ud405/udacity_logo_white.png");
        logoHeight = logo.getHeight() * LOGO_WIDTH / logo.getWidth();

        ParticleEffect touchEffect = new ParticleEffect();
        touchEffect.load(Gdx.files.internal("ud405/UdacityEmitter.p"), Gdx.files.internal("ud405/"));
        touchEffect.setEmittersCleanUpBlendFunction(false);
        touchEffectPool = new ParticleEffectPool(touchEffect, 1, 2);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
    }

    @Override
    public void render(float delta) {
        // TODO: Make this UDACITY_BLUE instead
        clearScreen(UDACITY_ORANGE);

        game.batch.begin();
        game.batch.draw(logo,
                (Gdx.graphics.getWidth() - LOGO_WIDTH) / 2,
                (Gdx.graphics.getHeight() - logoHeight) / 2,
                LOGO_WIDTH,
                logoHeight);
        for (int i = effects.size - 1; i >= 0; i--) {
            PooledEffect effect = effects.get(i);
            effect.draw(game.batch, delta);
            if (effect.isComplete()) {
                effect.free();
                effects.removeIndex(i);
            }
        }
        game.batch.end();
    }

    private void clearScreen(Color color) {
        Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void spawnParticleEffect(int x, int y) {
        PooledEffect effect = touchEffectPool.obtain();
        effect.setPosition(x, Gdx.graphics.getHeight() - y);
        effects.add(effect);
    }

    @Override
    public boolean keyDown(int keycode) {
        return Functions.onEscapeOrBack(this, game, new ud405(game), keycode);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("touchdown");
        spawnParticleEffect(screenX, screenY);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        System.out.println("touchdragged");
        spawnParticleEffect(screenX, screenY);
        return true;
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
        game.batch.dispose();
        logo.dispose();
        for (int i = effects.size - 1; i >= 0; i--)
            effects.get(i).free();
        effects.clear();
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
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
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