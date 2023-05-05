package com.mygdx.game.ud405;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Functions;
import com.mygdx.game.MainMenuScreen;
import com.mygdx.game.MyButton;
import com.mygdx.game.SplashScreen;
import com.mygdx.game.ud405._1_2_01_Demo_GettingStartedWithLibGDX.UdacityScreen;
import com.mygdx.game.ud405._1_3_01_Demo_DrawingPoints.PointDrawing;
import com.mygdx.game.ud405._1_3_02_Solution_DrawAStarfield.Starfield;
import com.mygdx.game.ud405._1_3_03_Demo_DrawingLines.DrawingLines;
import com.mygdx.game.ud405._1_3_04_Solution_ConnectTheDots.ConnectTheDots;
import com.mygdx.game.ud405._1_3_05_Solution_DrawASpiral.DrawASpiral;
import com.mygdx.game.ud405._1_3_06_Demo_DrawingRectangles.DrawingRectangles;
import com.mygdx.game.ud405._1_3_07_Solution_RectangularFlower.RectangularFlower;
import com.mygdx.game.ud405._1_3_08_Solution_DrawTheCantorGasket.DrawTheCantorGasket;
import com.mygdx.game.ud405._1_3_09_Solution_DrawTheDragonCurve.DragonCurve;
import com.mygdx.game.ud405._1_4_01_Demo_CirclesAndArcs.CirclesAndArcs;
import com.mygdx.game.ud405._1_4_02_Solution_StickFigure.StickFigure;
import com.mygdx.game.ud405._1_4_03_Demo_Cameras.OrthographicProjection;
import com.mygdx.game.ud405._1_4_04_Demo_SolarSystem.Closeup;
import com.mygdx.game.ud405._1_4_05_Solution_OrthographicCamera.OrthographicCameraExercise;
import com.mygdx.game.ud405._1_4_06_Demo_Viewports.ViewportsDemo;
import com.mygdx.game.ud405._1_4_07_Solution_Viewports.ViewportsExercise;
import com.mygdx.game.ud405._1_4_08_Solution_SmileyFace.SmileyFace;
import com.mygdx.game.ud405._1_4_09_Demo_Text.TextDemo;
import com.mygdx.game.ud405._1_4_10_Solution_WordCloud.WordCloud;
import com.mygdx.game.ud405._1_4_11_Solution_CyclicOverlap.CyclicOverlap;

public class ud405 implements Screen, InputProcessor {
    SplashScreen game;
    OrthographicCamera orthographicCamera;
    Viewport viewport;
    int defaultWidth = 800, defaultHeight = 480;

    MyButton button_1_2_01;
    MyButton button_1_3_01;
    MyButton button_1_3_02;
    MyButton button_1_3_03;
    MyButton button_1_3_04;
    MyButton button_1_3_05;
    MyButton button_1_3_06;
    MyButton button_1_3_07;
    MyButton button_1_3_08;
    MyButton button_1_3_09;
    MyButton button_1_4_01;
    MyButton button_1_4_02;
    MyButton button_1_4_03;
    MyButton button_1_4_04;
    MyButton button_1_4_05;
    MyButton button_1_4_06;
    MyButton button_1_4_07;
    MyButton button_1_4_08;
    MyButton button_1_4_09;
    MyButton button_1_4_10;
    MyButton button_1_4_11;
    int moveSpeedXNegative = 0;
    int moveSpeedXPositive = 0;
    int moveSpeedYNegative = 0;
    int moveSpeedYPositive = 0;
    int moveSpeed = 10;

    public ud405(SplashScreen game) {
        this.game = game;

        button_1_2_01 = new MyButton(game, game.button_idle, "_1_2_01_Demo_GettingStartedWithLibGDX");
        button_1_3_01 = new MyButton(game, game.button_idle, "_1_3_01_Demo_DrawingPoints");
        button_1_3_02 = new MyButton(game, game.button_idle, "_1_3_02_Exercise_DrawAStarfield");
        button_1_3_03 = new MyButton(game, game.button_idle, "_1_3_03_Demo_DrawingLines");
        button_1_3_04 = new MyButton(game, game.button_idle, "_1_3_04_Solution_ConnectTheDots");
        button_1_3_05 = new MyButton(game, game.button_idle, "_1_3_05_Solution_DrawASpiral");
        button_1_3_06 = new MyButton(game, game.button_idle, "_1_3_06_Demo_DrawingRectangles");
        button_1_3_07 = new MyButton(game, game.button_idle, "_1_3_07_Solution_RectangularFlower");
        button_1_3_08 = new MyButton(game, game.button_idle, "_1_3_08_Solution_DrawTheCantorGasket");
        button_1_3_09 = new MyButton(game, game.button_idle, "_1_3_09_Solution_DrawTheDragonCurve");
        button_1_4_01 = new MyButton(game, game.button_idle, "_1_4_01_Demo_CirclesAndArcs");
        button_1_4_02 = new MyButton(game, game.button_idle, "_1_4_02_Solution_StickFigure");
        button_1_4_03 = new MyButton(game, game.button_idle, "_1_4_03_Demo_Cameras");
        button_1_4_04 = new MyButton(game, game.button_idle, "_1_4_04_Demo_SolarSystem");
        button_1_4_05 = new MyButton(game, game.button_idle, "_1_4_05_Solution_OrthographicCamera");
        button_1_4_06 = new MyButton(game, game.button_idle, "_1_4_06_Demo_Viewports");
        button_1_4_07 = new MyButton(game, game.button_idle, "_1_4_07_Solution_Viewports");
        button_1_4_08 = new MyButton(game, game.button_idle, "_1_4_08_Solution_SmileyFace");
        button_1_4_09 = new MyButton(game, game.button_idle, "_1_4_09_Demo_Text");
        button_1_4_10 = new MyButton(game, game.button_idle, "_1_4_10_Solution_WordCloud");
        button_1_4_11 = new MyButton(game, game.button_idle, "_1_4_11_Solution_CyclicOverlap");

        orthographicCamera = new OrthographicCamera();
        orthographicCamera.setToOrtho(false, defaultWidth, defaultHeight);
        viewport = new ScreenViewport(orthographicCamera);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);

        orthographicCamera.update();
        game.batch.setProjectionMatrix(orthographicCamera.combined);
        game.func.getTouchPos().set(Gdx.input.getX(), Gdx.input.getY(), 0);
        orthographicCamera.unproject(game.func.getTouchPos());
        orthographicCamera.position.x += moveSpeedXNegative + moveSpeedXPositive;
        orthographicCamera.position.y += moveSpeedYNegative + moveSpeedYPositive;

        game.batch.begin();
        game.func.drawButton(button_1_2_01);
        game.func.drawButton(button_1_3_01);
        game.func.drawButton(button_1_3_02);
        game.func.drawButton(button_1_3_03);
        game.func.drawButton(button_1_3_04);
        game.func.drawButton(button_1_3_05);
        game.func.drawButton(button_1_3_06);
        game.func.drawButton(button_1_3_07);
        game.func.drawButton(button_1_3_08);
        game.func.drawButton(button_1_3_09);
        game.func.drawButton(button_1_4_01);
        game.func.drawButton(button_1_4_02);
        game.func.drawButton(button_1_4_03);
        game.func.drawButton(button_1_4_04);
        game.func.drawButton(button_1_4_05);
        game.func.drawButton(button_1_4_06);
        game.func.drawButton(button_1_4_07);
        game.func.drawButton(button_1_4_08);
        game.func.drawButton(button_1_4_09);
        game.func.drawButton(button_1_4_10);
        game.func.drawButton(button_1_4_11);
        game.batch.end();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        game.func.onTouchDownRect(button_1_2_01);
        game.func.onTouchDownRect(button_1_3_01);
        game.func.onTouchDownRect(button_1_3_02);
        game.func.onTouchDownRect(button_1_3_03);
        game.func.onTouchDownRect(button_1_3_04);
        game.func.onTouchDownRect(button_1_3_05);
        game.func.onTouchDownRect(button_1_3_06);
        game.func.onTouchDownRect(button_1_3_07);
        game.func.onTouchDownRect(button_1_3_08);
        game.func.onTouchDownRect(button_1_3_09);
        game.func.onTouchDownRect(button_1_4_01);
        game.func.onTouchDownRect(button_1_4_02);
        game.func.onTouchDownRect(button_1_4_03);
        game.func.onTouchDownRect(button_1_4_04);
        game.func.onTouchDownRect(button_1_4_05);
        game.func.onTouchDownRect(button_1_4_06);
        game.func.onTouchDownRect(button_1_4_07);
        game.func.onTouchDownRect(button_1_4_08);
        game.func.onTouchDownRect(button_1_4_09);
        game.func.onTouchDownRect(button_1_4_10);
        game.func.onTouchDownRect(button_1_4_11);
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        game.func.onHover(button_1_2_01);
        game.func.onHover(button_1_3_01);
        game.func.onHover(button_1_3_02);
        game.func.onHover(button_1_3_03);
        game.func.onHover(button_1_3_04);
        game.func.onHover(button_1_3_05);
        game.func.onHover(button_1_3_06);
        game.func.onHover(button_1_3_07);
        game.func.onHover(button_1_3_08);
        game.func.onHover(button_1_3_09);
        game.func.onHover(button_1_4_01);
        game.func.onHover(button_1_4_02);
        game.func.onHover(button_1_4_03);
        game.func.onHover(button_1_4_04);
        game.func.onHover(button_1_4_05);
        game.func.onHover(button_1_4_06);
        game.func.onHover(button_1_4_07);
        game.func.onHover(button_1_4_08);
        game.func.onHover(button_1_4_09);
        game.func.onHover(button_1_4_10);
        game.func.onHover(button_1_4_11);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        game.func.onTouchUpRect(button_1_2_01, this, new UdacityScreen(game));
        game.func.onTouchUpRect(button_1_3_01, this, new PointDrawing(game));
        game.func.onTouchUpRect(button_1_3_02, this, new Starfield(game));
        game.func.onTouchUpRect(button_1_3_03, this, new DrawingLines(game));
        game.func.onTouchUpRect(button_1_3_04, this, new ConnectTheDots(game));
        game.func.onTouchUpRect(button_1_3_05, this, new DrawASpiral(game));
        game.func.onTouchUpRect(button_1_3_06, this, new DrawingRectangles(game));
        game.func.onTouchUpRect(button_1_3_07, this, new RectangularFlower(game));
        game.func.onTouchUpRect(button_1_3_08, this, new DrawTheCantorGasket(game));
        game.func.onTouchUpRect(button_1_3_09, this, new DragonCurve(game));
        game.func.onTouchUpRect(button_1_4_01, this, new CirclesAndArcs(game));
        game.func.onTouchUpRect(button_1_4_02, this, new StickFigure(game));
        game.func.onTouchUpRect(button_1_4_03, this, new OrthographicProjection(game));
        game.func.onTouchUpRect(button_1_4_04, this, new Closeup(game));
        game.func.onTouchUpRect(button_1_4_05, this, new OrthographicCameraExercise(game));
        game.func.onTouchUpRect(button_1_4_06, this, new ViewportsDemo(game));
        game.func.onTouchUpRect(button_1_4_07, this, new ViewportsExercise(game));
        game.func.onTouchUpRect(button_1_4_08, this, new SmileyFace(game));
        game.func.onTouchUpRect(button_1_4_09, this, new TextDemo(game));
        game.func.onTouchUpRect(button_1_4_10, this, new WordCloud(game));
        game.func.onTouchUpRect(button_1_4_11, this, new CyclicOverlap(game));
        return true;
    }

    @Override
    public void resize(int width, int height) {
        defaultWidth = width;
        defaultHeight = height;
        game.func.reposition(button_1_2_01, 50, height - 60, 30, 10);
        game.func.reposition(button_1_3_01, 50, height - 120, 30, 10);
        game.func.reposition(button_1_3_02, 50, height - 180, 30, 10);
        game.func.reposition(button_1_3_03, 50, height - 240, 30, 10);
        game.func.reposition(button_1_3_04, 50, height - 300, 30, 10);
        game.func.reposition(button_1_3_05, 50, height - 360, 30, 10);
        game.func.reposition(button_1_3_06, 50, height - 420, 30, 10);
        game.func.reposition(button_1_3_07, 50, height - 480, 30, 10);
        game.func.reposition(button_1_3_08, 50, height - 540, 30, 10);
        game.func.reposition(button_1_3_09, 50, height - 600, 30, 10);
        game.func.reposition(button_1_4_01, 50, height - 660, 30, 10);
        game.func.reposition(button_1_4_02, 50, height - 720, 30, 10);
        game.func.reposition(button_1_4_03, 50, height - 780, 30, 10);
        game.func.reposition(button_1_4_04, 50, height - 840, 30, 10);
        game.func.reposition(button_1_4_05, 50, height - 900, 30, 10);
        game.func.reposition(button_1_4_06, 50, height - 960, 30, 10);
        game.func.reposition(button_1_4_07, 50, height - 1020, 30, 10);
        game.func.reposition(button_1_4_08, 50, height - 1080, 30, 10);
        game.func.reposition(button_1_4_09, 50, height - 1140, 30, 10);
        game.func.reposition(button_1_4_10, 50, height - 1200, 30, 10);
        game.func.reposition(button_1_4_11, 50, height - 1260, 30, 10);
        orthographicCamera.setToOrtho(false, defaultWidth, defaultHeight);
        viewport.update(width, height);
    }

    @Override
    public void dispose() {
        game.batch.dispose();
        game.asepriteFont.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
            if (keycode == Input.Keys.W) {
                moveSpeedYNegative = -moveSpeed;
            } else if (keycode == Input.Keys.S) {
                moveSpeedYPositive = moveSpeed;
            } else if (keycode == Input.Keys.A) {
                moveSpeedXPositive = moveSpeed;
            } else if (keycode == Input.Keys.D) {
                moveSpeedXNegative = -moveSpeed;
            }
        }
        return Functions.onEscapeOrBack(this, game, new MainMenuScreen(game), keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
            if (keycode == Input.Keys.W) {
                moveSpeedYNegative = 0;
            } else if (keycode == Input.Keys.S) {
                moveSpeedYPositive = 0;
            } else if (keycode == Input.Keys.A) {
                moveSpeedXPositive = 0;
            } else if (keycode == Input.Keys.D) {
                moveSpeedXNegative = 0;
            }
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
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
}
