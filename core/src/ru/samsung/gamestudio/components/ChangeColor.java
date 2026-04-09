package ru.samsung.gamestudio.components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class ChangeColor {
    int x, y;
    BitmapFont font;

    public ChangeColor(int x, int y){
        this.x = x;
        this.y = y;

        font = new BitmapFont();
        font.getData().setScale(5f);
        font.setColor(Color.WHITE);
    }

    public void draw(Batch batch) {
        font.draw(batch,"Color changed", x,y);
    }
    public void dispose(){
        font.dispose();
    }
}
