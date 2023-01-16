package task2.model;

import task2.model.enums.Color;

public class Bowl {
    private Color color;
    private boolean isEmpty;

    public Bowl(Color color) {
        this.color = color;
        this.isEmpty = true;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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
