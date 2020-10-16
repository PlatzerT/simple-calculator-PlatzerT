package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CalculatorController {

    boolean wasEquals = false;

    @FXML
    private Button equals;

    @FXML
    private Button clear;

    @FXML
    private Label display;

    @FXML
    void equals() throws ScriptException
    {
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            Object result = engine.eval(display.getText());
            display.setText(String.valueOf(result));
        } catch (ScriptException e)
        {
            display.setText("Error");
        }
        wasEquals = true;
    }

    @FXML
    void clear()
    {
        display.setText("");
    }

    @FXML
    void handleAction(ActionEvent event)
    {
        String text = ((Button)event.getSource()).getText();
        String displayedText = display.getText();
        if (displayedText.length() != 0 && "+-*/".contains(displayedText.substring(displayedText.length()-1)))
        {
            wasEquals = false;
        }

        if (wasEquals && "0123456789".contains(text))
        {
            clear();
            wasEquals = false;
        }
        display.setText(display.getText() + text);
    }
}
