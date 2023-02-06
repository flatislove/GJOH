class GetMenu:
    """
    The class contains method for getting values
    """
    def get_value(self, message):
        print(f"{message}: ", end="")
        return input()
