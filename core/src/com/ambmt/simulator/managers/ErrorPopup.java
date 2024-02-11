package com.ambmt.simulator.managers;

import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ErrorPopup extends Dialog {

    private TextField errorTextField;

    public ErrorPopup(String title, Skin skin) {
        super(title, skin);

        // Add a label with the error message
        text("An error occurred!");

        // Add a text field for user input
        errorTextField = new TextField("Enter additional information here...", skin);
        errorTextField.setMaxLength(100); // Set a limit for input length
        getContentTable().add(errorTextField).width(250).padTop(10).padBottom(10).row();

        // Add a button to submit the error
        button("Submit Error", true);

        // Add a button to close the dialog
        button("OK", false);

        // Set the size of the dialog
        padTop(50);
        padBottom(50);
        padLeft(20);
        padRight(20);
        setSize(400, 200);
    }

    @Override
    protected void result(Object object) {
        // Handle the result of button clicks
        if (object.equals(true)) {
            // Submit error with user input
            String userInput = errorTextField.getText();
            submitError(userInput);
        }
    }

    private void submitError(String userInput) {
        // Log the error to a file (replace this with your actual logging mechanism)
        try {
            FileWriter fileWriter = new FileWriter("error.log", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Log the user input and stack trace
            printWriter.println("User Input: " + userInput);
            printWriter.println("Stack Trace:");
            printStackTrace(printWriter, new Exception());

            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printStackTrace(PrintWriter printWriter, Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));
        printWriter.println(stringWriter.toString());
    }


}

