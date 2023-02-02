package task2.service;

import task2.model.PhoneContact;
import task2.model.enums.Tag;

import java.util.Map;

/**
 * The class contains methods for parsing values for contacts
 */
public class Parser {

    /**
     * Method creates contact from HashMap values
     *
     * @param values HashMap values
     * @return PhoneContact object
     */
    public PhoneContact mapToContact(Map<String, Object> values) {
        return new PhoneContact(
                values.get("firstname").toString(),
                values.get("lastname").toString(),
                values.get("phone").toString(),
                getTagByObject(values.get("tag")));
    }

    /**
     * Method creates Tag object from Object
     *
     * @param o object
     * @return Tag enum
     */
    public Tag getTagByObject(Object o) {
        for (int i = 0; i < Tag.values().length; i++) {
            if (o!=null && o.toString().equals(Tag.values()[i].toString())) {
                return Tag.values()[i];
            }
        }
        return Tag.PRIVATE;
    }
}
