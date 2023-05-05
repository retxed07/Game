package com.mygdx.game.ud405._1_4_10_Solution_WordCloud;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Functions;
import com.mygdx.game.SplashScreen;
import com.mygdx.game.ud405.ud405;


/**
 * TODO: Start here
 * <p>
 * In this exercise, we'll create a word cloud. We've created all the infrastructure like the
 * SpriteBatch and BitmapFont. Now all you need to do is actually draw the random collection of
 * words we've generated.
 * <p>
 * You can find the Word class at the bottom of this file. It contains 5 fields:
 * <p>
 * x, y - Normalized position (meaning in the range 0-1), you'll want to multiply by
 * Gdx.graphics.getWidth() and Gdx.graphics.getHeight() as appropriate.
 * <p>
 * scale - The size of the text.
 * <p>
 * color - The color of the word.
 * <p>
 * letters - The actual letters in the world.
 * <p>
 * Jump to the TODOs below to see what you'll need to do.
 */

public class WordCloud implements Screen, InputProcessor {
    SplashScreen game;
    private static final int WORD_COUNT = 20;
    private static final float MIN_SCALE = 0.5f;
    private static final float MAX_SCALE = 5.0f;

    SpriteBatch batch;
    BitmapFont font;

    Array<Word> words;

    public WordCloud(SplashScreen game) {
        this.game = game;

        batch = new SpriteBatch();
        font = new BitmapFont();
        font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
        words = generateWords(WORD_COUNT);
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
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
        batch.begin();

        for (Word word : words) {

            // TODO: Set the font's scale using font.getData().setScale()
            font.getData().setScale(word.scale);

            // TODO: Set the font's tint using font.setColor()
            font.setColor(word.color);

            // TODO: Actually draw the word using font.draw()
            font.draw(batch, word.letters, word.x * Gdx.graphics.getWidth(), word.y * Gdx.graphics.getHeight());
        }
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        batch = new SpriteBatch();
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

    private Array<Word> generateWords(int count) {
        Array<Word> newWords = new Array<Word>(count);
        for (int i = 0; i < count; i++) {
            newWords.add(Word.randomWord(MIN_SCALE, MAX_SCALE));
        }
        return newWords;
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

    static class Word {

        private static final String[] WORDS =
                {"render-farm", "refrigerator", "tiger-team", "weathered", "camera", "tattoo", "boat", "soul-delay", "nodal point", "motion augmented", "reality neon", "nano-construct", "garage", "bicycle", "rebar tanto", "modem", "concrete RAF", "industrial grade media", "realism", "drone", "post-franchise shoes", "render-farm-ware", "DIY San Francisco", "rain lights", "numinous tank-traps", "pen drone", "cyber-cardboard", "denim monofilament", "order-flow", "smart-hotdog"};
        float x;
        float y;
        float scale;
        Color color;
        String letters;

        public Word(float x, float y, float scale, Color color, String letters) {
            this.x = x;
            this.y = y;
            this.scale = scale;
            this.color = color;
            this.letters = letters;
        }

        static Word randomWord(float minScale, float maxScale) {
            float x = MathUtils.random(-.25f, .75f);
            float y = MathUtils.random();
            float scale = minScale + (maxScale - minScale) * MathUtils.random();
            Color color = new Color(MathUtils.random(), MathUtils.random(), MathUtils.random(), 1);
            String letters = WORDS[MathUtils.random(WORDS.length - 1)];
            return new Word(x, y, scale, color, letters);
        }
    }
}