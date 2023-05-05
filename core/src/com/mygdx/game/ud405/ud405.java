package com.mygdx.game.ud405;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
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

public class ud405 extends InputAdapter implements Screen {
    SplashScreen game;
    MyButton button_1_2_01, button_1_3_01, button_1_3_02, button_1_3_03, button_1_3_04,
            button_1_3_05, button_1_3_06, button_1_3_07, button_1_3_08, button_1_3_09,
            button_1_4_01, button_1_4_02, button_1_4_03, button_1_4_04, button_1_4_05,
            button_1_4_06;
    OrthographicCamera orthographicCamera;
    Viewport viewport;
    int screenWidth = 800;
    int screenHeight = 480;
    int moveSpeed = 3;

    public ud405(SplashScreen game) {
        this.game = game;

        button_1_2_01 = new MyButton();
        button_1_2_01.setTexture(game.button_idle);
        button_1_2_01.setText("_1_2_01_Demo_GettingStartedWithLibGDX");
        button_1_2_01.setTextWidth(game, button_1_2_01.getText());

        button_1_3_01 = new MyButton();
        button_1_3_01.setTexture(game.button_idle);
        button_1_3_01.setText("_1_3_01_Demo_DrawingPoints");
        button_1_3_01.setTextWidth(game, button_1_3_01.getText());

        button_1_3_02 = new MyButton();
        button_1_3_02.setTexture(game.button_idle);
        button_1_3_02.setText("_1_3_02_Exercise_DrawAStarfield");
        button_1_3_02.setTextWidth(game, button_1_3_02.getText());

        button_1_3_03 = new MyButton();
        button_1_3_03.setTexture(game.button_idle);
        button_1_3_03.setText("_1_3_03_Demo_DrawingLines");
        button_1_3_03.setTextWidth(game, button_1_3_03.getText());

        button_1_3_04 = new MyButton();
        button_1_3_04.setTexture(game.button_idle);
        button_1_3_04.setText("_1_3_04_Solution_ConnectTheDots");
        button_1_3_04.setTextWidth(game, button_1_3_04.getText());

        button_1_3_05 = new MyButton();
        button_1_3_05.setTexture(game.button_idle);
        button_1_3_05.setText("_1_3_05_Solution_DrawASpiral");
        button_1_3_05.setTextWidth(game, button_1_3_05.getText());

        button_1_3_06 = new MyButton();
        button_1_3_06.setTexture(game.button_idle);
        button_1_3_06.setText("_1_3_06_Demo_DrawingRectangles");
        button_1_3_06.setTextWidth(game, button_1_3_06.getText());

        button_1_3_07 = new MyButton();
        button_1_3_07.setTexture(game.button_idle);
        button_1_3_07.setText("_1_3_07_Solution_RectangularFlower");
        button_1_3_07.setTextWidth(game, button_1_3_07.getText());

        button_1_3_08 = new MyButton();
        button_1_3_08.setTexture(game.button_idle);
        button_1_3_08.setText("_1_3_08_Solution_DrawTheCantorGasket");
        button_1_3_08.setTextWidth(game, button_1_3_08.getText());

        button_1_3_09 = new MyButton();
        button_1_3_09.setTexture(game.button_idle);
        button_1_3_09.setText("_1_3_09_Solution_DrawTheDragonCurve");
        button_1_3_09.setTextWidth(game, button_1_3_09.getText());

        button_1_4_01 = new MyButton();
        button_1_4_01.setTexture(game.button_idle);
        button_1_4_01.setText("_1_4_01_Demo_CirclesAndArcs");
        button_1_4_01.setTextWidth(game, button_1_4_01.getText());

        button_1_4_02 = new MyButton();
        button_1_4_02.setTexture(game.button_idle);
        button_1_4_02.setText("_1_4_02_Solution_StickFigure");
        button_1_4_02.setTextWidth(game, button_1_4_02.getText());

        button_1_4_03 = new MyButton();
        button_1_4_03.setTexture(game.button_idle);
        button_1_4_03.setText("_1_4_03_Demo_Cameras");
        button_1_4_03.setTextWidth(game, button_1_4_03.getText());

        button_1_4_04 = new MyButton();
        button_1_4_04.setTexture(game.button_idle);
        button_1_4_04.setText("_1_4_04_Demo_SolarSystem");
        button_1_4_04.setTextWidth(game, button_1_4_04.getText());

        button_1_4_05 = new MyButton();
        button_1_4_05.setTexture(game.button_idle);
        button_1_4_05.setText("_1_4_05_Solution_OrthographicCamera");
        button_1_4_05.setTextWidth(game, button_1_4_05.getText());

        button_1_4_06 = new MyButton();
        button_1_4_06.setTexture(game.button_idle);
        button_1_4_06.setText("_1_4_06_Demo_Viewports");
        button_1_4_06.setTextWidth(game, button_1_4_06.getText());

        orthographicCamera = new OrthographicCamera();
        orthographicCamera.setToOrtho(false, screenWidth, screenHeight);
        viewport = new ScreenViewport(orthographicCamera);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);

        orthographicCamera.update();
        game.batch.setProjectionMatrix(orthographicCamera.combined);
        game.func.getTouchPos().set(Gdx.input.getX(), Gdx.input.getY(), 0);
        orthographicCamera.unproject(game.func.getTouchPos());

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
        game.batch.end();

        game.func.buttonListener(button_1_2_01, this, new UdacityScreen(game));
        game.func.buttonListener(button_1_3_01, this, new PointDrawing(game));
        game.func.buttonListener(button_1_3_02, this, new Starfield(game));
        game.func.buttonListener(button_1_3_03, this, new DrawingLines(game));
        game.func.buttonListener(button_1_3_04, this, new ConnectTheDots(game));
        game.func.buttonListener(button_1_3_05, this, new DrawASpiral(game));
        game.func.buttonListener(button_1_3_06, this, new DrawingRectangles(game));
        game.func.buttonListener(button_1_3_07, this, new RectangularFlower(game));
        game.func.buttonListener(button_1_3_08, this, new DrawTheCantorGasket(game));
        game.func.buttonListener(button_1_3_09, this, new DragonCurve(game));
        game.func.buttonListener(button_1_4_01, this, new CirclesAndArcs(game));
        game.func.buttonListener(button_1_4_02, this, new StickFigure(game));
        game.func.buttonListener(button_1_4_03, this, new OrthographicProjection(game));
        game.func.buttonListener(button_1_4_04, this, new Closeup(game));
        game.func.buttonListener(button_1_4_05, this, new OrthographicCameraExercise(game));
        game.func.buttonListener(button_1_4_06, this, new ViewportsDemo(game));

        Functions.cameraMovement(orthographicCamera, moveSpeed);
//        Functions.onEscapeOrBack(this, game, new MainMenuScreen(game));
    }

    @Override
    public boolean keyDown(int keycode) {
        System.out.println("ud405keydown " + keycode + "|" + Input.Keys.ESCAPE);
        if (keycode == Input.Keys.ESCAPE || keycode == Input.Keys.BACK) {
            game.setScreen(new MainMenuScreen(game));
            return true;
        }
        return true;
    }

    @Override
    public void resize(int width, int height) {
        screenWidth = width;
        screenHeight = height;
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
        orthographicCamera.setToOrtho(false, screenWidth, screenHeight);
        viewport.update(width, height);
    }

    @Override
    public void dispose() {
        game.batch.dispose();
        game.asepriteFont.dispose();
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
