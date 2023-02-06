import os
from model.enums.tag import Tag


class Menu:
    """
    The class contains main methods for working with a menu
    """
    def clear(self):
        os.system('clear')

    def show_menu(self):
        """
        Method shows main menu to the console
        """
        while True:
            print("Choose operation:")
            print("1 - See phone book")
            print("2 - Add contact")
            print("3 - Find by number")
            print("4 - Find by name")
            print("5 - Remove contact")
            print("6 - Save book to XML")
            print("0 - exit")
            action = input("Enter the action: ")
            if action in ["0", "1", "2", "3", "4", "5", "6"] and len(action) == 1:
                return action

    def show_contacts(self, contacts):
        """
        Method shows contacts to the console
        :param contact List of contacts
        """
        if contacts == []:
            print("Contacts list is empty")
        for i, contact in enumerate(contacts):
            print("#: {} {}".format(i + 1, contact))

    def show_tags(self):
        """
        Method shows all tags for phone numbers
        """
        tags = {i: tag for i, tag in enumerate(Tag.__members__.values())}
        return tags

    def get_contacts_values(self):
        """
        Methods gets all values to the Contact
        """
        values = {}
        values["firstname"] = input("Enter firstname: ")
        values["lastname"] = input("Enter lastname: ")
        values["numbers"] = []
        while True:
            print("Press enter to enter to finish")
            number = input("Enter phone number: ")
            if number == "":
                break
            print(self.show_tags())
            tag = int(input("Enter tag number: "))
            values["numbers"].append({
                "number": number,
                "tag": self.show_tags()[tag]
            })
        return values
