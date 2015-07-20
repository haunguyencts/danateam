/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.dana.team.wordinpicture;

import java.util.ArrayList;
import java.util.List;

import com.dana.team.wordinpicture.models.Coin;

public class World {
	public interface WorldListener {
		public void jump();

		public void highJump();

		public void hit();

		public void coin();
	}

	public final List<Coin> coins;

	public World(WorldListener listener) {

		this.coins = new ArrayList<Coin>();
		
		for(int i = 0; i < 5; i++){
			Coin coin = new Coin(1 + i , 2+i);
					//platform.position.x + rand.nextFloat(),
					//platform.position.y + ItemCoin.COIN_HEIGHT
						//	+ rand.nextFloat() * 3);
			coins.add(coin);
		}
	}

	public void update(float deltaTime, float accelX) {

		updateCoins(deltaTime);
	}

	private void updateCoins(float deltaTime) {
		int len = coins.size();
		for (int i = 0; i < len; i++) {
			Coin coin = coins.get(i);
			coin.update(deltaTime);
		}
	}

}
