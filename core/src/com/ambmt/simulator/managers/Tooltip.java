package com.ambmt.simulator.managers;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

public class Tooltip extends Window {

    private Label label;

    public Tooltip(String text, Skin skin) {
        super(text, skin);

        label = new Label(text, skin);
        add(label).pad(10);
        pack();
        setVisible(false);
    }

    public void showTooltip(float x, float y) {
        setPosition(x, y);
        setVisible(true);
    }

    public void hideTooltip() {
        setVisible(false);
    }
}
