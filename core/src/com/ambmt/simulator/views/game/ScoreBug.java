package com.ambmt.simulator.views.game;

import com.ambmt.simulator.simulation.MainSim;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class ScoreBug extends ScreenAdapter {

    private Stage stage;
    private Skin skin;

    private Label homeScoreLabel;
    private Label homeHitsLabel;
    private Label homeErrorsLabel;
    private Label homeInningsLabel;

    private Label awayScoreLabel;
    private Label awayHitsLabel;
    private Label awayErrorsLabel;
    private Label awayInningsLabel;

    private int homeScore = 0;
    private int homeHits = 0;
    private int homeErrors = 0;
    private int homeInnings = 1;

    private int awayScore = 0;
    private int awayHits = 0;
    private int awayErrors = 0;
    private int awayInnings = 1;
    private boolean updateScorebug;



    public ScoreBug(Stage stage) {
        Gdx.input.setInputProcessor(stage);
        skin = new Skin(Gdx.files.internal("glassy/glassy-ui.json"));

        // Home Team Scorebug
        Table homeTable = new Table();
        homeTable.top().left().pad(10);
        homeTable.setFillParent(true);
        stage.addActor(homeTable);

        homeScoreLabel = new Label("Score: 0", skin);
        homeHitsLabel = new Label("Hits: 0", skin);
        homeErrorsLabel = new Label("Errors: 0", skin);
        homeInningsLabel = new Label("Inning: 1", skin);
        MainSim ms = new MainSim();




        homeScoreLabel.setFontScale(1.2f);
        homeHitsLabel.setFontScale(1.2f);
        homeErrorsLabel.setFontScale(1.2f);
        homeInningsLabel.setFontScale(1.2f);


        homeTable.add(homeScoreLabel).padRight(20);
        homeTable.add(homeHitsLabel).padRight(20).row();
        homeTable.add(homeErrorsLabel).padRight(20);
        homeTable.add(homeInningsLabel).padRight(20).row();

        // Away Team Scorebug
        Table awayTable = new Table();
        awayTable.top().right().pad(10);
        awayTable.setFillParent(true);
        stage.addActor(awayTable);

        awayScoreLabel = new Label("Score: 0", skin);
        awayHitsLabel = new Label("Hits: 0", skin);
        awayErrorsLabel = new Label("Errors: 0 ", skin);
        awayInningsLabel = new Label("Inning: 1", skin);


        awayScoreLabel.setFontScale(1.2f);
        awayHitsLabel.setFontScale(1.2f);
        awayErrorsLabel.setFontScale(1.2f);
        awayInningsLabel.setFontScale(1.2f);

        awayTable.add(awayScoreLabel).padLeft(20);
        awayTable.add(awayHitsLabel).padLeft(20).row();
        awayTable.add(awayErrorsLabel).padLeft(20);
        awayTable.add(awayInningsLabel).padRight(20).row();

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



    // Update the scorebug with new information
    public void updateScorebug(int newHomeScore, int newHomeHits, int newHomeErrors, int newHomeInnings,
                               int newAwayScore, int newAwayHits, int newAwayErrors, int newAwayInnings) {
        updateScorebug = true;
        homeScore = newHomeScore;
        homeHits = newHomeHits;
        homeErrors = newHomeErrors;
        homeInnings = newHomeInnings;

        awayScore = newAwayScore;
        awayHits = newAwayHits;
        awayErrors = newAwayErrors;
        awayInnings = newAwayInnings;

        // Update Home Team labels
        homeScoreLabel.setText("Score: " + homeScore);
        homeHitsLabel.setText("Hits: " + homeHits);
        homeErrorsLabel.setText("Errors: " + homeErrors);
        homeInningsLabel.setText("Inning: " + homeInnings);

        // Update Away Team labels
        awayScoreLabel.setText("Score: " + awayScore);
        awayHitsLabel.setText("Hits: " + awayHits);
        awayErrorsLabel.setText("Errors: " + awayErrors);
        awayInningsLabel.setText("Inning: " + awayInnings);
    }

}