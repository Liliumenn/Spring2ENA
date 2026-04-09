package ru.samsung.gamestudio;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.samsung.gamestudio.characters.Bird;
import ru.samsung.gamestudio.characters.Tube;
import ru.samsung.gamestudio.components.MovingBackground;
import ru.samsung.gamestudio.components.PointCounter;
import ru.samsung.gamestudio.screens.ScreenColor;
import ru.samsung.gamestudio.screens.ScreenGame;
import ru.samsung.gamestudio.screens.ScreenMenu;
import ru.samsung.gamestudio.screens.ScreenRestart;

public class MyGdxGame extends Game {
	public SpriteBatch batch;
	public OrthographicCamera camera;

	public static final int SCR_WIDTH = 1280;
	public static final int SCR_HEIGHT = 720;
	public ScreenRestart screenRestart;
	public ScreenGame screenGame;
	public ScreenMenu screenMenu;
	public ScreenColor screenColor;

	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);

		screenMenu = new ScreenMenu(this);
		screenColor = new ScreenColor(this);
		screenGame = new ScreenGame(this);
		screenRestart = new ScreenRestart(this);
		setScreen(screenMenu);
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

}

