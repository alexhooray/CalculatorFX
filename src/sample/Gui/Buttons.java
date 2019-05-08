package sample.Gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class Buttons {
    public Button one,two, three, four, five, six, seven,
            eight, nine, zero, plus, minus, multiply, divide,
            equal, delete;


    private Button createButtons(String name) {
        Button button = new Button(name);
        button.setMaxWidth(Double.MAX_VALUE);
        button.setMaxHeight(Double.MAX_VALUE);
        GridPane.setHgrow(button, Priority.ALWAYS);
        GridPane.setVgrow(button, Priority.ALWAYS);
        return button;
    }

    private void initialButtons() {
        one = createButtons("1");
        two = createButtons("2");
        three = createButtons("3");
        four = createButtons("4");
        five = createButtons("5");
        six = createButtons("6");
        seven = createButtons("7");
        eight = createButtons("8");
        nine = createButtons("9");
        zero = createButtons("0");
        plus = createButtons("+");
        minus = createButtons("-");
        multiply = createButtons("*");
        divide = createButtons("/");
        equal = createButtons("=");
        delete = createButtons("CE");
    }

    void addButtons(GridPane root) {
        initialButtons();
        root.add(one, 0, 4);
        root.add(two, 1, 4);
        root.add(three, 2, 4);
        root.add(plus, 3, 4);
        root.add(four, 0, 5);
        root.add(five, 1, 5);
        root.add(six, 2, 5);
        root.add(minus, 3, 5);
        root.add(seven, 0, 6);
        root.add(eight, 1, 6);
        root.add(nine, 2, 6);
        root.add(multiply, 3, 6);
        root.add(zero, 1, 7);
        root.add(divide, 2, 7);
        root.add(equal, 3, 7);
        root.add(delete, 0, 7);
    }
    public Buttons(GridPane root) {
        addButtons(root);
    }
}
