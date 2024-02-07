// PreferencesScreen.java
package com.ambmt.simulator.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class PreferencesManager {
    private static final String PREFERENCES_NAME = "GamePreferences";
    private static final String KEY_VOLUME = "volume";
    private static final String KEY_DIFFICULTY = "difficulty";

    private Preferences preferences;

    public PreferencesManager() {
        preferences = Gdx.app.getPreferences(PREFERENCES_NAME);
    }

    public float getVolume() {
        return preferences.getFloat(KEY_VOLUME, 0.5f);
    }

    public void setVolume(float volume) {
        preferences.putFloat(KEY_VOLUME, volume);
        preferences.flush(); // Save changes immediately
    }

    public int getDifficulty() {
        return preferences.getInteger(KEY_DIFFICULTY, 1);
    }

    public void setDifficulty(int difficulty) {
        preferences.putInteger(KEY_DIFFICULTY, difficulty);
        preferences.flush(); // Save changes immediately
    }
}
