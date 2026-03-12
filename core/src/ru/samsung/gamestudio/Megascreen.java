package ru.samsung.gamestudio;

public class Megascreen implements MyScreen{

    @Override
    public void create() {
        System.out.println("Load sprites");
        System.out.println("Ready to display");
    }

    @Override
    public void render() {
        System.out.println("Drow bird");
        System.out.println("Move bird");
    }
}
