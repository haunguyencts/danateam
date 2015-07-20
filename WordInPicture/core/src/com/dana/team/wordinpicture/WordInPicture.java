package com.dana.team.wordinpicture;

import com.badlogic.gdx.Game;
import com.dana.team.wordinpicture.screens.MainMenuScreen;
import com.dana.team.wordinpicture.utils.Assets;

/**
 * @author haunguyen.cts@gmail.com
 */
public class WordInPicture extends Game {

	@Override
	public void create() {
		Assets.load();
		setScreen(new MainMenuScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
	}

}
