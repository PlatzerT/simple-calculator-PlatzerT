package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CalculatorController {

    @FXML
    private Button equals;

    @FXML
    private Button clear;

    @FXML
    private Label display;

    @FXML
    void handleAction(ActionEvent event) throws ScriptException {

        if (event.getSource() == equals)
        {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            Object result = engine.eval(display.getText());
            display.setText(String.valueOf((int)result));
            return;

        }
        display.setText(display.getText() + ((Button)event.getSource()).getText());

        if (event.getSource() == clear)
        {
            display.setText("");
        }
    }
}
