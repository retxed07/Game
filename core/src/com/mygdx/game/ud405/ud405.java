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
import com.mygdx.game.ud405.MiscDemos.CheckerBoard.CheckerboardGame;
import com.mygdx.game.ud405.MiscDemos.ScreenSaver.ScreenSaverScreen;
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
import com.mygdx.game.ud405._1_4_12_Solution_SierpinskiTriangle.SierpinskiTriangle;
import com.mygdx.game.ud405._1_5_01_Demo_CircularMotion.CircularMotion;
import com.mygdx.game.ud405._1_5_02_Solution_ReciprocatingMotion.ReciprocatingMotion;
import com.mygdx.game.ud405._1_5_03_Demo_GamesAndScreens.DemoGame;
import com.mygdx.game.ud405._1_5_04_Solution_ApplicationAdapterToGame.MyScreen;
import com.mygdx.game.ud405._1_5_05_Solution_FPSCounter.FPSCounterScreen;
import com.mygdx.game.ud405._1_5_06_Solution_FallingObjects.FallingObjectsScreen;
import com.mygdx.game.ud405._1_5_07_Solution_ScreenSaver.BallScreen;
import com.mygdx.game.ud405._1_6_08_Demo_AccelerometerInput.AccelerometerAxesScreen;
import com.mygdx.game.ud405._1_6_09_Solution_BubbleLevel.BubbleLevelScreen;
import com.mygdx.game.ud405._1_7_01_Solution_CreateTheIciclesProject.IciclesGame;
import com.mygdx.game.ud405._1_7_02_Solution_AddStubClasses.IciclesScreen;
import com.mygdx.game.ud405._1_8_03_Solution_AddDifficultyLevels.Constants;
import com.mygdx.game.ud405._1_8_03_Solution_AddDifficultyLevels.Icicle;

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
    MyButton button_1_4_12;
    MyButton button_1_5_01;
    MyButton button_1_5_02;
    MyButton button_1_5_03;
    MyButton button_1_5_04;
    MyButton button_1_5_05;
    MyButton button_1_5_06;
    MyButton button_1_5_07;
    MyButton button_1_6_01;
    MyButton button_1_6_02;
    MyButton button_1_6_03;
    MyButton button_1_6_04;
    MyButton button_1_6_05;
    MyButton button_1_6_06;
    MyButton button_1_6_07;
    MyButton button_1_6_08;
    MyButton button_1_6_09;
    MyButton button_1_6_10;
    MyButton button_1_7_01;
    MyButton button_1_7_02;
    MyButton button_1_7_03;
    MyButton button_1_7_04;
    MyButton button_1_7_05;
    MyButton button_1_7_06;
    MyButton button_1_7_07;
    MyButton button_1_7_08;
    MyButton button_1_8_01;
    MyButton button_1_8_02;
    MyButton button_1_8_03;
    MyButton button_1_8_04;
    MyButton button_icicles_complete;
    MyButton button_icicles_prototype;
    MyButton button_screen_saver;
    MyButton button_checkerboard;
    int moveSpeedXNegative = 0;
    int moveSpeedXPositive = 0;
    int moveSpeedYNegative = 0;
    int moveSpeedYPositive = 0;
    int moveSpeed = 20;

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
        button_1_4_12 = new MyButton(game, game.button_idle, "_1_4_12_Solution_SierpinskiTriangle");
        button_1_5_01 = new MyButton(game, game.button_idle, "_1_5_01_Demo_CircularMotion");
        button_1_5_02 = new MyButton(game, game.button_idle, "_1_5_02_Solution_ReciprocatingMotion");
        button_1_5_03 = new MyButton(game, game.button_idle, "_1_5_03_Demo_GamesAndScreens");
        button_1_5_04 = new MyButton(game, game.button_idle, "_1_5_04_Solution_ApplicationAdapterToGame");
        button_1_5_05 = new MyButton(game, game.button_idle, "_1_5_05_Solution_FPSCounter");
        button_1_5_06 = new MyButton(game, game.button_idle, "_1_5_06_Solution_FallingObjects");
        button_1_5_07 = new MyButton(game, game.button_idle, "_1_5_07_Solution_ScreenSaver");
        button_1_6_01 = new MyButton(game, game.button_idle, "_1_6_01_Demo_InputTestbed");
        button_1_6_02 = new MyButton(game, game.button_idle, "_1_6_02_Demo_InputPolling");
        button_1_6_03 = new MyButton(game, game.button_idle, "_1_6_03_Solution_ArrowKeyMovement");
        button_1_6_04 = new MyButton(game, game.button_idle, "_1_6_04_Demo_InputAdapter");
        button_1_6_05 = new MyButton(game, game.button_idle, "_1_6_05_Solution_ResetKey");
        button_1_6_06 = new MyButton(game, game.button_idle, "_1_6_06_Demo_Flick");
        button_1_6_07 = new MyButton(game, game.button_idle, "_1_6_07_Solution_FollowTheFinger");
        button_1_6_08 = new MyButton(game, game.button_idle, "_1_6_08_Demo_AccelerometerInput");
        button_1_6_09 = new MyButton(game, game.button_idle, "_1_6_09_Solution_BubbleLevel");
        button_1_6_10 = new MyButton(game, game.button_idle, "_1_6_10_Solution_AccelerometerMovement");
        button_1_7_01 = new MyButton(game, game.button_idle, "_1_7_01_Solution_CreateTheIciclesProject");
        button_1_7_02 = new MyButton(game, game.button_idle, "_1_7_02_Solution_AddStubClasses");
        button_1_7_03 = new MyButton(game, game.button_idle, "_1_7_03_Solution_TheFirstIcicle");
        button_1_7_04 = new MyButton(game, game.button_idle, "_1_7_04_Solution_DrawThePlayer");
        button_1_7_05 = new MyButton(game, game.button_idle, "_1_7_05_Solution_ArrowKeyControls");
        button_1_7_06 = new MyButton(game, game.button_idle, "_1_7_06_Solution_AccelerometerControls");
        button_1_7_07 = new MyButton(game, game.button_idle, "_1_7_07_Solution_AddTheIcicles");
        button_1_7_08 = new MyButton(game, game.button_idle, "_1_7_08_Solution_RemoveStaleIcicles");
        button_1_8_01 = new MyButton(game, game.button_idle, "_1_8_01_Solution_IcicleHeadCollisionDetection");
        button_1_8_02 = new MyButton(game, game.button_idle, "_1_8_02_Solution_AddTheHUD");
        button_1_8_03 = new MyButton(game, game.button_idle, "_1_8_03_Solution_AddDifficultyLevels");
        button_1_8_04 = new MyButton(game, game.button_idle, "_1_8_04_Solution_AddDifficultySelectScreen");
        button_icicles_complete = new MyButton(game, game.button_idle, "IciclesComplete");
        button_icicles_prototype = new MyButton(game, game.button_idle, "IciclesPrototype");
        button_screen_saver = new MyButton(game, game.button_idle, "ScreenSaver");
        button_checkerboard = new MyButton(game, game.button_idle, "CheckerBoard");

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
        game.func.drawButton(button_1_4_12);
        game.func.drawButton(button_1_5_01);
        game.func.drawButton(button_1_5_02);
        game.func.drawButton(button_1_5_03);
        game.func.drawButton(button_1_5_04);
        game.func.drawButton(button_1_5_05);
        game.func.drawButton(button_1_5_06);
        game.func.drawButton(button_1_5_07);
        game.func.drawButton(button_1_6_01);
        game.func.drawButton(button_1_6_02);
        game.func.drawButton(button_1_6_03);
        game.func.drawButton(button_1_6_04);
        game.func.drawButton(button_1_6_05);
        game.func.drawButton(button_1_6_06);
        game.func.drawButton(button_1_6_07);
        game.func.drawButton(button_1_6_08);
        game.func.drawButton(button_1_6_09);
        game.func.drawButton(button_1_6_10);
        game.func.drawButton(button_1_7_01);
        game.func.drawButton(button_1_7_02);
        game.func.drawButton(button_1_7_03);
        game.func.drawButton(button_1_7_04);
        game.func.drawButton(button_1_7_05);
        game.func.drawButton(button_1_7_06);
        game.func.drawButton(button_1_7_07);
        game.func.drawButton(button_1_7_08);
        game.func.drawButton(button_1_8_01);
        game.func.drawButton(button_1_8_02);
        game.func.drawButton(button_1_8_03);
        game.func.drawButton(button_1_8_04);
        game.func.drawButton(button_icicles_complete);
        game.func.drawButton(button_icicles_prototype);
        game.func.drawButton(button_screen_saver);
        game.func.drawButton(button_checkerboard);
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
        game.func.onTouchDownRect(button_1_4_12);
        game.func.onTouchDownRect(button_1_5_01);
        game.func.onTouchDownRect(button_1_5_02);
        game.func.onTouchDownRect(button_1_5_03);
        game.func.onTouchDownRect(button_1_5_04);
        game.func.onTouchDownRect(button_1_5_05);
        game.func.onTouchDownRect(button_1_5_06);
        game.func.onTouchDownRect(button_1_5_07);
        game.func.onTouchDownRect(button_1_6_01);
        game.func.onTouchDownRect(button_1_6_02);
        game.func.onTouchDownRect(button_1_6_03);
        game.func.onTouchDownRect(button_1_6_04);
        game.func.onTouchDownRect(button_1_6_05);
        game.func.onTouchDownRect(button_1_6_06);
        game.func.onTouchDownRect(button_1_6_07);
        game.func.onTouchDownRect(button_1_6_08);
        game.func.onTouchDownRect(button_1_6_09);
        game.func.onTouchDownRect(button_1_6_10);
        game.func.onTouchDownRect(button_1_7_01);
        game.func.onTouchDownRect(button_1_7_02);
        game.func.onTouchDownRect(button_1_7_03);
        game.func.onTouchDownRect(button_1_7_04);
        game.func.onTouchDownRect(button_1_7_05);
        game.func.onTouchDownRect(button_1_7_06);
        game.func.onTouchDownRect(button_1_7_07);
        game.func.onTouchDownRect(button_1_7_08);
        game.func.onTouchDownRect(button_1_8_01);
        game.func.onTouchDownRect(button_1_8_02);
        game.func.onTouchDownRect(button_1_8_03);
        game.func.onTouchDownRect(button_1_8_04);
        game.func.onTouchDownRect(button_icicles_complete);
        game.func.onTouchDownRect(button_icicles_prototype);
        game.func.onTouchDownRect(button_screen_saver);
        game.func.onTouchDownRect(button_checkerboard);
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
        game.func.onHover(button_1_4_12);
        game.func.onHover(button_1_5_01);
        game.func.onHover(button_1_5_02);
        game.func.onHover(button_1_5_03);
        game.func.onHover(button_1_5_04);
        game.func.onHover(button_1_5_05);
        game.func.onHover(button_1_5_06);
        game.func.onHover(button_1_5_07);
        game.func.onHover(button_1_6_01);
        game.func.onHover(button_1_6_02);
        game.func.onHover(button_1_6_03);
        game.func.onHover(button_1_6_04);
        game.func.onHover(button_1_6_05);
        game.func.onHover(button_1_6_06);
        game.func.onHover(button_1_6_07);
        game.func.onHover(button_1_6_08);
        game.func.onHover(button_1_6_09);
        game.func.onHover(button_1_6_10);
        game.func.onHover(button_1_7_01);
        game.func.onHover(button_1_7_02);
        game.func.onHover(button_1_7_03);
        game.func.onHover(button_1_7_04);
        game.func.onHover(button_1_7_05);
        game.func.onHover(button_1_7_06);
        game.func.onHover(button_1_7_07);
        game.func.onHover(button_1_7_08);
        game.func.onHover(button_1_8_01);
        game.func.onHover(button_1_8_02);
        game.func.onHover(button_1_8_03);
        game.func.onHover(button_1_8_04);
        game.func.onHover(button_icicles_complete);
        game.func.onHover(button_icicles_prototype);
        game.func.onHover(button_screen_saver);
        game.func.onHover(button_checkerboard);
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
        game.func.onTouchUpRect(button_1_4_12, this, new SierpinskiTriangle(game));
        game.func.onTouchUpRect(button_1_5_01, this, new CircularMotion(game));
        game.func.onTouchUpRect(button_1_5_02, this, new ReciprocatingMotion(game));
        game.func.onTouchUpRect(button_1_5_03, this, new DemoGame(game));
        game.func.onTouchUpRect(button_1_5_04, this, new MyScreen(game));
        game.func.onTouchUpRect(button_1_5_05, this, new FPSCounterScreen(game));
        game.func.onTouchUpRect(button_1_5_06, this, new FallingObjectsScreen(game));
        game.func.onTouchUpRect(button_1_5_07, this, new BallScreen(game));
        game.func.onTouchUpRect(button_1_6_01, this, new com.mygdx.game.ud405._1_6_01_Demo_InputTestbed.BallScreen(game));
        game.func.onTouchUpRect(button_1_6_02, this, new com.mygdx.game.ud405._1_6_02_Demo_InputPolling.BallScreen(game));
        game.func.onTouchUpRect(button_1_6_03, this, new com.mygdx.game.ud405._1_6_03_Solution_ArrowKeyMovement.BallScreen(game));
        game.func.onTouchUpRect(button_1_6_04, this, new com.mygdx.game.ud405._1_6_04_Demo_InputAdapter.BallScreen(game));
        game.func.onTouchUpRect(button_1_6_05, this, new com.mygdx.game.ud405._1_6_05_Solution_ResetKey.BallScreen(game));
        game.func.onTouchUpRect(button_1_6_06, this, new com.mygdx.game.ud405._1_6_06_Demo_Flick.BallScreen(game));
        game.func.onTouchUpRect(button_1_6_07, this, new com.mygdx.game.ud405._1_6_07_Solution_FollowTheFinger.BallScreen(game));
        game.func.onTouchUpRect(button_1_6_08, this, new AccelerometerAxesScreen(game));
        game.func.onTouchUpRect(button_1_6_09, this, new BubbleLevelScreen(game));
        game.func.onTouchUpRect(button_1_6_10, this, new com.mygdx.game.ud405._1_6_10_Solution_AccelerometerMovement.BallScreen(game));
        game.func.onTouchUpRect(button_1_7_01, this, new IciclesGame(game));
        game.func.onTouchUpRect(button_1_7_02, this, new IciclesScreen(game));
        game.func.onTouchUpRect(button_1_7_03, this, new com.mygdx.game.ud405._1_7_03_Solution_TheFirstIcicle.IciclesScreen(game));
        game.func.onTouchUpRect(button_1_7_04, this, new com.mygdx.game.ud405._1_7_04_Solution_DrawThePlayer.IciclesScreen(game));
        game.func.onTouchUpRect(button_1_7_05, this, new com.mygdx.game.ud405._1_7_05_Solution_ArrowKeyControls.IciclesScreen(game));
        game.func.onTouchUpRect(button_1_7_06, this, new com.mygdx.game.ud405._1_7_06_Solution_AccelerometerControls.IciclesScreen(game));
        game.func.onTouchUpRect(button_1_7_07, this, new com.mygdx.game.ud405._1_7_07_Solution_AddTheIcicles.IciclesScreen(game));
        game.func.onTouchUpRect(button_1_7_08, this, new com.mygdx.game.ud405._1_7_08_Solution_RemoveStaleIcicles.IciclesScreen(game));
        game.func.onTouchUpRect(button_1_8_01, this, new com.mygdx.game.ud405._1_8_01_Solution_IcicleHeadCollisionDetection.IciclesScreen(game));
        game.func.onTouchUpRect(button_1_8_02, this, new com.mygdx.game.ud405._1_8_02_Solution_AddTheHUD.IciclesScreen(game));
        game.func.onTouchUpRect(button_1_8_03, this, new com.mygdx.game.ud405._1_8_03_Solution_AddDifficultyLevels.IciclesScreen(game, Constants.Difficulty.HARD));
        game.func.onTouchUpRect(button_1_8_04, this, new com.mygdx.game.ud405._1_8_04_Solution_AddDifficultySelectScreen.IciclesScreen(game, com.mygdx.game.ud405._1_8_04_Solution_AddDifficultySelectScreen.Constants.Difficulty.HARD));
        game.func.onTouchUpRect(button_icicles_complete, this, new com.mygdx.game.ud405.IciclesComplete.IciclesScreen(game, com.mygdx.game.ud405.IciclesComplete.Constants.Difficulty.HARD));
        game.func.onTouchUpRect(button_icicles_prototype, this, new com.mygdx.game.ud405.MiscDemos.IciclesPrototype.IciclesScreen(game, com.mygdx.game.ud405.MiscDemos.IciclesPrototype.Constants.Difficulty.HARD));
        game.func.onTouchUpRect(button_screen_saver, this, new ScreenSaverScreen(game));
        game.func.onTouchUpRect(button_checkerboard, this, new CheckerboardGame(game));
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
        game.func.reposition(button_1_4_12, 50, height - 1320, 30, 10);
        game.func.reposition(button_1_5_01, 50, height - 1380, 30, 10);
        game.func.reposition(button_1_5_02, 50, height - 1440, 30, 10);
        game.func.reposition(button_1_5_03, 50, height - 1500, 30, 10);
        game.func.reposition(button_1_5_04, 50, height - 1560, 30, 10);
        game.func.reposition(button_1_5_05, 50, height - 1620, 30, 10);
        game.func.reposition(button_1_5_06, 50, height - 1680, 30, 10);
        game.func.reposition(button_1_5_07, 50, height - 1740, 30, 10);
        game.func.reposition(button_1_6_01, 50, height - 1800, 30, 10);
        game.func.reposition(button_1_6_02, 50, height - 1860, 30, 10);
        game.func.reposition(button_1_6_03, 50, height - 1920, 30, 10);
        game.func.reposition(button_1_6_04, 50, height - 1980, 30, 10);
        game.func.reposition(button_1_6_05, 50, height - 2040, 30, 10);
        game.func.reposition(button_1_6_06, 50, height - 2100, 30, 10);
        game.func.reposition(button_1_6_07, 50, height - 2160, 30, 10);
        game.func.reposition(button_1_6_08, 50, height - 2220, 30, 10);
        game.func.reposition(button_1_6_09, 50, height - 2280, 30, 10);
        game.func.reposition(button_1_6_10, 50, height - 2340, 30, 10);
        game.func.reposition(button_1_7_01, 50, height - 2400, 30, 10);
        game.func.reposition(button_1_7_02, 50, height - 2460, 30, 10);
        game.func.reposition(button_1_7_03, 50, height - 2520, 30, 10);
        game.func.reposition(button_1_7_04, 50, height - 2580, 30, 10);
        game.func.reposition(button_1_7_05, 50, height - 2640, 30, 10);
        game.func.reposition(button_1_7_06, 50, height - 2700, 30, 10);
        game.func.reposition(button_1_7_07, 50, height - 2760, 30, 10);
        game.func.reposition(button_1_7_08, 50, height - 2820, 30, 10);
        game.func.reposition(button_1_8_01, 50, height - 2880, 30, 10);
        game.func.reposition(button_1_8_02, 50, height - 2940, 30, 10);
        game.func.reposition(button_1_8_03, 50, height - 3000, 30, 10);
        game.func.reposition(button_1_8_04, 50, height - 3060, 30, 10);
        game.func.reposition(button_icicles_complete, 50, height - 3120, 30, 10);
        game.func.reposition(button_icicles_prototype, 50, height - 3180, 30, 10);
        game.func.reposition(button_screen_saver, 50, height - 3240, 30, 10);
        game.func.reposition(button_checkerboard, 50, height - 3300, 30, 10);
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
