// SimulationScreen.java
package com.ambmt.simulator.views.menus;

import com.ambmt.simulator.managers.PreferencesManager;
import com.ambmt.simulator.simulation.ImportPlayers;
import com.ambmt.simulator.simulation.MainSim;
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
    private boolean simStarted;
    private MainSim mainSim;
    private ScoreBug scoreBug;



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


        //Simulation Text Area
        simTextArea = new TextArea("Simulation text goes here.", skin);
        ScrollPane scrollPane = new ScrollPane(simTextArea, skin);
        simTextArea.setDisabled(true);
        table.add(scrollPane).expand().fill().colspan(2);
        //init main sim before as uses methods of scorebug
        ImportPlayers imp = new ImportPlayers();
        imp.ImportPlayers();
        mainSim = new MainSim();
        mainSim.init(this);
        scoreBug = new ScoreBug(stage);



    }

    public ScoreBug getScoreBug(){
        return scoreBug;
    }

    public Stage getStage(){
        return stage;
    }


    public void updateGUI(boolean scoreBugUpdate, boolean simTextUpdate, String scorebug, String textUpdate){
//        if(scoreBugUpdate){
//            ScoreBug scorebug = new ScoreBug(stage);
//            scoreBugUpdate = false;
//        }
        if(simTextUpdate){
            simTextArea.appendText("\n " + textUpdate);
            simTextUpdate = false;
            textUpdate = "";
        }


    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        if(!simStarted){
            mainSim.runSim();
            simStarted = true;
        }
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
    private class TimeControlistener extends ClickListener{
        @Override
        public void clicked(InputEvent event, float x , float y ){
            System.out.println("Gameplay paused");
        }
    }

    public void UpdateGui(){

    }
}