package ru.samsung.gamestudio;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class ScreenGame implements Screen {

    MyGdxGame myGdxGame;
    Bird bird;
    ScreenGame(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        this.bird = new Bird(0,0,5,200,200);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {


        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();
        this.bird.draw(myGdxGame.batch);
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
