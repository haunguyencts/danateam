package com.dana.team.wordinpicture.utils;

public class MainMenuButton extends DynamicGameObject {
	float stateTime = 0;
	public int interval = 0;
	public float scaleX = 1f;
	public float scaleY = 1f;
	public boolean isXTransforming = false;
	public boolean isYTransforming = false;
	public boolean isAppear = false;
	/* Use for volume */
	public boolean isOn = true;
	private boolean isXScaleUp = true;
	private boolean isYScaleUp = true;
	
	public MainMenuButton (float x, float y, float width, float height) {
		super(x, y, width, height);
	}

	public void update (float deltaTime) {
		if (isXTransforming) {
			if (scaleX <= 1.20 && isXScaleUp) {
				scaleX += 0.1;
			} else {
				scaleX -= 0.1;
				isXScaleUp = false;
			}
			if (scaleX <= 1f) {
				isXTransforming = false;
				isXScaleUp = true;
			}
		}
		
		if (isYTransforming) {
			if (scaleY <= 1.20 && isYScaleUp) {
				scaleY += 0.05;
			} else {
				scaleY -= 0.05;
				isYScaleUp = false;
			}
			if (scaleY <= 1f) {
				isYTransforming = false;
				isYScaleUp = true;
			}
		}	
		stateTime += deltaTime;
	}
}
