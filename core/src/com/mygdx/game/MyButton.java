package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class MyButton {
    private int x;
    private int y;
    private int width;
    private int height;
    private int textX;
    private int textY;
    private int textWidth = 200 - 60;
    private String text;
    private final Rectangle rect = new Rectangle();
    private TextureRegion texture;
    private boolean isPressed = false;

    public int getTextWidth() {
        return textWidth;
    }

    public void setTextWidth(SplashScreen game, String text) {
        GlyphLayout layout = new GlyphLayout(game.asepriteFont, text);
        this.textWidth = (int) layout.width;
    }

    public void textMoveDown() {
        if (!isPressed) {
            this.setTextY(textY - 3);
            this.setIsPressed(true);
        }
    }

    public void textCancelMoveDown() {
        if (isPressed) {
            this.setTextY(textY + 3);
            this.setIsPressed(false);
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getTextX() {
        return textX;
    }

    public void setTextX(int textX) {
        this.textX = textX;
    }

    public int getTextY() {
        return textY;
    }

    public void setTextY(int textY) {
        this.textY = textY;
    }

    public Rectangle getRect() {
        rect.x = x;
        rect.y = y;
        rect.width = textWidth + 60;
        rect.height = height;
        return rect;
    }

    public TextureRegion getTexture() {
        return texture;
    }

    public void setTexture(TextureRegion texture) {
        this.texture = texture;
        this.width = texture.getRegionWidth();
        this.height = texture.getRegionHeight();
    }

    public boolean getIsPressed() {
        return isPressed;
    }

    public void setIsPressed(boolean pressed) {
        isPressed = pressed;
    }

}
