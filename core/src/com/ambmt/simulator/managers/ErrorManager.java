package com.ambmt.simulator.managers;

import com.ambmt.simulator.views.menus.InGameScreen;
import com.ambmt.simulator.views.menus.MenuScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class ErrorManager extends ScreenAdapter {
    private static final String LOG_FILE_PATH = "error.log";
    private static TextField customMessageField;

    public static void logError(Exception exception, String customMessage) {
        // Log the error to a file
        logToFile(exception, customMessage);

        // Show an error dialog to the user
        Gdx.app.postRunnable(() -> showErrorDialog(exception, customMessage));
    }

    private static void logToFile(Exception exception, String customMessage) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE_PATH, true))) {
            writer.println("----- Error Report -----");
            writer.println("Custom Message: " + customMessage);
            writer.println("Timestamp: " + new Date());
            exception.printStackTrace(writer);
            writer.println("------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showErrorDialog(Exception exception, String customMessage) {
        Dialog dialog = new Dialog("Error Report", new Skin(Gdx.files.internal("glassy/glassy-ui.json"))) {
            {
                text("An error occurred. Please describe what you were doing when the error happened:");

                // Input field for custom message
                customMessageField = new TextField("", getSkin());
                getContentTable().add(customMessageField).width(300).padBottom(20).row();

                button("Submit", true);
            }

            @Override
            protected void result(Object object) {
                boolean submitted = (Boolean) object;
                if (submitted) {
                    String userInput = customMessageField.getText();
                }
            }
        };


    }
}
