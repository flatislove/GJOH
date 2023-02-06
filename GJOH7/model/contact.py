import uuid


class Contact:
    """
    The class represents any contact
    """
    firstname: str
    lastname: str

    def __init__(self, firstname, lastname):
        self.id = uuid.uuid4()
        self.firstname = firstname
        self.lastname = lastname

    def get_id(self):
        return self.id

    def get_firstname(self):
        return self.firstname

    def get_lastname(self):
        return self.lastname

    def __str__(self):
        return self.firstname + " " + self.lastname
