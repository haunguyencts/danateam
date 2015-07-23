package com.dana.team.wordinpicture.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

	public static Texture BackgroundTexture;
	public static TextureRegion BackgroundRegion;

	public static Texture ItemsTexture;

	public static TextureRegion CloudRegion;
	public static TextureRegion BatRegion;

	public static Texture PlayButtonTexture;
	public static TextureRegion mainMenuPlayButtonRegion;
	public static Texture GalleryButtonTexture;
	public static TextureRegion mainMenuGalleryButtonRegion;
	public static Texture AboutButtonTexture;
	public static TextureRegion mainMenuAboutButtonRegion;

	public static Texture BackgroundGameTexture;
	public static TextureRegion BackgroundGameRegion;

	public static Texture GamesTexture;
	public static Animation coinAnim;

	public static Texture ninjaTexture01;
	public static TextureRegion ninjaRegion01;
	public static Texture ninjaTexture02;
	public static TextureRegion ninjaRegion02;
	public static Texture ninjaTexture03;
	public static TextureRegion ninjaRegion03;
	public static Animation ninjaAnim;

	

	public static BitmapFont font;
	public static Music music;
	public static Sound hitSound;
	public static Sound coinSound;
	public static Sound clickSound;
	
	public static Texture newItemsTexture;
	public static Animation birdAnim;
	public static TextureRegion waveInBackgroud;
	

	public static void load() {
		BackgroundTexture = loadTexture("image/menu_background.png");
		BackgroundRegion = new TextureRegion(BackgroundTexture, 0, 0, 1920,
				1200);

		ItemsTexture = loadTexture("image/mainMenuItems.png");
		CloudRegion = new TextureRegion(ItemsTexture, 800, 1000, 985 - 800,
				1098 - 1000);

		BatRegion = new TextureRegion(ItemsTexture, 1600, 411, 1977 - 1600,
				700 - 411);

		PlayButtonTexture = loadTexture("image/menu_play_button.png");
		mainMenuPlayButtonRegion = new TextureRegion(PlayButtonTexture, 0, 0,
				470, 389);

		GalleryButtonTexture = loadTexture("image/menu_gallery_button.png");
		mainMenuGalleryButtonRegion = new TextureRegion(GalleryButtonTexture,
				0, 0, 470, 389);

		AboutButtonTexture = loadTexture("image/menu_about_button.png");
		mainMenuAboutButtonRegion = new TextureRegion(AboutButtonTexture, 0, 0,
				118, 125);

		GamesTexture = loadTexture("image/Items.png");
		coinAnim = new Animation(0.2f, new TextureRegion(GamesTexture, 1230, 0,
				1296 - 1230, 85), new TextureRegion(GamesTexture, 1306, 0,
				1343 - 1306, 85), new TextureRegion(GamesTexture, 1366, 0,
				1402 - 1366, 85), new TextureRegion(GamesTexture, 1410, 0,
				1475 - 1410, 85));

		BackgroundGameTexture = loadTexture("image/background-maingame.png");
		BackgroundGameRegion = new TextureRegion(BackgroundGameTexture, 0, 0,
				1920, 1200);

		ninjaTexture01 = loadTexture("image/ninja_01.png");
		ninjaRegion01 = new TextureRegion(ninjaTexture01, 0, 0, 128, 128);
		ninjaTexture02 = loadTexture("image/ninja_02.png");
		ninjaRegion02 = new TextureRegion(ninjaTexture02, 0, 0, 128, 128);
		ninjaTexture03 = loadTexture("image/ninja_03.png");
		ninjaRegion03 = new TextureRegion(ninjaTexture03, 0, 0, 128, 128);
		ninjaAnim = new Animation(0.2f, ninjaRegion01, ninjaRegion02,
				ninjaRegion03);

		font = new BitmapFont(Gdx.files.internal("data/font.fnt"),
				Gdx.files.internal("data/font.png"), false);
		music = Gdx.audio.newMusic(Gdx.files.internal("data/music.wav"));
		music.setLooping(true);
		music.setVolume(0.5f);

		newItemsTexture = loadTexture("image/new_items.png");
		
		birdAnim = new Animation(0.2f, 
				new TextureRegion(newItemsTexture, 20, 340, 134 - 20, 430 - 340), 
				new TextureRegion(newItemsTexture, 140, 340, 265 - 140, 430 -340 ),
				new TextureRegion(newItemsTexture, 265, 340, 385 - 265, 430 - 340), 
				new TextureRegion(newItemsTexture, 385, 340, 505 - 385, 430 - 340));
		
		waveInBackgroud = new TextureRegion(newItemsTexture, 90, 750, 1500 - 90, 960 - 750 );

		hitSound = Gdx.audio.newSound(Gdx.files.internal("data/hit.wav"));
		coinSound = Gdx.audio.newSound(Gdx.files.internal("data/coin.mp3"));
		clickSound = Gdx.audio.newSound(Gdx.files.internal("data/click.wav"));
	}

	public static Texture loadTexture(String file) {
		return new Texture(Gdx.files.internal(file));
	}

	public static void playSound(Sound sound) {
		// if (Settings.soundEnabled)
		sound.play(1);
	}
}
