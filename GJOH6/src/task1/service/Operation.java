package task1.service;

import task1.model.Example;

/**
 * Interface of mathematical operations
 *
 * @param <T> extends Number
 */
public interface Operation<T> {

    /**
     * The method finds the sum of rational numbers
     *
     * @param example contains two values
     * @return sum of numbers
     */
    T sum(Example<T> example);

    /**
     * The method finds the divide of rational numbers
     *
     * @param example two values
     * @return divide of numbers
     */
    T divide(Example<T> example);

    /**
     * The method finds the difference of rational numbers
     *
     * @param example two values
     * @return difference of numbers
     */
    T difference(Example<T> example);

    /**
     * The method finds the multiplication of rational numbers
     *
     * @param example two values
     * @return difference of numbers
     */
    T multiply(Example<T> example);
}
