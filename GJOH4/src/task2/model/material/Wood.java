package task2.model.material;

import task2.model.enums.Color;
/**
 * Class Wood implements interface Material. Used in generics
 */
public class Wood implements Material {
    String name;
    Color color;

    public Wood() {
        this.name = "Wood";
        this.color = Color.WHITE;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return this.color;
    }
}
