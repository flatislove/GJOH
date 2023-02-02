package task1.view;

/**
 * Interface contains get-methods from the console
 */
public interface MenuGet {

    /**
     * Method get String value from input
     *
     * @return String
     */
    String getInputValue();

    /**
     * Method get two values from input for expression
     *
     * @return array of two number
     */
    Number[] getValuesForExpression();
}
