package com.dana.team.wordinpicture.models;

import com.dana.team.wordinpicture.Config;
import com.dana.team.wordinpicture.utils.DynamicGameObject;

public class Monkey extends DynamicGameObject {
	public static final float COIN_WIDTH = 10f;
	public static final float COIN_HEIGHT = 10f;
	public static final int COIN_SCORE = 1;

	float stateTime = 0;

	public Monkey(float x, float y) {
		super(x, y, COIN_WIDTH, COIN_HEIGHT);
	}
	
	public float getStateTime(){
		return this.stateTime;
	}

	public void update(float deltaTime) {

		position.add(velocity.x * deltaTime, velocity.y * deltaTime);
		bounds.x = position.x - COIN_WIDTH / 2;
		bounds.y = position.y - COIN_HEIGHT / 2;

		if (position.x < -COIN_WIDTH) {
			position.x = Config.SIZE_SCREEN_WIDTH + COIN_WIDTH;
		}
		if (position.x > Config.SIZE_SCREEN_WIDTH + COIN_WIDTH) {
			position.x = -COIN_WIDTH;
		}
		stateTime += deltaTime;
	}
}
