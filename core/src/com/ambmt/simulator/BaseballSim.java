package com.ambmt.simulator;


import com.ambmt.simulator.managers.ErrorManager;
import com.ambmt.simulator.simulation.MainSim;
import com.ambmt.simulator.views.menus.MenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.util.Random;


public class BaseballSim extends Game {
	public SpriteBatch batch;
	public OrthographicCamera camera;
	public FitViewport viewPort;
	private Texture bg;
	private BitmapFont font;

	@Override
	public void create () {
		font = new BitmapFont(Gdx.files.internal("glassy/font-big-export.fnt"), false);
		// Init a camera and set it to be in its default place, so that it can display images and the stage
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1920, 1080);
		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
		batch = new SpriteBatch();
		batch.enableBlending();
		viewPort = new FitViewport(1920,1080,camera);

		// by passing this, we allow all processes to be centered, and reduce wasting resources recreating variables
		try {
			setScreen(new MenuScreen(this));
		}catch(NullPointerException e){
			ErrorManager.logError(e, "Error! Please report this.");
		}
		//Preventing images flashing on screen for no reason


		//DO MORE SEQUENCE DIAGRAMS
//     Gdx.graphics.setContinuousRendering(false);
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
	@Override
	public void setScreen(Screen screen)
	{
		super.setScreen(screen);
		super.render();
	}

	public BitmapFont getFont(){
		return font;
	}


}
