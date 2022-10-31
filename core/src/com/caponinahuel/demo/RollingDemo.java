package com.caponinahuel.demo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.caponinahuel.demo.wings.framework.core.math.FastMath;
import com.caponinahuel.demo.wings.framework.graphics.Colors;

public class RollingDemo extends ApplicationAdapter {
	private Color backgroundColor = new Color(Colors.CyanDark);
	private SpriteBatch batch;
	private Texture texture;
	private Array<Sprite> sprites = new Array<>();
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		texture = new Texture("Charmander.png");

		for (int x = 0; x < 1350 + 75;x += 75) {
			for (int y = 20; y < 720; y += 75) {
				Sprite sprite = new Sprite(texture);
				sprite.setOriginBasedPosition(x, y);
				sprites.add(sprite);
			}
		}
	}

	@Override
	public void render () {
		for (Sprite sprite : sprites) {
			sprite.rotate(-8);
			sprite.translateX(10);
			sprite.setX(FastMath.wrap(sprite.getX(), -75, 1350));
		}


		//Clean screen
		ScreenUtils.clear(backgroundColor);

		batch.begin();
		for (Sprite sprite : sprites) {
			sprite.draw(batch);
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		texture.dispose();
	}
}
