
package com.dana.team.wordinpicture.models;

import com.dana.team.wordinpicture.utils.GameObject;

public class Coin extends GameObject {
	public static final float COIN_WIDTH = 0.5f;
	public static final float COIN_HEIGHT = 0.8f;
	public static final int COIN_SCORE = 1;

	private float stateTime;
	
	public void setStateTime(float statetime){
		this.stateTime = statetime;
	}
	
	public float getStateTime(){
		return this.stateTime;
	}

	public Coin (float x, float y) {
		super(x, y, COIN_WIDTH, COIN_HEIGHT);
		stateTime = 0;
	}

	public void update (float deltaTime) {
		stateTime += deltaTime;
	}
}
