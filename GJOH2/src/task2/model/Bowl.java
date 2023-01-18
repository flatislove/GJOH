package task2.model;

import task2.model.enums.Color;

public class Bowl {
    private final Color color;
    private boolean isEmpty;

    public Bowl(Color color) {
        this.color = color;
        this.isEmpty = true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    public String toString() {
        return "Bowl{" +
                "color=" + color +
                ", isEmpty=" + isEmpty +
                '}';
    }
}
