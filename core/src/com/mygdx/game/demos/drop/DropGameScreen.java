package com.mygdx.game.demos.drop;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.*;
import com.mygdx.game.Functions;
import com.mygdx.game.MyButton;
import com.mygdx.game.SplashScreen;
import com.mygdx.game.demos.Demos;
import com.mygdx.game.ud405.ud405;

public class DropGameScreen implements Screen, InputProcessor {
    Texture dropImage;
    Texture bucketImage;
    Sound dropSound;
    Music rainMusic;
    OrthographicCamera orthographicCamera;
    Rectangle bucket;
    Array<Rectangle> raindrops;
    MyButton button_back;

    SplashScreen game;
    private final Viewport viewport;
    long lastDropTime;
    int dropsGathered;
    int screenWidth = 800;
    int screenHeight = 480;
    int bucketSize = 64;
    int raindropSize = 64;

    public DropGameScreen(SplashScreen game) {
        this.game = game;

        // load the images for the droplet and the bucket, 64x64 pixels each
        dropImage = new Texture(Gdx.files.internal("drop/droplet.png"));
        bucketImage = new Texture(Gdx.files.internal("drop/bucket.png"));

        // load the drop sound effect and the rain background "music"
        dropSound = Gdx.audio.newSound(Gdx.files.internal("drop/drop.wav"));
        rainMusic = Gdx.audio.newMusic(Gdx.files.internal("drop/rain.mp3"));
        rainMusic.setLooping(true);

        button_back = new MyButton();
        button_back.setTexture(game.button_idle);
        button_back.setText("BACK");

        // create the camera and the SpriteBatch
        orthographicCamera = new OrthographicCamera();
        orthographicCamera.setToOrtho(false, screenWidth, screenHeight);

        // create a Rectangle to logically represent the bucket
        bucket = new Rectangle();
        bucket.x = screenWidth / 2 - bucketSize / 2; // center the bucket horizontally
        bucket.y = 20; // bottom left corner of the bucket is 20 pixels above
        // the bottom screen edge
        bucket.width = bucketSize;
        bucket.height = bucketSize;

        // create the raindrops array and spawn the first raindrop
        raindrops = new Array<Rectangle>();
        spawnRaindrop();

        viewport = new ScreenViewport(orthographicCamera);
    }

    private void spawnRaindrop() {
        Rectangle raindrop = new Rectangle();
        raindrop.x = MathUtils.random(0, screenWidth - raindropSize);
        raindrop.y = screenHeight;
        raindrop.width = raindropSize;
        raindrop.height = raindropSize;
        raindrops.add(raindrop);
        lastDropTime = TimeUtils.nanoTime();
    }

    @Override
    public void render(float delta) {
        // clear the screen with a dark blue color. The
        // arguments to clear are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        ScreenUtils.clear(0, 0, 0.2f, 1);

        // tell the camera to update its matrices.
        orthographicCamera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        game.batch.setProjectionMatrix(orthographicCamera.combined);
        game.func.getTouchPos().set(Gdx.input.getX(), Gdx.input.getY(), 0);
        orthographicCamera.unproject(game.func.getTouchPos());

        // begin a new batch and draw the bucket and
        // all drops
        game.batch.begin();
        game.func.drawButton(button_back);
        game.asepriteFont.draw(game.batch, "Drops Collected: " + dropsGathered, 10, screenHeight - 10);
        game.batch.draw(bucketImage, bucket.x, bucket.y, bucket.width, bucket.height);
        for (Rectangle raindrop : raindrops) {
            game.batch.draw(dropImage, raindrop.x, raindrop.y);
        }
        game.batch.end();

        game.func.buttonListener(button_back, this, new DropMainMenu(game), true);

        // process user input
        if (Gdx.input.isTouched()) {
            bucket.x = game.func.getTouchPos().x - bucketSize / 2;
        }

        if (Gdx.input.isKeyPressed(Keys.LEFT))
            bucket.x -= 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Keys.RIGHT))
            bucket.x += 200 * Gdx.graphics.getDeltaTime();

        // make sure the bucket stays within the screen bounds
        if (bucket.x < 0)
            bucket.x = 0;
        if (bucket.x > screenWidth - bucketSize)
            bucket.x = screenWidth - bucketSize;

        // check if we need to create a new raindrop
        if (TimeUtils.nanoTime() - lastDropTime > 1000000000)
            spawnRaindrop();

        // move the raindrops, remove any that are beneath the bottom edge of
        // the screen or that hit the bucket. In the later case we increase the
        // value our drops counter and add a sound effect.
        Iterator<Rectangle> iter = raindrops.iterator();
        while (iter.hasNext()) {
            Rectangle raindrop = iter.next();
            raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
            if (raindrop.y + bucketSize < 0)
                iter.remove();
            if (raindrop.overlaps(bucket)) {
                dropsGathered++;
                dropSound.play();
                iter.remove();
            }
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
    public void show() {
        // start the playback of the background music
        // when the screen is shown
        Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
        rainMusic.play();
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
    public void dispose() {
        dropImage.dispose();
        bucketImage.dispose();
        dropSound.dispose();
        rainMusic.dispose();
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
