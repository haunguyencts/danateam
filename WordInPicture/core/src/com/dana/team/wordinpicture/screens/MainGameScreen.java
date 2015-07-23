package com.dana.team.wordinpicture.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.dana.team.wordinpicture.Config;
import com.dana.team.wordinpicture.models.Monkey;
import com.dana.team.wordinpicture.utils.Animation;
import com.dana.team.wordinpicture.utils.Assets;

public class MainGameScreen implements Screen {

	static final int GAME_READY = 0;
	static final int GAME_RUNNING = 1;
	static final int GAME_PAUSED = 2;
	static final int GAME_LEVEL_END = 3;
	static final int GAME_OVER = 4;

	Game game;

	private static OrthographicCamera guiCam;
	private static SpriteBatch batcher;

	private static Monkey ninjaSticker;

	Vector3 touchPoint;

	public MainGameScreen(Game game) {
		this.game = game;

		guiCam = new OrthographicCamera(Config.SIZE_SCREEN_WIDTH, Config.SIZE_SCREEN_HEIGHT);
		guiCam.position.set(Config.SIZE_SCREEN_WIDTH / 2, Config.SIZE_SCREEN_HEIGHT / 2, 0);
		batcher = new SpriteBatch();

		touchPoint = new Vector3();

		ninjaSticker = new Monkey(720, 400);
	}

	public void update(float deltaTime) {
		ninjaSticker.update(deltaTime);
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
		batcher.draw(Assets.BackgroundGameRegion, 0, 0, 800, 480);
		batcher.end();

		batcher.enableBlending();
		batcher.begin();

		TextureRegion keyFrame = Assets.birdAnim.getKeyFrame(
				ninjaSticker.getStateTime(), Animation.ANIMATION_LOOPING);
		batcher.draw(keyFrame, ninjaSticker.position.x,
				ninjaSticker.position.y, 40, 40);
		
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
