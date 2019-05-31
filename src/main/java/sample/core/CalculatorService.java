package sample.core;

import java.util.*;

public class CalculatorService {

    private ArrayList<Operation> list = new ArrayList<>(Collections.singletonList(Operation.ZERO));

    public Number calculate() {
        Operation lastOperation = null;
        float leftSide = 0;
        float rightSide = 0;
        for (Operation currentOperation : list) {
            if (!currentOperation.isOperator()) {
                if (lastOperation == null) {
                    leftSide = leftSide * 10 + currentOperation.numberOf();
                } else {
                    rightSide = rightSide * 10 + currentOperation.numberOf();
                }
            } else {
                if (lastOperation != null) {
                    leftSide = performCalculationBetween(leftSide, rightSide, lastOperation);
                    rightSide = 0;
                }
                lastOperation = currentOperation;
            }
        }
        if (lastOperation != null) {
            leftSide = performCalculationBetween(leftSide, rightSide, lastOperation);
        }
        if (lastOperation == Operation.DIVIDE) {
            int integerValue = (int) leftSide;
            float result = leftSide - integerValue;
            if (result % 2 != 0) {
                return leftSide;
            } else return (int) leftSide;
        } else return (int) leftSide;
    }

    public void input(Operation operation) {
        if (operation.isOperator() &&
        list.size() > 0 &&
                list.get(list.size() - 1).isOperator()) {
            list.set(list.size() - 1, operation); // change last operator
            return;
        }
        // if number and last element - zero
        if (!operation.isOperator() && list.size() > 0 && list.get(list.size() - 1) == Operation.ZERO) {
            // in list only zero
            if (list.size() == 1) {
                list.set(0, operation); // change to number
                return;
                // if list ends with [..., operator, zero]
            } else if (list.size() > 2 && list.get(list.size() - 2).isOperator()) {
                list.remove(list.size() - 1); // delete zero from list
            }
        }
        list.add(operation);
    }

    public String show() {
        String result = "";
        for (Operation value : list) {
            if (value.isOperator()) {
                result += " " + value.getName() + " ";
            } else result += value.getName();
        }
        return result;
    }

    private float performCalculationBetween(float leftSide, float rightSide, Operation operation) {
        switch (operation) {
            case PLUS:
                return leftSide + rightSide;
            case MINUS:
                return leftSide - rightSide;
            case MULTIPLY:
                return leftSide * rightSide;
            case DIVIDE:
                return leftSide / rightSide;
            default:
                return 0;
        }
    }

    public void delete() {
        list.clear();
        list.add(Operation.ZERO);
    }
}