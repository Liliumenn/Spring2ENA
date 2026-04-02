package ru.samsung.gamestudio.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

import static ru.samsung.gamestudio.MyGdxGame.SCR_HEIGHT;

public class Bird {
    int x, y;
    int speed;


    int jumpHeight;
    final int maxHeightOfJump = 200;
    boolean jump;
    int frameCounter = 0;
    Texture[] framesArray;
    int width;
    int height;

    public void onClick(){
        jump = true;
        jumpHeight = maxHeightOfJump + y;
    }


    public Bird(int x, int y, int speed, int width, int height){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;

        framesArray = new Texture[]{
                new Texture("birdTiles/bird0.png"),
                new Texture("birdTiles/bird1.png"),
                new Texture("birdTiles/bird2.png"),
                new Texture("birdTiles/bird1.png"),
        };
    }

    public void fly(){
        if(y >= jumpHeight){
            jump = false;
        }
        if(jump){
            y += speed;
        } else {
            y -= speed;
        }
    }

    public void draw(Batch batch){
        int frameMultiplier = 10;
        batch.draw(framesArray[frameCounter/frameMultiplier], x, y, width, height);
        if (frameCounter++ == framesArray.length * frameMultiplier - 1) frameCounter = 0;
    }

    public void dispose(){
    }

    public boolean isInField() {
        if (y + height < 0) return false;
        if (y > SCR_HEIGHT) return false;
        return true;
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
}
