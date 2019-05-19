package sample.core;

public enum Operation {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    ZERO("0"),
    PLUS(" + "),
    MINUS(" - "),
    MULTIPLY(" * "),
    DIVIDE(" / ");

    public String getName() {
        return name;
    }

    private final String name;
    Operation(final String name) {
        this.name = name;
    }

    static boolean isOperator(Operation operation) {
        switch (operation) {
            case PLUS:
            case MINUS:
            case MULTIPLY:
            case DIVIDE: return true;
            default: return false;
        }
    }

    float numberOf() {
        switch (this) {
            case ONE: return 1;
            case TWO: return 2;
            case THREE: return 3;
            case FOUR: return 4;
            case FIVE: return 5;
            case SIX: return 6;
            case SEVEN: return 7;
            case EIGHT: return 8;
            case NINE: return 9;
            default: return 0;
        }
    }
}
