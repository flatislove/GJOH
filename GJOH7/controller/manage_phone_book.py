from service.phone_book_operation import PhoneBookOperation
from service.xml_operation import XmlOperation
from service.json_operation import JsonOperation
from view.menu import Menu
from service.parser import Parser
from view.show_menu import ShowMenu
from view.get_menu import GetMenu
from view.waiting import Waiting


class ManagePhoneBook:
    """
    The class linking model and view
    """
    filename = "contacts.json"
    filename_xml = "contacts.xml"
    phone_book_operation = PhoneBookOperation()
    xml_operation = XmlOperation()
    json_operation = JsonOperation()
    parser = Parser()
    menu = Menu()
    show_menu = ShowMenu()
    get = GetMenu()
    waiting = Waiting()

    def start(self):
        while True:
            self.menu.clear()
            action = self.menu.show_menu()
            if action == "0":
                break
            if action == "1":
                self.show_menu.show_message("\nSHOW ALL CONTACTS")
                self.menu.show_contacts(
                    self.json_operation.read_from_json_file(self.filename))
                self.waiting.wait_input()
            elif action == "2":
                self.show_menu.show_message("\nADD NEW CONTACT")
                self.phone_book_operation.add_contact(Parser.map_to_contact(
                    self.menu.get_contacts_values()), self.filename)
            elif action == "3":
                self.show_menu.show_message("\nSEARCH BY PHONE")
                self.menu.show_contacts(self.phone_book_operation.find_by_number(
                    self.get.get_value("Enter phone"), self.filename))
                self.waiting.wait_input()
            elif action == "4":
                self.show_menu.show_message("\nSEARCH BY NAME")
                self.menu.show_contacts(self.phone_book_operation.find_by_name(
                    self.get.get_value("Enter name"), self.filename))
                self.waiting.wait_input()
            elif action == "5":
                self.show_menu.show_message("\nREMOVE")
                contacts_for_remove = self.json_operation.read_from_json_file(
                    self.filename)
                self.menu.show_contacts(contacts_for_remove)
                position_contacts_for_remove = int(
                    self.get.get_value("Enter contacts number(#) for remove"))
                if position_contacts_for_remove - 1 <= len(contacts_for_remove) and position_contacts_for_remove - 1 >= 0:
                    self.phone_book_operation.remove_contact(
                        contacts_for_remove[position_contacts_for_remove - 1], self.filename)
                else:
                    self.show_menu.show_message("Wrong number...")
            elif action == "7":
                contacts = self.json_operation.read_from_json_file(
                    self.filename)
                self.xml_operation.save_to_xml_file(
                    contacts, self.filename_xml)
