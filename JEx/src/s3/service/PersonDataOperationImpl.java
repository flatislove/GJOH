package s3.service;

import s3.model.PersonData;
import s3.model.enums.Gender;
import s3.model.exceptions.NotEnoughArgumentsException;
import s3.model.exceptions.TooManyArgumentsException;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.time.format.DateTimeFormatter;

/**
 * Implementation of the interface for working with a person data
 */
public class PersonDataOperationImpl implements PersonDataOperation {

    String filenamePath = "src/s3/files/";
    FileOperation fileOperation = new FileOperationImpl();

    @Override
    public void addContact(String person, List<PersonData> personDataList) {
        PersonData personData = null;
        try {
            personData = parseStringToPersonData(person);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        if (personData != null) {
            personDataList.add(personData);
        }
    }

    @Override
    public void savePersonsData(List<PersonData> personData) {
        try {
            fileOperation.saveToFile(filenamePath, personData);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private PersonData parseStringToPersonData(String personsData) throws Exception {
        List<String> data = List.of(personsData.split(" "));
        int expectedFieldsCount = PersonData.class.getDeclaredFields().length;
        int enterFieldsCount = data.size();

        PersonData personData = new PersonData();
        if (enterFieldsCount != expectedFieldsCount) {

            if (enterFieldsCount > expectedFieldsCount) {
                throw new TooManyArgumentsException("Too Many Arguments Exception");
            }
            throw new NotEnoughArgumentsException("Not Enough Arguments Exception");
        } else {
            String lastname = data.get(0);
            String firstname = data.get(1);
            String middlename = data.get(2);
            String birthDate = data.get(3);
            String phoneNumber = data.get(4);
            String gender = data.get(5);

            for (int i = 0; i < data.size(); i++) {
                String field = data.get(i);
                if (field.isEmpty() || field.isBlank()) {
                    throw new IllegalArgumentException(PersonData.class.getDeclaredFields()[i + 1] + " cannot be empty");
                }
            }

            personData.setLastname(lastname);
            personData.setFirstname(firstname);
            personData.setMiddlename(middlename);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

            LocalDate date;
            try {
                date = LocalDate.parse(birthDate, formatter);
            } catch (Exception e) {
                throw new DateTimeParseException("Wrong Date format: ", birthDate, 0);
            }
            personData.setBirthdate(date);

            long phone;
            if (phoneNumber.length() == 12) {
                try {
                    phone = Long.parseLong(phoneNumber);
                } catch (Exception e) {
                    throw new ParseException("Phone Number conversion error", 0);
                }
            } else {
                throw new IllegalArgumentException("Phone number must contain 12 digits");
            }
            personData.setPhoneNumber(phone);

            Gender genderVariable;
            if (gender.equalsIgnoreCase("m")) {
                genderVariable = Gender.MALE;
            } else if (gender.equalsIgnoreCase("f")) {
                genderVariable = Gender.FEMALE;
            } else {
                throw new IllegalArgumentException("Wrong gender value");
            }

            personData.setGender(genderVariable);
        }

        return personData;
    }
}
