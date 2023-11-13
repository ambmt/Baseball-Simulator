package com.ambmt.simulator.input;

import com.ambmt.simulator.views.menus.MenuScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import jdk.tools.jmod.Main;

public class MainMenuInput extends InputAdapter {
    private Screen menuScreen;
    public MainMenuInput(Screen menu){
        this.menuScreen = menu;
    }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        this.handleInput();
        return true;
    }
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            // Handle the touch event here
            System.out.println("Touch detected");
            // Replace the following line with the code to switch screens
            // game.setScreen(new GameScreen());
        }
    }
}
