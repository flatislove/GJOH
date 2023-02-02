package task1.service.impl;

import task1.model.Example;
import task1.service.Operation;

/**
 * implementation of the Operation interface for rational numbers
 */
public class RationalOperationImpl implements Operation<Number> {

    /**
     * The method finds the sum of rational numbers
     *
     * @param example contains two values
     * @return sum of numbers
     */
    @Override
    public Number sum(Example<Number> example) {
        if (example.getVariableA() instanceof Integer) {
            return (Integer) example.getVariableA() + (Integer) example.getVariableB();
        } else if (example.getVariableA() instanceof Double) {
            return (Double) example.getVariableA() + (Double) example.getVariableB();
        } else if (example.getVariableA() instanceof Float) {
            return (Float) example.getVariableA() + (Float) example.getVariableB();
        } else {
            return null;
        }
    }

    /**
     * The method finds the divide of rational numbers
     *
     * @param example two values
     * @return divide of numbers
     */
    @Override
    public Number divide(Example<Number> example) {
        if (example.getVariableA() instanceof Integer) {
            return (Integer) example.getVariableA() / (Integer) example.getVariableB();
        } else if (example.getVariableA() instanceof Double) {
            return (Double) example.getVariableA() / (Double) example.getVariableB();
        } else if (example.getVariableA() instanceof Float) {
            return (Float) example.getVariableA() / (Float) example.getVariableB();
        } else {
            return null;
        }
    }

    /**
     * The method finds the difference of rational numbers
     *
     * @param example two values
     * @return difference of numbers
     */
    @Override
    public Number difference(Example<Number> example) {
        if (example.getVariableA() instanceof Integer) {
            return (Integer) example.getVariableA() - (Integer) example.getVariableB();
        } else if (example.getVariableA() instanceof Double) {
            return (Double) example.getVariableA() - (Double) example.getVariableB();
        } else if (example.getVariableA() instanceof Float) {
            return (Float) example.getVariableA() - (Float) example.getVariableB();
        } else {
            return null;
        }
    }

    /**
     * The method finds the multiplication of rational numbers
     *
     * @param example two values
     * @return difference of numbers
     */
    @Override
    public Number multiply(Example<Number> example) {
        if (example.getVariableA() instanceof Integer) {
            return (Integer) example.getVariableA() * (Integer) example.getVariableB();
        } else if (example.getVariableA() instanceof Double) {
            return (Double) example.getVariableA() * (Double) example.getVariableB();
        } else if (example.getVariableA() instanceof Float) {
            return (Float) example.getVariableA() * (Float) example.getVariableB();
        } else {
            return null;
        }
    }
}
