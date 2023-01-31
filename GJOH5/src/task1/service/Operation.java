package task1.service;

import task1.model.Example;

/**
 * Interface of mathematical operations
 *
 * @param <T> extends Number
 */
public interface Operation<T> {
    T sum(Example<T> example);

    T divide(Example<T> example);

    T difference(Example<T> example);

    T multiply(Example<T> example);
}
