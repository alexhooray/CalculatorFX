package sample.gui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import sample.core.CalculatorService;
import sample.core.Operation;

public class Gui {

    private CalculatorService calculatorService = new CalculatorService();
    private Label label = new Label();

    public Gui(GridPane gridPane) {
        setMenuSize(gridPane);
        addLabel(gridPane);
        addButtons(gridPane);
    }

    private void setMenuSize(GridPane gridPane) {
        gridPane.getColumnConstraints().add(new ColumnConstraints(80, 80,80));
        gridPane.getColumnConstraints().add(new ColumnConstraints(80, 80,80));
        gridPane.getColumnConstraints().add(new ColumnConstraints(80, 80,80));
        gridPane.getColumnConstraints().add(new ColumnConstraints(80, 80,80));
    }

    private void addLabel(GridPane gridPane) {
        GridPane.setHalignment(label, HPos.RIGHT);
        GridPane.setMargin(label, new Insets(15));
        label.setFont(new Font("verdana", 30));
        gridPane.add(label, 0,0, 4, 4);
        label.setText(calculatorService.show());
    }

    private void setButtonSize(Button button) {
        button.setMaxHeight(Double.MAX_VALUE);
        button.setMaxWidth(Double.MAX_VALUE);
        GridPane.setHgrow(button, Priority.ALWAYS);
        GridPane.setVgrow(button, Priority.ALWAYS);
    }

    private void addButtons(GridPane gridPane) {
        gridPane.add(createButton(Operation.ONE), 0, 4);
        gridPane.add(createButton(Operation.TWO), 1, 4);
        gridPane.add(createButton(Operation.THREE), 2, 4);
        gridPane.add(createButton(Operation.PLUS), 3, 4);
        gridPane.add(createButton(Operation.FOUR), 0, 5);
        gridPane.add(createButton(Operation.FIVE), 1, 5);
        gridPane.add(createButton(Operation.SIX), 2, 5);
        gridPane.add(createButton(Operation.MINUS), 3, 5);
        gridPane.add(createButton(Operation.SEVEN), 0, 6);
        gridPane.add(createButton(Operation.EIGHT), 1, 6);
        gridPane.add(createButton(Operation.NINE), 2, 6);
        gridPane.add(createButton(Operation.MULTIPLY), 3, 6);
        gridPane.add(createButton(Operation.ZERO), 1, 7);
        gridPane.add(createButton(Operation.DIVIDE), 2, 7);
        gridPane.add(createCalculateButton(), 3, 7);
        gridPane.add(createDeleteButton(), 0, 7);
    }

    private Button createButton(Operation operation) {
        Button button = new Button(operation.getName());
        setButtonSize(button);
        button.setOnAction(event -> {
            calculatorService.input(operation);
            label.setText(String.valueOf(calculatorService.calculate()));
            label.setText(calculatorService.show());
        });
        return button;
    }

    private Button createDeleteButton() {
        Button deleteButton = new Button("CE");
        setButtonSize(deleteButton);
        deleteButton.setOnAction(event -> {
            calculatorService.delete();
            label.setText(calculatorService.show());
        });
        return deleteButton;
    }

    private Button createCalculateButton() {
        Button calculateButton = new Button("=");
        setButtonSize(calculateButton);
        calculateButton.setOnAction(event -> {
            label.setText(String.valueOf(calculatorService.calculate()));
        });
        return calculateButton;
    }
}