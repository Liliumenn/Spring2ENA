package ru.samsung.gamestudio.megaga;

public class Megagame {
    MyScreen screen;

    public void setScreen(MyScreen screen) {
        this.screen = screen;
    }

    public void renderScreen(){
        screen.create();
        while(true) {
            screen.render();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Megagame game = new Megagame();
        MyScreen s = new Megascreen();
        game.setScreen(s);
        game.renderScreen();
    }
}
