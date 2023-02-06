import json
from typing import List
from model.phone_contact import PhoneContact as Contact


class JsonOperation:
    """
    The class contains methods for working with a json file
    """
    def __init__(self):
        self.contacts = []

    def read_from_json_file(self, filename: str):
        """
        Method reads contacts from json file
        :param filename filename 
        """
        self.contacts = []
        try:
            with open(filename, 'r') as f:
                data = json.load(f)
                for item in data:
                    contact = Contact(
                        item['firstname'], item['lastname'], item.get('numbers', []))
                    self.add_contact(contact)
                return self.contacts
        except IOError:
            print("Error opening or reading json file")
            return []

    def save_to_json_file(self, contacts: List[Contact], filename: str):
        """
        Method saves contacts list to the json file
        :param contacts List of contacts
        :param filename String filename
        """
        try:
            with open(filename, 'w') as f:
                data = []
                for contact in contacts:
                    data.append({
                        'firstname': contact.firstname,
                        'lastname': contact.lastname,
                        'numbers': contact.numbers,
                    })
                json.dump(data, f)
        except IOError:
            print("Error opening or writing to json file")

    def add_contact(self, contact):
        self.contacts.append(contact)
