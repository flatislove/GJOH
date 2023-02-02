package task1.service;

import task1.model.enums.OperationType;
import task1.model.RationalExample;

/**
 * Interface for actions with expressions
 */
public interface Solve {

    /**
     * Method returns result of operation and writes logs
     *
     * @param example contains two values and symbol of operation
     * @return result of operation
     */
    String solve(RationalExample example);

    /**
     * Method returns symbol for operation
     *
     * @param operation symbol of operation as String
     * @return enum equivalent operation
     */
    OperationType checkOperation(String operation);
}
