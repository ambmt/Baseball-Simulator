package com.ambmt.simulator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class BaseballSim extends ApplicationAdapter {

	//Variables used throughout the program
	SpriteBatch batch;
	Texture img;

	// Putting assets into memory ahead of time, so they can be easily and cleanly accessed
	@Override
	public void create () {
		batch = new SpriteBatch();
		//Template image
		img = new Texture("badlogic.jpg");

	}

	@Override
	public void render () {
		//Using the static function ScreenUtils to clear the screen and display a Black screen.
		ScreenUtils.clear(1, 0, 0, 1);
		//Using the previously mentioned SpriteBatch, which allows the img in memory to be accessed
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		//Disposing of the image and batch to stop memory leaks.
		batch.dispose();
		img.dispose();
	}
}
