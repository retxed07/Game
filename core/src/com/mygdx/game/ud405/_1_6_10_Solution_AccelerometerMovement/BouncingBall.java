package com.mygdx.game.ud405._1_6_10_Solution_AccelerometerMovement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Functions;
import com.mygdx.game.SplashScreen;
import com.mygdx.game.ud405.ud405;

import java.util.Random;


public class BouncingBall extends InputAdapter {
    SplashScreen game;
    Screen _this;
    private static final Color COLOR = Color.RED;
    private static final float DRAG = 0.5f;
    private static final float RADIUS_FACTOR = 1.0f / 20;
    private static final float RADIUS_GROWTH_RATE = 1.5f;
    private static final float MIN_RADIUS_MULTIPLIER = 0.1f;
    private static final float ACCELERATION = 500.0f;
    private static final float MAX_SPEED = 4000.0f;

    private static final float ACCELEROMETER_SENSITIVITY = 0.5f;
    private static final float ACCELERATION_OF_GRAVITY = 9.8f;


    private static final float KICK_VELOCITY = 500.0f;

    long lastKick;

    float baseRadius;
    float radiusMultiplier;

    Vector2 position;
    Vector2 velocity;

    Viewport viewport;

    public BouncingBall(SplashScreen game, Screen _this, Viewport viewport) {
        this.game = game;
        this._this = _this;
        this.viewport = viewport;
        init();
    }

    public void init() {
        position = new Vector2(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2);
        velocity = new Vector2();
        baseRadius = RADIUS_FACTOR * Math.min(viewport.getWorldWidth(), viewport.getWorldHeight());
        radiusMultiplier = 1;
    }

    private void randomKick() {
        Random random = new Random();
        float angle = MathUtils.PI2 * random.nextFloat();
        velocity.x += KICK_VELOCITY * MathUtils.cos(angle);
        velocity.y += KICK_VELOCITY * MathUtils.sin(angle);
    }


    public void update(float delta) {

        // Growing and shrinking
        if (Gdx.input.isKeyPressed(Keys.Z)) {
            radiusMultiplier += delta * RADIUS_GROWTH_RATE;
        }
        if (Gdx.input.isKeyPressed(Keys.X)) {
            radiusMultiplier -= delta * RADIUS_GROWTH_RATE;
            radiusMultiplier = Math.max(radiusMultiplier, MIN_RADIUS_MULTIPLIER);
        }

        if (following) {
            velocity.x = 2 * (targetPosition.x - position.x);
            velocity.y = 2 * (targetPosition.y - position.y);
        }

        // Movement
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            velocity.x -= delta * ACCELERATION;

        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            velocity.x += delta * ACCELERATION;

        }
        if (Gdx.input.isKeyPressed(Keys.UP)) {
            velocity.y += delta * ACCELERATION;

        }
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            velocity.y -= delta * ACCELERATION;
        }

        // Accelerometer Movement


        // TODO: Get the accelerometer reading for the x axis (remember that the reading will be relative to the portrait device orientation)
        float xAxis = -Gdx.input.getAccelerometerY();

        // TODO: Get the accelerometer reading for the y axis
        float yAxis = Gdx.input.getAccelerometerX();

        // TODO: Use ACCELERATION, ACCELEROMETER_SENSITIVITY, and ACCELERATION_OF_GRAVITY to determine the acceleration to apply to the ball
        // Note we want to negate the value, since we want to fall away from the direction of the accelerometer readings
        float accelerationX = -ACCELERATION * xAxis / (ACCELEROMETER_SENSITIVITY * ACCELERATION_OF_GRAVITY);
        float accelerationY = -ACCELERATION * yAxis / (ACCELEROMETER_SENSITIVITY * ACCELERATION_OF_GRAVITY);


        // TODO: Apply that acceleration to the ball
        velocity.x += delta * accelerationX;
        velocity.y += delta * accelerationY;

        velocity.clamp(0, MAX_SPEED);

        velocity.x -= delta * DRAG * velocity.x;
        velocity.y -= delta * DRAG * velocity.y;

        position.x += delta * velocity.x;
        position.y += delta * velocity.y;


        collideWithWalls(baseRadius * radiusMultiplier, viewport.getWorldWidth(), viewport.getWorldHeight());
    }

    private void collideWithWalls(float radius, float viewportWidth, float viewportHeight) {
        if (position.x - radius < 0) {
            position.x = radius;
            velocity.x = -velocity.x;
        }
        if (position.x + radius > viewportWidth) {
            position.x = viewportWidth - radius;
            velocity.x = -velocity.x;
        }
        if (position.y - radius < 0) {
            position.y = radius;
            velocity.y = -velocity.y;
        }
        if (position.y + radius > viewportHeight) {
            position.y = viewportHeight - radius;
            velocity.y = -velocity.y;
        }
    }

    public void render(ShapeRenderer renderer) {
        renderer.set(ShapeType.Filled);
        renderer.setColor(COLOR);
        renderer.circle(position.x, position.y, baseRadius * radiusMultiplier);
    }


    @Override
    public boolean keyDown(int keycode) {

        if (keycode == Keys.SPACE) {
            randomKick();
        }

        if (keycode == Keys.R) {
            init();
        }

        Functions.onEscapeOrBack(_this, game, new ud405(game), keycode);

        return true;
    }

    Vector2 flickStart;
    Vector2 targetPosition;
    boolean flicking = false;
    boolean following = false;

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        Vector2 worldClick = viewport.unproject(new Vector2(screenX, screenY));


        if (worldClick.dst(position) < baseRadius * radiusMultiplier) {
            Gdx.app.log("Ball", "Click in the ball, starting flick.");
            flicking = true;
            flickStart = worldClick;
        } else {
            targetPosition = worldClick;
            following = true;
        }


        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        targetPosition = viewport.unproject(new Vector2(screenX, screenY));
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (flicking) {
            flicking = false;
            Vector2 flickEnd = viewport.unproject(new Vector2(screenX, screenY));

            velocity.x += 3 * (flickEnd.x - flickStart.x);
            velocity.y += 3 * (flickEnd.y - flickStart.y);
            Gdx.app.log("Ball", "End flick");
        }
        following = false;

        return true;
    }
}