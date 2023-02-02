package task2;

import task2.controller.ManagePhoneBook;

/**
 * Рефакторинг и\или оптимизация проекта предыдущего дз с учетом теоретических основ SOLID’а
 */
public class PhoneBookMain {

    public static void main(String[] args) {
        ManagePhoneBook managePhoneBook = new ManagePhoneBook();
        managePhoneBook.start();
    }
}
