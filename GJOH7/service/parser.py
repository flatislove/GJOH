from model.phone_contact import PhoneContact
from model.enums.tag import Tag
from model.phone_contact import PhoneContact as Contact


class Parser:
    """
    The class contains methods for parsing values for contacts
    """
    @staticmethod
    def map_to_contact(values: dict) -> 'PhoneContact':
        """
        Method creates contact from dictionary values
        :param dictionary values
        """
        phone_numbers = []
        if 'numbers' in values:
            for phone_number_values in values['numbers']:
                phone_numbers.append({
                    'number': str(phone_number_values['number']),
                    'tag': str(phone_number_values['tag'])
                })
        return PhoneContact(
            str(values['firstname']),
            str(values['lastname']),
            phone_numbers
        )

    @staticmethod
    def get_dict_from_contact(contact: 'Contact') -> dict:
        """
        Method creates dictionary from contact
        :param dictionary values
        """
        return {
            'id': str(contact.get_id()),
            'firstname': contact.get_firstname(),
            'lastname': contact.get_lastname(),
        }

    @staticmethod
    def get_tag_by_object(o) -> 'Tag':
        for tag in Tag:
            if str(o) == tag.name:
                return tag
        return Tag.PRIVATE
