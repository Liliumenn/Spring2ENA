package ru.samsung.gamestudio;

import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class Tube {

    Texture textureUpperTube;
    Texture textureDownTube;
    int width = 200;
    int height = 700;
    int gapY;
    int gapHeight = 400;
    Random random;

    public Tube(){
        textureUpperTube = new Texture("tubes/tube_flipper.png");
        textureDownTube = new Texture("tubes/tube.png");
        gapY = gapHeight/2 + padding + random.nextInt(SCR_HEIGHT - 2 * (padding + gapHeight/2));
    }
}
