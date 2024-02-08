// SimulationScreen.java
package com.ambmt.simulator.views.menus;

import com.ambmt.simulator.managers.PreferencesManager;
import com.ambmt.simulator.simulation.ImportPlayers;
import com.ambmt.simulator.simulation.MainSim;
import com.ambmt.simulator.simulation.TempSim;
import com.ambmt.simulator.views.game.ScoreBug;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class InGameScreen extends ScreenAdapter {

    private Stage stage;
    private Skin skin;
    private PreferencesManager preferencesManager;
    private boolean isPaused = false;
    private TextArea simTextArea;

    public InGameScreen(PreferencesManager preferencesManager) {
        this.preferencesManager = preferencesManager;
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        skin = new Skin(Gdx.files.internal("glassy/glassy-ui.json"));

        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        //Play/Pause button
        TextButton timeControlButton = new TextButton("Play/Pause", skin);
        timeControlButton.addListener(new TimeControlistener());
        table.add(timeControlButton).padBottom(20).colspan(2).center().row();

        // Lineups Button
        TextButton lineupsButton = new TextButton("View Lineups", skin);
        lineupsButton.addListener(new LineupsClickListener());
        table.add(lineupsButton).padBottom(20).colspan(2).center().row();

        //Simulation Text Area
        simTextArea = new TextArea("Simulation text goes here.", skin);
        ScrollPane scrollPane = new ScrollPane(simTextArea, skin);
        simTextArea.setDisabled(true);
        table.add(scrollPane).expand().fill().colspan(2);

        ScoreBug scoreBug = new ScoreBug(stage);
        MainSim ms = new MainSim();
        ms.MainSim();
        ms.startGame();
        ImportPlayers imp = new ImportPlayers();
        imp.ImportPlayers();

        





    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }

    // Custom listener for the lineups button
    private class LineupsClickListener extends ClickListener {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            System.out.println("Lineups button clicked");
        }
    }
    private class TimeControlistener extends ClickListener{
        @Override
        public void clicked(InputEvent event, float x , float y ){
            System.out.println("Gameplay paused");
        }
    }
}