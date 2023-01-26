package task2.model.material;

import task2.model.enums.Color;

/**
 * Class Material. Used in generics
 */
public interface Material {
    String getName();

    void setColor(Color color);

    Color getColor();
}
