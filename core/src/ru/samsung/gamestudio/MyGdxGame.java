package ru.samsung.gamestudio;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();

		Texture birdTexture;
		birdTexture = new Texture("bird0.png");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(birdTexture,0, 0);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}

