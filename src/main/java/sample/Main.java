package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.gui.Gui;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();
        primaryStage.setScene(new Scene(root, 320, 250));
        primaryStage.setTitle("Calculator");
        Gui gui = new Gui(root);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main (String[]args) {
        launch(args);
    }
}