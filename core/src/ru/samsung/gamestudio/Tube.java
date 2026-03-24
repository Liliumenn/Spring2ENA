package ru.samsung.gamestudio;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.Random;

import static ru.samsung.gamestudio.MyGdxGame.SCR_HEIGHT;
import static ru.samsung.gamestudio.MyGdxGame.SCR_WIDTH;

public class Tube {

    Texture textureUpperTube;
    Texture textureDownTube;
    int speed = 10;
    int width = 200;
    int height = 700;
    int gapY;
    int gapHeight = 400;
    Random random;
    int padding = 100;
    int distanceBetweenTubes;
    int x;
    int tubeCount = 3;
    boolean isPointReceived;

    public Tube(int tubeCount, int tubeIdx){
        random = new Random();
        textureUpperTube = new Texture("tubes/tube_flipped.png");
        textureDownTube = new Texture("tubes/tube.png");

        gapY = gapHeight/2 + padding + random.nextInt(SCR_HEIGHT - 2 * (padding + gapHeight/2));
        distanceBetweenTubes = (SCR_WIDTH + width) / (tubeCount - 1);
        x = distanceBetweenTubes * tubeIdx + SCR_WIDTH;
    }
    void draw(Batch batch) {
        batch.draw(textureUpperTube, x, gapY + gapHeight/ 2, width,height);
        batch.draw(textureDownTube, x, gapY - gapHeight/ 2 - height, width,height);
    }
    void dispose(){
        textureUpperTube.dispose();
        textureDownTube.dispose();
    }
    void  move(){
        x -= speed;
        if(x < -width){
            isPointReceived = false;
            x = SCR_WIDTH + distanceBetweenTubes;
            gapY = gapHeight/ 2 + padding + random.nextInt(SCR_HEIGHT - 2 * (padding + gapHeight/ 2));
        }
    }
    public boolean isHit(Bird bird) {
        if (bird.y + bird.height >= gapY + gapHeight / 2 && bird.x + bird.width >= x && bird.x <= x)
            return true;
        return false;
    }
    public boolean needAddPoint(Bird bird) {
        return false;
    }
}
