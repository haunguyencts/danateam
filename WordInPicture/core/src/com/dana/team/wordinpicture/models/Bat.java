package com.dana.team.wordinpicture.models;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;
import com.dana.team.wordinpicture.utils.DynamicGameObject;

/**
 * @author haunguyen.cts@gmail.com
 */

public class Bat extends DynamicGameObject {
	float stateTime = 0;
	public boolean isRight = true;
	public float angle = 0;
	public float fixAngle;
	public int interval = 0;
	private boolean isRotate = false;
	public boolean isXTransforming = false;
	public boolean isYTransforming = false;
	private boolean isXScaleUp = true;
	private boolean isYScaleUp = true;
	public float scaleX = 1f;
	public float scaleY = 1f;
	
	Vector2 fixPosition;
	Vector2 prePosition;
	Random r;
    Float maxVelocityChange = 50f;
	
	public Bat (float x, float y, float width, float height) {
		super(x, y, width, height);
		fixPosition = position.cpy();
		prePosition = position.cpy();
		r = new Random();
	}

	public void update (float deltaTime) {
		/* Randomly change velocity */
		if ((int)stateTime % 20 == 0) {
			velocity.x = r.nextFloat() * maxVelocityChange - maxVelocityChange / 2f;
			velocity.y = r.nextFloat() * maxVelocityChange - maxVelocityChange / 2f;
		}
		/* Update position */
		prePosition.set(position);
		position.add(velocity.x * deltaTime, velocity.y * deltaTime);
		bounds.x = position.x - bounds.width / 2;
		bounds.y = position.y - bounds.height / 2;
		
		/* Check if bat goes too far from first his position */
		if (position.dst2(fixPosition) >= 50) {
			position.set(prePosition);
			velocity.x = r.nextFloat() * maxVelocityChange - maxVelocityChange / 2f;
			velocity.y = r.nextFloat() * maxVelocityChange - maxVelocityChange / 2f;
		}
		
		if ((int)stateTime % interval == 0 && isRotate != true && stateTime > 1) {
			isRotate = true;
		}
		
		if (isRotate) {
			angle = angle + 5;
			if (angle % 360 == fixAngle){
				isRotate = false;
				angle = fixAngle;
			}
		}
		
		/* Scale if touched */
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
