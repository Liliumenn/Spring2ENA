package ru.samsung.gamestudio.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;
import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.characters.Bird;
import ru.samsung.gamestudio.components.ChangeColor;
import ru.samsung.gamestudio.components.MovingBackground;
import ru.samsung.gamestudio.components.TextButton;

public class ScreenColor implements Screen {
    TextButton buttonStart;
    TextButton buttonMenu;

    MyGdxGame myGdxGame;

    MovingBackground background;

    TextButton buttonBlack;
    ChangeColor changeColor;
    public static boolean isBlack;
    boolean showText = false;

    public ScreenColor(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        buttonBlack = new TextButton(50, 500, "Vorona");
        background = new MovingBackground("backgrounds/color_bg.png");
        buttonStart = new TextButton(100, 100, "Start");
        buttonMenu = new TextButton(700, 100, "Menu");
        changeColor = new ChangeColor(800, 700);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Vector3 touch = null;
        if (Gdx.input.justTouched()) {

            touch = myGdxGame.camera.unproject(
                    new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0)
            );
            if (buttonBlack.isHit((int) touch.x, (int) touch.y)) {
                isBlack = true;
                showText = true;
            }
            if (buttonStart.isHit((int) touch.x, (int) touch.y)) {
                myGdxGame.setScreen(myGdxGame.screenGame);
            }
            if (buttonMenu.isHit((int) touch.x, (int) touch.y)) {
                myGdxGame.setScreen(myGdxGame.screenMenu);
            }
        }

        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();
        background.draw(myGdxGame.batch);
        buttonStart.draw(myGdxGame.batch);
        buttonMenu.draw(myGdxGame.batch);
        buttonBlack.draw(myGdxGame.batch);
        if (showText){ changeColor.draw(myGdxGame.batch);}



        myGdxGame.batch.end();
    }

    @Override
    public void resize(int width, int height) {

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

    @Override
    public void dispose() {

    }
}
