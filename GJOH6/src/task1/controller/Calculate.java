package task1.controller;

import task1.config.LoggerConfig;
import task1.model.RationalExample;
import task1.service.Solve;
import task1.service.impl.SolveImpl;
import task1.view.MenuGet;
import task1.view.impl.MenuGetImpl;
import task1.view.MenuShow;
import task1.view.impl.MenuShowImpl;

import java.io.IOException;

/**
 * Class linking model and view
 */
public class Calculate {
    public Solve solve = new SolveImpl();

    public void start() {
        MenuGet menuGet = new MenuGetImpl();
        MenuShow menuShow = new MenuShowImpl();
        try {
            LoggerConfig.config();
        } catch (IOException e) {
            menuShow.showMessage("Error", "Problem with logging");
        }

        String action;
        do {
            action = menuShow.showMenu(menuGet);
            if (action.equals("0")) {
                return;
            }
            RationalExample example = new RationalExample(solve.checkOperation(action));
            Number[] values = menuGet.getValuesForExpression();
            example.setVariableA(values[0]);
            example.setVariableB(values[1]);
            try {
                menuShow.showMessage("Result", solve.solve(example));
            } catch (NullPointerException e) {
                menuShow.showMessage("Error", "Incorrect data. Please, input values again");
            }
        } while (true);
    }
}
