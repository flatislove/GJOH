package task1.service;

import task1.model.enums.OperationType;
import task1.model.RationalExample;

/**
 * Interface for actions with expressions
 */
public interface Solve {

    String solve(RationalExample example);

    OperationType checkOperation(String operation);
}
