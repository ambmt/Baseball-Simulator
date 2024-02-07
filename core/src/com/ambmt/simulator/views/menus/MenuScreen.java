package com.ambmt.simulator.views.menus;

import com.ambmt.simulator.BaseballSim;
import com.ambmt.simulator.managers.PreferencesManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MenuScreen implements Screen {
    private Texture bg;


    private final BaseballSim game;
    private Stage stage;
    private float viewportWidth;
    private float viewportHeight;
    private TextButton documentation;


    public MenuScreen(BaseballSim game) {
        // initialising variables in constructor that need to be used almost instantly.
        this.game = game;
        bg = new Texture("img/bg.png");
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        viewportWidth = game.camera.viewportWidth;
        viewportHeight = game.camera.viewportHeight;
    }
    @Override
    public void show() {
        // Create a table that fills the screen. Everything else will go inside this table.
        Table table = new Table();
        // change this to go into debug mode, which shows hitboxes
        table.setDebug(false);
        table.setFillParent(true);
        stage.addActor(table);
        // Will be replaced with an asset manager, this is just for now
        //High def font
        Skin skin = new Skin(Gdx.files.internal("glassy/glassy-ui.json"));


        // Creating buttons, which will then have listeners added on
        TextButton start = new TextButton("Start", skin);
        TextButton settings = new TextButton("Preferences", skin);
        TextButton exit = new TextButton("Exit", skin);
        documentation = new TextButton("Documentation", skin);


        // Add buttons to table
        table.add(start).width(viewportWidth / 4).height(viewportHeight / 5);
        table.row().pad(15, 0, 15, 0);
        table.add(settings).width(viewportWidth / 4).height(viewportHeight / 5);
        table.row();
        table.add(exit).width(viewportWidth / 4).height(viewportHeight / 5);

        // Listeners
        documentation.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.net.openURI("https://www.youtube.com");
                event.handle();
            }
        });

        // Listeners
        documentation.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.net.openURI("");
                event.handle();
            }
        });


//        table.setPosition(game.camera.viewportWidth / 3, game.camera.viewportHeight / 4);
        table.setX(viewportWidth / 3);


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
                game.setScreen(new InGameScreen(new PreferencesManager()));
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


        // Updating camera as well as setting the projection matrix before the batch.begin to prevent it from being flushed


        game.camera.update();
        game.batch.setProjectionMatrix(game.camera.combined);
        game.batch.begin();


        //draw background, objects, etc.


        game.batch.draw(bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        documentation.draw(game.batch, 1);
        game.getFont().setColor(255, 255, 255, 1);
        game.getFont().getData().setScale(2);
        game.getFont().draw(game.batch, "BASEBALL SIMULATOR", Math.round(viewportWidth / 3), Math.round(viewportHeight / 1.05));
        game.batch.end();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        // Handle input to transition to the next screen (e.g., game screen)
    }


    @Override
    public void resize(int width, int height) {
        game.viewPort.update(width, height, true);
        this.viewportHeight = height;
        this.viewportWidth = width;
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
        stage.dispose();
    }
}