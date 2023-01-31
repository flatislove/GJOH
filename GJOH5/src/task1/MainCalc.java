package task1;

import task1.controller.Calculate;

/**
 * Создать калькулятор для работы с рациональными числами, организовать меню, добавив в неё систему логирования.
 */
public class MainCalc {
    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        calculate.start();
    }
}
