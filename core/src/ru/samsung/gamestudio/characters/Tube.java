package ru.samsung.gamestudio.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import ru.samsung.gamestudio.characters.Bird;
import ru.samsung.gamestudio.components.PointCounter;

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
    boolean isPointReceived;
    int gamePoints;

    public Tube(int tubeCount, int tubeIdx){
        random = new Random();
        textureUpperTube = new Texture("tubes/tube_flipped.png");
        textureDownTube = new Texture("tubes/tube.png");

        gapY = gapHeight/2 + padding + random.nextInt(SCR_HEIGHT - 2 * (padding + gapHeight/2));
        distanceBetweenTubes = (SCR_WIDTH + width) / (tubeCount - 1);
        x = distanceBetweenTubes * tubeIdx + SCR_WIDTH;
    }
    public void draw(Batch batch) {
        batch.draw(textureUpperTube, x, gapY + gapHeight/ 2, width,height);
        batch.draw(textureDownTube, x, gapY - gapHeight/ 2 - height, width,height);
    }
    public void dispose(){
        textureUpperTube.dispose();
        textureDownTube.dispose();
    }
    public void  move(){
        x -= speed;
        if(x < -width){
            isPointReceived = false;
            x = SCR_WIDTH + distanceBetweenTubes;
            gapY = gapHeight/ 2 + padding + random.nextInt(SCR_HEIGHT - 2 * (padding + gapHeight/ 2));
        }
    }
    public boolean isHit(Bird bird) {
        if (bird.y <= gapY - gapHeight / 2 && bird.x + bird.width >= x && bird.x <= x + width)
            return true;
        if (bird.y + bird.height >= gapY + gapHeight / 2 && bird.x + bird.width >= x && bird.x <= x + width)
            return true;
        return false;
    }
    public boolean needAddPoint(Bird bird) {
        return !isPointReceived && bird.x >= x + width;
    }
    public void setPointReceived() {
        isPointReceived = true;
    }

}
