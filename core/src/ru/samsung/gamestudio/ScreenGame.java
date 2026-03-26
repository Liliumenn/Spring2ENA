package ru.samsung.gamestudio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

import static ru.samsung.gamestudio.MyGdxGame.SCR_HEIGHT;
import static ru.samsung.gamestudio.MyGdxGame.SCR_WIDTH;

public class ScreenGame implements Screen {
    final int  pointCounterMarginTop = 60;
    final int  pointCounterMarginRight = 400;
    MyGdxGame myGdxGame;
    Bird bird;
    int tubeCount;
    Tube[] tubes;
    boolean isGameOver;
    int gamePoints;
    PointCounter pointCounter;
    MovingBackground background;


    ScreenGame(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        tubeCount = 3;
        initTubes();
        background = new MovingBackground();
        this.bird = new Bird(0,0,5,200,200);
        pointCounter = new PointCounter(SCR_WIDTH - pointCounterMarginRight, SCR_HEIGHT - pointCounterMarginTop);

    }

    @Override
    public void show() {
        isGameOver = false;
        gamePoints = 0;
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.justTouched()) {
            bird.onClick();
        }
        background.move();
        bird.fly();
        for(Tube tube : tubes){
            tube.move();
            if (tube.isHit(bird)) {
                System.out.println("HIT");
                isGameOver = true;
            } else if (tube.needAddPoint(bird)) {
                gamePoints += 1;
                tube.setPointReceived();
                System.out.println(gamePoints);
            }
        }
        if (!bird.isInField()) {
            System.out.println("not in field");
            isGameOver = true;
        }
        for(Tube tube : tubes) tube.move();

        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();

        background.draw(myGdxGame.batch);
        bird.draw(myGdxGame.batch);
        for (Tube tube : tubes) tube.draw(myGdxGame.batch);
        pointCounter.draw(myGdxGame.batch, gamePoints);

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
        bird.dispose();
        background.dispose();
        pointCounter.dispose();
        for (int i = 0; i < tubeCount; i++) {
            tubes[i].dispose();
        }
    }
    void initTubes() {
        tubes = new Tube[tubeCount];
        for (int i = 0; i < tubeCount; i++) {
            tubes[i] = new Tube(tubeCount, i);
        }
    }

}
