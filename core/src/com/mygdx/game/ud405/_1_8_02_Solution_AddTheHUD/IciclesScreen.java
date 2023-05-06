package com.mygdx.game.ud405._1_8_02_Solution_AddTheHUD;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Functions;
import com.mygdx.game.SplashScreen;
import com.mygdx.game.ud405.ud405;


public class IciclesScreen implements Screen, InputProcessor {
    SplashScreen game;
    public static final String TAG = IciclesScreen.class.getName();

    ExtendViewport iciclesViewport;
    ShapeRenderer renderer;

    // TODO: Add ScreenViewport for HUD
    ScreenViewport hudViewport;

    // TODO: Add SpriteBatch
    SpriteBatch batch;

    // TODO: Add BitmapFont
    BitmapFont font;

    Player player;
    Icicles icicles;

    // TODO: Add int to hold the top score
    int topScore;

    public IciclesScreen(SplashScreen game) {
        this.game = game;
    }

    @Override
    public void show() {
        iciclesViewport = new ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);

        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);

        // TODO: Initialize the HUD viewport
        hudViewport = new ScreenViewport();

        // TODO: Initialize the SpriteBatch
        batch = new SpriteBatch();

        // TODO: Initialize the BitmapFont
        font = new BitmapFont();

        // TODO: Give the font a linear TextureFilter
        font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);

        player = new Player(iciclesViewport);
        icicles = new Icicles(iciclesViewport);

        // TODO: Set top score to zero
        topScore = 0;

        Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
    }

    @Override
    public void resize(int width, int height) {
        iciclesViewport.update(width, height, true);

        // TODO: Update HUD viewport
        hudViewport.update(width, height, true);

        // TODO: Set font scale to min(width, height) / reference screen size
        font.getData().setScale(Math.min(width, height) / Constants.HUD_FONT_REFERENCE_SCREEN_SIZE);

        player.init();
        icicles.init();
    }

    @Override
    public void dispose() {
        renderer.dispose();
        // TODO: Dispose of the SpriteBatch and font
        batch.dispose();
        font.dispose();
    }


    @Override
    public void render(float delta) {
        icicles.update(delta);
        player.update(delta);
        if (player.hitByIcicle(icicles)) {
            icicles.init();
        }


        iciclesViewport.apply(true);
        Gdx.gl.glClearColor(Constants.BACKGROUND_COLOR.r, Constants.BACKGROUND_COLOR.g, Constants.BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(iciclesViewport.getCamera().combined);
        renderer.begin(ShapeType.Filled);
        icicles.render(renderer);
        player.render(renderer);
        renderer.end();

        // TODO: Set the top score to max(topScore, iciclesDodges)
        topScore = Math.max(topScore, icicles.iciclesDodged);

        // TODO: Apply the HUD viewport
        hudViewport.apply();

        // TODO: Set the SpriteBatch's projection matrix
        batch.setProjectionMatrix(hudViewport.getCamera().combined);

        // TODO: Begin the SpriteBatch
        batch.begin();

        // TODO: Draw the number of player deaths in the top left
        font.draw(batch, "Deaths: " + player.deaths,
                Constants.HUD_MARGIN, hudViewport.getWorldHeight() - Constants.HUD_MARGIN);

        // TODO: Draw the score and top score in the top right
        font.draw(batch, "Score: " + icicles.iciclesDodged + "\nTop Score: " + topScore,
                hudViewport.getWorldWidth() - Constants.HUD_MARGIN, hudViewport.getWorldHeight() - Constants.HUD_MARGIN,
                0, Align.right, false);

        // TODO: End the SpriteBatch
        batch.end();

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
