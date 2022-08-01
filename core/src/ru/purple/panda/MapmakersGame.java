package ru.purple.panda;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MapmakersGame extends ApplicationAdapter {
	SpriteBatch batch;
	private MainAsset mainAsset;
	private final KeyboardAdapter inputProcessor = new KeyboardAdapter();
	
	@Override
	public void create () {
		Gdx.input.setInputProcessor(inputProcessor);
		batch = new SpriteBatch();
		mainAsset = new MainAsset(100, 200, "main_asset.png");
	}

	@Override
	public void render () {
		mainAsset.moveTo(inputProcessor.getDirection());
		mainAsset.rotateTo(inputProcessor.getMousePosition());
		System.out.println(inputProcessor.getDirection().x);
		System.out.println(inputProcessor.getDirection().y);
		System.out.println(inputProcessor.getMousePosition().x);
		System.out.println(inputProcessor.getMousePosition().y);

		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		mainAsset.render(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		mainAsset.dispose();
	}
}
