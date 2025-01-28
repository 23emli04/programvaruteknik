package spike;

import dao.PersonDao;
import db.DbConnectionManager;
import domain.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Demo test på högsta nivå
 *
 * @author Emil Lindström Moffatt
 * @Version 2025-01-27
 */

public class Spike2 {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();
        List<Person> list;
        Person persone = new Person(2000,"Nisse");
        personDao.save(persone);
        list = personDao.getAll();
        for (Person person : list) {
            System.out.println(person);
        }
    }
}
