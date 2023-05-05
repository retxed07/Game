package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class SplashScreen extends Game {
    public SpriteBatch batch;
    public BitmapFont asepriteFont;
    public TextureRegion[][] button;
    public TextureRegion button_idle, button_pressed, button_hover;
    public Sound sound_button_push, sound_button_hover;
    public Functions func;

    public void create() {
        batch = new SpriteBatch();

        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/AsepriteFont.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.size = 32;
        asepriteFont = fontGenerator.generateFont(fontParameter);

        button = (new TextureRegion(new Texture(Gdx.files.internal("button.png")))).split(200, 50);
        button_idle = button[0][0];
        button_hover = button[0][1];
        button_pressed = button[1][0];

        sound_button_push = Gdx.audio.newSound(Gdx.files.internal("button_push.wav"));
        sound_button_hover = Gdx.audio.newSound(Gdx.files.internal("button_hover.mp3"));

        func = new Functions();
        func.setGame(this);
        func.setSoundButtonHover(sound_button_hover);
        func.setSoundButtonPush(sound_button_push);
        func.setTouchPos(new Vector3());

        this.setScreen(new MainMenuScreen(this));
    }

    public void render() {
        super.render(); // important!
    }

    public void dispose() {
        batch.dispose();
        sound_button_hover.dispose();
        sound_button_push.dispose();
        asepriteFont.dispose();
    }
}
