
package com.dana.team.wordinpicture.models;

import com.dana.team.wordinpicture.Config;
import com.dana.team.wordinpicture.utils.DynamicGameObject;

public class Cloud extends DynamicGameObject {
	public static final float CLOUD_WIDTH = 150;
	public static final float CLOUD_HEIGHT = 100;
	public static final float CLOUD_MAX_VELOCITY = 20f;

	float stateTime = 0;
	public boolean isRight = true;
	public Cloud (float x, float y) {
		super(x, y, CLOUD_WIDTH, CLOUD_HEIGHT);
	}

	public void update (float deltaTime) {
		position.add(velocity.x * deltaTime, velocity.y * deltaTime);
		bounds.x = position.x - CLOUD_WIDTH / 2;
		bounds.y = position.y - CLOUD_HEIGHT / 2;

		if (position.x < - CLOUD_WIDTH) {
			position.x = Config.SIZE_SCREEN_WIDTH + CLOUD_WIDTH;
		}
		if (position.x > Config.SIZE_SCREEN_WIDTH + CLOUD_WIDTH) {
			position.x = - CLOUD_WIDTH;
		}
		stateTime += deltaTime;
	}
}
