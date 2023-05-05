package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector3;

public class Functions {
    private SplashScreen game;
    private Vector3 touchPos;
    private Sound sound_button_hover;
    private Sound sound_button_push;

    public static boolean onEscapeOrBack(Screen _this, SplashScreen game, Screen nextScreen, int keycode) {
        System.out.println("keydown " + keycode + "|" + Input.Keys.ESCAPE);
        if (keycode == Input.Keys.ESCAPE || keycode == Input.Keys.BACK) {
            _this.hide();
            game.setScreen(nextScreen);
            return true;
        }
        return true;
    }

    public void setGame(SplashScreen game) {
        this.game = game;
    }

    public Vector3 getTouchPos() {
        return touchPos;
    }

    public void setTouchPos(Vector3 touchPos) {
        this.touchPos = touchPos;
    }

    public void setSoundButtonHover(Sound sound_button_hover) {
        this.sound_button_hover = sound_button_hover;
    }

    public void setSoundButtonPush(Sound sound_button_push) {
        this.sound_button_push = sound_button_push;
    }

    public void reposition(MyButton myButton, int x, int y, int textX, int textY) {
        myButton.setX(x);
        myButton.setY(y);
        myButton.setTextX((myButton.getX() + textX));
        myButton.setTextY((myButton.getY() + myButton.getHeight() / 2) + textY);
    }

    public void repositionAtCenter(MyButton myButton, int x, int y, int textX, int textY) {
        int centerX = ((Gdx.graphics.getWidth() / 2) - game.button_idle.getRegionWidth() / 2);
        int centerY = ((Gdx.graphics.getHeight() / 2) - game.button_idle.getRegionHeight() / 2);
        myButton.setX(centerX + (x * game.button_idle.getRegionWidth()));
        myButton.setY(centerY + y);
        myButton.setTextX((myButton.getX() + textX));
        myButton.setTextY((myButton.getY() + myButton.getHeight() / 2) + textY);
    }

    public void drawButton(MyButton myButton) {
        drawTexture(myButton);
        drawText(myButton);
    }

    public void drawTexture(MyButton myButton) {
        game.batch.draw(myButton.getTexture(), myButton.getX(), myButton.getY(), myButton.getTextWidth() + 60, myButton.getHeight());
    }

    public void drawText(MyButton myButton) {
        game.asepriteFont.draw(game.batch, myButton.getText(), myButton.getTextX(), myButton.getTextY());
    }

    public void buttonListener(MyButton myButton, Screen _this, Screen screen) {
        onHover(myButton);
        onClickedChangeScreen(myButton, _this, screen);
    }

    public void buttonListener(MyButton myButton, Screen _this, Screen screen, boolean isDispose) {
        onHover(myButton);
        onClickedChangeScreen(myButton, _this, screen, isDispose);
    }

    public void onHover(MyButton myButton) {
        if (myButton.getRect().contains(touchPos.x, touchPos.y)) {
            if (myButton.getTexture() == game.button_idle) {
                sound_button_hover.stop();
                sound_button_hover.setVolume(sound_button_hover.play(), 0.3f);
            }
            myButton.setTexture(game.button_hover);
        } else {
            myButton.setTexture(game.button_idle);
        }
    }

    public void onClickedChangeScreen(MyButton myButton, Screen _this, Screen screen, boolean isDispose) {
        if (Gdx.input.isTouched()) {
            if (myButton.getRect().contains(touchPos.x, touchPos.y)) {
                myButton.textMoveDown();
                sound_button_push.stop();
                sound_button_push.play();
                myButton.setTexture(game.button_pressed);
            }
        }
        if (myButton.getTexture() == game.button_hover && myButton.getIsPressed()) {
            myButton.textCancelMoveDown();
            _this.hide();
            game.setScreen(screen);
        }
    }

    public void onClickedChangeScreen(MyButton myButton, Screen _this, Screen screen) {
        if (Gdx.input.isTouched()) {
            if (myButton.getRect().contains(touchPos.x, touchPos.y)) {
                myButton.textMoveDown();
                sound_button_push.stop();
                sound_button_push.play();
                myButton.setTexture(game.button_pressed);
            }
        }
        if (myButton.getTexture() == game.button_hover && myButton.getIsPressed()) {
            myButton.textCancelMoveDown();
            _this.hide();
            game.setScreen(screen);
        }
    }

    public void onTouchDownRect(MyButton myButton) {
        if (myButton.getRect().contains(touchPos.x, touchPos.y)) {
            myButton.textMoveDown();
            sound_button_push.stop();
            sound_button_push.play();
            myButton.setTexture(game.button_pressed);
        }
    }

    public void onTouchUpRect(MyButton myButton, Screen _this, Screen screen) {
        if (myButton.getRect().contains(touchPos.x, touchPos.y)) {
            myButton.textCancelMoveDown();
            myButton.setTexture(game.button_hover);
            _this.hide();
            game.setScreen(screen);
        }
    }
}
