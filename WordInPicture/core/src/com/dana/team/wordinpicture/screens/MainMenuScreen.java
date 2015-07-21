package com.dana.team.wordinpicture.screens;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.dana.team.wordinpicture.Config;
import com.dana.team.wordinpicture.models.Bat;
import com.dana.team.wordinpicture.models.Cloud;
import com.dana.team.wordinpicture.utils.Assets;
import com.dana.team.wordinpicture.utils.MainMenuButton;
import com.dana.team.wordinpicture.utils.OverlapTester;

public class MainMenuScreen implements Screen {

	Game game;

	private static OrthographicCamera guiCam;
	private static SpriteBatch batcher;
	Vector3 touchPoint;

	/* Add items */
	private static final int CLOUDS_NUMBER = 3;
	private static final int BATS_NUMBER = 3;
	private static List<Cloud> clouds;
	private static List<Bat> bats;

	private static MainMenuButton playButton;
	private static MainMenuButton galleryButton;
	private static MainMenuButton aboutButton;

	public MainMenuScreen(Game game) {
		this.game = game;

		guiCam = new OrthographicCamera(Config.SIZE_SCREEN_WIDTH, Config.SIZE_SCREEN_HEIGHT);
		guiCam.position.set(Config.SIZE_SCREEN_WIDTH / 2, Config.SIZE_SCREEN_HEIGHT / 2, 0);
		batcher = new SpriteBatch();

		touchPoint = new Vector3();

		initItems();
		float tmp_width = (Assets.mainMenuPlayButtonRegion.getRegionWidth() * 1200 / 1920  - 100);
		float tmp_height = (Assets.mainMenuPlayButtonRegion.getRegionHeight() * 1200 / 1920 - 100);
		playButton = new MainMenuButton(260, 250, tmp_width, tmp_height);
		galleryButton = new MainMenuButton(540, 250, tmp_width, tmp_height);
		
		tmp_width = (Assets.mainMenuAboutButtonRegion.getRegionWidth() * 1200 / 1920  - 30);
		tmp_height = (Assets.mainMenuAboutButtonRegion.getRegionHeight() * 1200 / 1920 - 30);
		aboutButton = new MainMenuButton(760,30 , tmp_width, tmp_height);
	}

	/**
	 * create clouds and bats
	 */
	private void initItems() {
		// clouds
		clouds = new ArrayList<Cloud>();
		for (int i = 0; i < CLOUDS_NUMBER; i++) {
			switch (i) {
			case 1:
				Cloud cloud = new Cloud(20, 400);
				cloud.isRight = false;
				cloud.velocity.set(Cloud.CLOUD_MAX_VELOCITY, 0);
				clouds.add(cloud);
				break;
			case 2:
				cloud = new Cloud(800, 300);
				cloud.isRight = false;
				cloud.velocity.set(Cloud.CLOUD_MAX_VELOCITY, 0);
				clouds.add(cloud);
			case 3:
				cloud = new Cloud(800, 200);
				cloud.isRight = true;
				cloud.velocity.set(-Cloud.CLOUD_MAX_VELOCITY / 2, 0);
				clouds.add(cloud);
				break;

			default:
				break;
			}
		}

		// bats
		bats = new ArrayList<Bat>();
		for (int i = 0; i < BATS_NUMBER; i++) {
			switch (i) {
			case 1:
				Bat bat = new Bat(410, 400, Assets.BatRegion.getRegionWidth() / 3.4f,
						Assets.BatRegion.getRegionHeight() / 3.4f);
				bat.isRight = false;
				bat.angle = 0f;
				bat.fixAngle = 0f;
				bat.interval = 16;
				bats.add(bat);
				break;
			case 2:
				bat = new Bat(100, 250, Assets.BatRegion.getRegionWidth() / 5.0f,
						Assets.BatRegion.getRegionHeight() / 5.0f);
				bat.isRight = false;
				bat.angle = 0f;
				bat.fixAngle = 0f;
				bat.interval = 16;
				bats.add(bat);
			case 3:
				bat = new Bat(700, 140, Assets.BatRegion.getRegionWidth() / 2.4f,
						Assets.BatRegion.getRegionHeight() / 2.4f);
				bat.isRight = false;
				bat.angle = 360f - 20f;
				bat.fixAngle = 360f - 20f;
				bat.interval = 16;
				bats.add(bat);
				break;
			default:
				break;
			}
		}
	}

	public void update(float deltaTime) {
		
		Gdx.app.log("123", "AAAAAA" + deltaTime);
		
		for (Cloud cloud : clouds) {
			cloud.update(deltaTime);
		}
		for (Bat bat : bats) {
			bat.update(deltaTime);
		}

		if (Gdx.input.justTouched()) {
			guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
			
			Gdx.app.log("DEBUG", "touchPoint.x = " + touchPoint.x + " touchPoint.y = " + touchPoint.y);
			
			if (OverlapTester.pointInRectangle(playButton.bounds, touchPoint.x, touchPoint.y)) {
				Gdx.app.log("DEBUG", "Play button touched");
				playButton.isYTransforming = true;
				playButton.isXTransforming = true;
				Assets.playSound(Assets.clickSound);
				game.setScreen(new MainGameScreen(game));
			}
			if (OverlapTester.pointInRectangle(galleryButton.bounds, touchPoint.x, touchPoint.y)) {
				Gdx.app.log("DEBUG", "Gallery button touched");
				galleryButton.isYTransforming = false;
				galleryButton.isXTransforming = true;
				Assets.playSound(Assets.coinSound);
				//game.setScreen(new MainGameScreen(game));
			}
			if (OverlapTester.pointInRectangle(aboutButton.bounds, touchPoint.x, touchPoint.y)) {
				Gdx.app.log("DEBUG", "About button touched");
				Assets.playSound(Assets.clickSound);
				galleryButton.isYTransforming = true;
				galleryButton.isXTransforming = true;
				Assets.playSound(Assets.hitSound);
				game.setScreen(new AboutGameScreen(game));
			}
		}
		playButton.update(deltaTime);
		galleryButton.update(deltaTime);
		aboutButton.update(deltaTime);
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

		for (Cloud cloud : clouds) {
			if (cloud.isRight) {
				batcher.draw(Assets.CloudRegion, cloud.position.x, cloud.position.y, Cloud.CLOUD_WIDTH,
						Cloud.CLOUD_HEIGHT);
			} else {
				batcher.draw(Assets.CloudRegion, cloud.position.x, cloud.position.y, -Cloud.CLOUD_WIDTH / 1.2f,
						Cloud.CLOUD_HEIGHT / 1.2f);
			}
		}

		for (Bat bat : bats) {
			batcher.draw(Assets.BatRegion, bat.bounds.x, bat.bounds.y, bat.bounds.width / 2f, bat.bounds.height / 2f,
					bat.bounds.width, bat.bounds.height, bat.scaleX, bat.scaleY, bat.angle);
		}

		batcher.draw(Assets.mainMenuPlayButtonRegion, playButton.bounds.x, playButton.bounds.y,
				playButton.bounds.width / 2, playButton.bounds.height / 2, playButton.bounds.width,
				playButton.bounds.height, playButton.scaleX, playButton.scaleY, 0f);
		batcher.draw(Assets.mainMenuGalleryButtonRegion, galleryButton.bounds.x, galleryButton.bounds.y,
				galleryButton.bounds.width / 2, galleryButton.bounds.height / 2, galleryButton.bounds.width,
				galleryButton.bounds.height, galleryButton.scaleX, galleryButton.scaleY, 0f);
		batcher.draw(Assets.mainMenuAboutButtonRegion, aboutButton.bounds.x, aboutButton.bounds.y,
				aboutButton.bounds.width / 2, aboutButton.bounds.height / 2, aboutButton.bounds.width,
				aboutButton.bounds.height, aboutButton.scaleX, aboutButton.scaleY, 0f);
		
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
