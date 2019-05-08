package sample.Gui;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class MainMenu {
    private Label label = new Label();

    private void addLabel(GridPane root) {
        GridPane.setHgrow(label, Priority.ALWAYS);
        root.add(label, 0, 0, 4, 4);
    }
    private void setMenuSize(GridPane root) {
            root.getRowConstraints().add(new RowConstraints(50));
    }

    public MainMenu(GridPane root) {
        addLabel(root);
        setMenuSize(root);
        Buttons buttons = new Buttons(root);
    }
}

