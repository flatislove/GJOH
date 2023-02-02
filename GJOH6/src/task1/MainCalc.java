package task1;

import task1.controller.Calculate;

/**
 * Рефакторинг и\или оптимизация проекта предыдущего дз с учетом теоретических основ SOLID’а
 */
public class MainCalc {

    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        calculate.start();
    }
}
