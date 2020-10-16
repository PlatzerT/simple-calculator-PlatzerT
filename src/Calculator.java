/****************************
 Name: Thomas Platzer
 Erstelldatum: 16.10.20
 Erstellzeit: 19:28
 Projekt: simple-calculator-PlatzerT
 ****************************/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Calculator extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/CalculatorView.fxml"));
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(new Scene(root, 350, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
