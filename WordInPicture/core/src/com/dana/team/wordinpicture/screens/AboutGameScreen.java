package com.dana.team.wordinpicture.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.dana.team.wordinpicture.Config;
import com.dana.team.wordinpicture.utils.Assets;

public class AboutGameScreen implements Screen {

	Game game;

	private static OrthographicCamera guiCam;
	private static SpriteBatch batcher;

	Vector3 touchPoint;

	public AboutGameScreen(Game game) {
		this.game = game;

		guiCam = new OrthographicCamera(Config.SIZE_SCREEN_WIDTH, Config.SIZE_SCREEN_HEIGHT);
		guiCam.position.set(Config.SIZE_SCREEN_WIDTH / 2, Config.SIZE_SCREEN_HEIGHT / 2, 0);
		batcher = new SpriteBatch();

		touchPoint = new Vector3();

	}

	public void update(float deltaTime) {
	}

	public void draw(float deltaTime) {
		GL20 gl = Gdx.gl;
		gl.glClearColor(1, 0, 0, 1);
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		guiCam.update();
		batcher.setProjectionMatrix(guiCam.combined);

		/* Draw background */
		batcher.disableBlending();
		batcher.begin();
		batcher.draw(Assets.BackgroundRegion, 0, 0, 800, 480);
		batcher.end();

		batcher.enableBlending();

		batcher.begin();
		Assets.font.draw(batcher, "This is About Screen", 250, 240);
		batcher.end();

	}

	@Override
	public void render(float delta) {
		update(delta);
		draw(delta);
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
		// Settings.save();
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

}
