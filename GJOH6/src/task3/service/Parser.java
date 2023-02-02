package task3.service;

import task3.model.Department;
import task3.model.Employee;
import task3.model.Person;
import task3.model.enums.Position;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * The class contains parsing methods
 */
public class Parser {

    /**
     * Method created Person object from Map
     *
     * @param map         values for Person
     * @param departments List of departments
     * @param positions   List of positions
     * @return Person object
     */
    public Person getEmployeeFromMap(Map<String, Object> map, List<Department> departments, List<Position> positions) {
        return new Employee(
                map.get("firstname").toString(),
                map.get("lastname").toString(),
                departments.get(Integer.parseInt(map.get("department").toString()) - 1),
                positions.get(Integer.parseInt(map.get("position").toString()) - 1),
                getDateFromString(map.get("date").toString()));
    }

    /**
     * Method creates Date object from String
     *
     * @param date String date
     * @return Date object
     */
    private Date getDateFromString(String date) {
        Date date1 = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date1 = formatDate.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return date1;
        }
        return date1;
    }
}
