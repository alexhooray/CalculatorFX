package sample.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import sample.core.CalculatorService;
import sample.core.Operation;

public class Gui {
    private CalculatorService calculatorService = new CalculatorService();
    private Label label = new Label();
    private Button ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, ZERO, PLUS,
            MINUS, MULTIPLY, DIVIDE, DELETE, CALCULATE;

    public Gui(GridPane gridPane) {
        createButtons();
        setMenuSize(gridPane);
        addLabel(gridPane);
        addButtons(gridPane);
    }

    private void setMenuSize(GridPane gridPane) {
        gridPane.getRowConstraints().add(new RowConstraints(50));
    }

    private void setButtonSize(Button button) {
        button.setMaxHeight(Double.MAX_VALUE);
        button.setMaxWidth(Double.MAX_VALUE);
        GridPane.setHgrow(button, Priority.ALWAYS);
        GridPane.setVgrow(button, Priority.ALWAYS);
    }

    private void addLabel(GridPane gridPane) {
        label.setFont(new Font("verdana", 35));
        gridPane.add(label, 0,0, 4, 4);
        label.setText(calculatorService.show());
    }

    private void addButtons(GridPane gridPane) {
        gridPane.add(ONE, 0, 4);
        gridPane.add(TWO, 1, 4);
        gridPane.add(THREE, 2, 4);
        gridPane.add(PLUS, 3, 4);
        gridPane.add(FOUR, 0, 5);
        gridPane.add(FIVE, 1, 5);
        gridPane.add(SIX, 2, 5);
        gridPane.add(MINUS, 3, 5);
        gridPane.add(SEVEN, 0, 6);
        gridPane.add(EIGHT, 1, 6);
        gridPane.add(NINE, 2, 6);
        gridPane.add(MULTIPLY, 3, 6);
        gridPane.add(ZERO, 1, 7);
        gridPane.add(DIVIDE, 2, 7);
        gridPane.add(CALCULATE, 3, 7);
        gridPane.add(DELETE, 0, 7);
    }

    private void createButtons() {
        ONE = new Button(Operation.ONE.getName());
        setButtonSize(ONE);
        ONE.setOnAction(event -> {
            calculatorService.input(Operation.ONE);
            label.setText(String.valueOf(calculatorService.calculate()));
            label.setText(calculatorService.show());
        });

        TWO = new Button(Operation.TWO.getName());
        setButtonSize(TWO);
        TWO.setOnAction(event -> {
            calculatorService.input(Operation.TWO);
            label.setText(calculatorService.show());
        });

        THREE = new Button(Operation.THREE.getName());
        setButtonSize(THREE);
        THREE.setOnAction(event -> {
            calculatorService.input(Operation.THREE);
            label.setText(calculatorService.show());
        });

        FOUR = new Button(Operation.FOUR.getName());
        setButtonSize(FOUR);
        FOUR.setOnAction(event -> {
            calculatorService.input(Operation.FOUR);
            label.setText(calculatorService.show());
        });

        FIVE = new Button(Operation.FIVE.getName());
        setButtonSize(FIVE);
        FIVE.setOnAction(event -> {
            calculatorService.input(Operation.FIVE);
            label.setText(calculatorService.show());
        });

        SIX = new Button(Operation.SIX.getName());
        setButtonSize(SIX);
        SIX.setOnAction(event -> {
            calculatorService.input(Operation.SIX);
            label.setText(calculatorService.show());
        });

        SEVEN = new Button(Operation.SEVEN.getName());
        setButtonSize(SEVEN);
        SEVEN.setOnAction(event -> {
            calculatorService.input(Operation.SEVEN);
            label.setText(calculatorService.show());
        });

        EIGHT = new Button(Operation.EIGHT.getName());
        setButtonSize(EIGHT);
        EIGHT.setOnAction(event -> {
            calculatorService.input(Operation.EIGHT);
            label.setText(calculatorService.show());
        });

        NINE = new Button(Operation.NINE.getName());
        setButtonSize(NINE);
        NINE.setOnAction(event -> {
            calculatorService.input(Operation.NINE);
            label.setText(calculatorService.show());
        });

        ZERO = new Button(Operation.ZERO.getName());
        setButtonSize(ZERO);
        ZERO.setOnAction(event -> {
            calculatorService.input(Operation.ZERO);
            label.setText(calculatorService.show());
        });

        PLUS = new Button(Operation.PLUS.getName());
        setButtonSize(PLUS);
        PLUS.setOnAction(event -> {
            calculatorService.input(Operation.PLUS);
            label.setText(calculatorService.show());
        });

        MINUS = new Button(Operation.MINUS.getName());
        setButtonSize(MINUS);
        MINUS.setOnAction(event -> {
            calculatorService.input(Operation.MINUS);
            label.setText(calculatorService.show());
        });

        MULTIPLY = new Button(Operation.MULTIPLY.getName());
        setButtonSize(MULTIPLY);
        MULTIPLY.setOnAction(event -> {
            calculatorService.input(Operation.MULTIPLY);
            label.setText(calculatorService.show());
        });

        DIVIDE = new Button(Operation.DIVIDE.getName());
        setButtonSize(DIVIDE);
        DIVIDE.setOnAction(event -> {
            calculatorService.input(Operation.DIVIDE);
            label.setText(calculatorService.show());
        });

        CALCULATE = new Button("=");
        setButtonSize(CALCULATE);
        CALCULATE.setOnAction(event -> {
            label.setText(String.valueOf(calculatorService.calculate()));
        });

        DELETE = new Button("CE");
        setButtonSize(DELETE);
        DELETE.setOnAction(event -> {
            calculatorService.delete();
            label.setText(calculatorService.show());
        });
    }
}
