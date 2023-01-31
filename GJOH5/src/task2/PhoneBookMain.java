package task2;

import task2.controller.ManagePhoneBook;

/**
 * Создать телефонный справочник с возможностью импорта и экспорта данных в нескольких форматах
 */
public class PhoneBookMain {
    public static void main(String[] args) {
        ManagePhoneBook managePhoneBook = new ManagePhoneBook();
        managePhoneBook.start();
    }
}
