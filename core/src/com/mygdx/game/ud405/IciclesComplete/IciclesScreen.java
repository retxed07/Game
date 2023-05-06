package com.mygdx.game.ud405.IciclesComplete;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
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
    public static final String TAG = IciclesScreen.class.getName();

    public static final Color BACKGROUND_COLOR = Color.BLUE;

    SplashScreen game;
    Constants.Difficulty difficulty;

    ExtendViewport iciclesViewport;
    ShapeRenderer renderer;

    ScreenViewport hudViewport;
    SpriteBatch batch;
    BitmapFont font;

    Player player;
    Icicles icicles;

    int topScore;

    public IciclesScreen(SplashScreen game, Constants.Difficulty difficulty) {
        this.game = game;
        this.difficulty = difficulty;
    }

    @Override
    public void show() {
        iciclesViewport = new ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);

        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);

        hudViewport = new ScreenViewport();
        batch = new SpriteBatch();

        font = new BitmapFont();
        font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);

        player = new Player(iciclesViewport);
        icicles = new Icicles(iciclesViewport, difficulty);

        Gdx.input.setInputProcessor(this);

        topScore = 0;
    }

    @Override
    public void resize(int width, int height) {
        iciclesViewport.update(width, height, true);
        hudViewport.update(width, height, true);
        font.getData().setScale(Math.min(width, height) / Constants.HUD_FONT_REFERENCE_SCREEN_SIZE);

        player.init();
        icicles.init();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void render(float delta) {
        icicles.update(delta);
        player.update(delta);
        if (player.hitByIcicle(icicles)) {
            icicles.init();
        }

        iciclesViewport.apply(true);
        Gdx.gl.glClearColor(BACKGROUND_COLOR.r, BACKGROUND_COLOR.g, BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(iciclesViewport.getCamera().combined);
        renderer.begin(ShapeType.Filled);
        icicles.render(renderer);
        player.render(renderer);
        renderer.end();

        hudViewport.apply();
        batch.setProjectionMatrix(hudViewport.getCamera().combined);
        batch.begin();

        topScore = Math.max(topScore, icicles.iciclesDodged);

        final String leftHudText = Constants.DEATHS_LABEL + player.deaths + "\n" + Constants.DIFFICULTY_LABEL + difficulty.label;
        final String rightHudText = Constants.SCORE_LABEL + icicles.iciclesDodged + "\n" + Constants.TOP_SCORE_LABEL + topScore;

        font.draw(batch, leftHudText, Constants.HUD_MARGIN, hudViewport.getWorldHeight() - Constants.HUD_MARGIN);
        font.draw(batch, rightHudText, hudViewport.getWorldWidth() - Constants.HUD_MARGIN, hudViewport.getWorldHeight() - Constants.HUD_MARGIN,
                0, Align.right, false);

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
        renderer.dispose();
        batch.dispose();

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
        game.setScreen(new DifficultyScreen(game));
        return true;
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