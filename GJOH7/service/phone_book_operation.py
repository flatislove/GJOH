from model.contact import Contact
from model.phone_contact import PhoneContact
from typing import List
from service.json_operation import JsonOperation


class PhoneBookOperation():
    """
    The class contains methods for working with the phone book
    """
    file_operation = JsonOperation()

    def add_contact(self, contact: Contact, filename: str):
        """
        Adds a new contact to the phone book.
        :param contact: new contact to add
        :param filename: name of the file to save the phone book
        """
        contacts = self.file_operation.read_from_json_file(filename)
        contacts.append(contact)
        self.file_operation.save_to_json_file(contacts, filename)

    def find_by_number(self, number: str, filename: str) -> List[Contact]:
        """
        Searches for contacts by nunber.
        :param number: number to search
        :param filename: name of the file with the phone book
        :return: list of contacts with the specified name
        """
        contacts = self.file_operation.read_from_json_file(filename)
        result_list = []
        for contact in contacts:
            if isinstance(contact, PhoneContact):
                for phone in contact.get_phones():
                    if number in phone['number']:
                        result_list.append(contact)
        return result_list

    def find_by_name(self, name: str, filename: str) -> List[Contact]:
        """
        Searches for contacts by name.
        :param name: name to search
        :param filename: name of the file with the phone book
        :return: list of contacts with the specified name
        """
        contacts = self.file_operation.read_from_json_file(filename)
        result_list = []
        for contact in contacts:
            if name in contact.get_firstname() or name in contact.get_lastname():
                result_list.append(contact)
        return result_list

    def remove_contact(self, contact: Contact, filename: str):
        """
        Removes a contact from the phone book.
        :param contact: contact to remove
        :param filename: name of the file with the phone book
        """
        contacts: List[Contact] = self.file_operation.read_from_json_file(
            filename)
        for i in range(len(contacts)):
            if contacts[i].get_firstname() == contact.get_firstname() and contacts[i].get_lastname() == contact.get_lastname():
                contacts.pop(i)
                break
        self.file_operation.save_to_json_file(contacts, filename)
