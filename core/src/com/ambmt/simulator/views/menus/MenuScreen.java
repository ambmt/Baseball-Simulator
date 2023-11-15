package com.ambmt.simulator.views.menus;

import com.ambmt.simulator.BaseballSim;
import com.ambmt.simulator.input.MainMenuInput;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import javax.swing.text.View;
import java.awt.*;


public class MenuScreen implements Screen, InputProcessor {
    private Texture bg;

    private final BaseballSim game;
    private Stage stage;

    public MenuScreen(BaseballSim game) {
        // initialising variables in constructor that need to be used almost instantly.
        this.game = game;
        bg = new Texture("img/bg.png");
        stage = new Stage(new ScreenViewport());
    }


    @Override
    public void show() {
        // Create a table that fills the screen. Everything else will go inside this table.
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);

        // Will be replaced with an asset manager, this is just for now
        Skin skin = new Skin(Gdx.files.internal("neon/neon-ui.json"));

        // Creating buttons, which will then have listeners added on
        TextButton start = new TextButton("Start", skin);
        TextButton settings = new TextButton("Preferences", skin);
        TextButton exit = new TextButton("Exit", skin);

        // Add buttons to table
        table.add(start).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(settings).fillX().uniformX();
        table.row();
        table.add(exit).fillX().uniformX();


        // Create button listeners
        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

        start.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new InGameScreen());
            }
        });

        settings.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new PreferencesScreen());
            }
        });

    }


    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.camera.update();
        game.batch.setProjectionMatrix(game.camera.combined);
        game.batch.begin();

        //draw background, objects, etc.

        game.batch.draw(bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.batch.end();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
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
