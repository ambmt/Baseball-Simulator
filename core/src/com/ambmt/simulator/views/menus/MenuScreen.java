package com.ambmt.simulator.views.menus;

import com.ambmt.simulator.BaseballSim;
import com.ambmt.simulator.input.MainMenuInput;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import javax.swing.text.View;
import java.awt.*;


public class MenuScreen implements Screen, InputProcessor {
    private final Texture bg;

    private final BaseballSim game;
    private final BitmapFont font;

    public MenuScreen(BaseballSim game) {
        this.game = game;
        bg = new Texture("bg.jpg");
        font = new BitmapFont();
    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(new MainMenuInput(this));
    }


    @Override
    public void render(float delta) {

        System.out.println("Render called 1");
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.camera.update();
        game.batch.setProjectionMatrix(game.camera.combined);
        game.batch.begin();

        //draw background, objects, etc.

        game.batch.draw(bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.batch.end();
        // Handle input to transition to the next screen (e.g., game screen)

    }

    @Override
    public void resize(int width, int height) {
        game.viewPort.update(width, height, true);


    }
    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        bg.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
