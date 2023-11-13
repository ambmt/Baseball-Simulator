package com.ambmt.simulator;

import com.ambmt.simulator.views.menus.MenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Screen;

public class BaseballSim extends Game {

	@Override
	public void create () {
		setScreen(new MenuScreen());

	}

	@Override
	public void render () {

	}
	
	@Override
	public void dispose () {
	}

	public boolean screenChange(){
		return false;
	}
	@Override
	public void setScreen(Screen screen)
	{
		super.setScreen(screen);
		super.render();
	}

}
