package spike;

import Service.PersonService;
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
        List<Person> list;
        Person person = new Person("Nisse", 2020, 3);
        PersonService personService = new PersonService();
        person = personService.save(person);
        //TODO

        list = personService.getAll();
        for (Person p : list) {
            System.out.println(p);
        }

        System.out.println(personService.getSiteByPerson(person));
        System.out.println(personService.getSiteByPersonId(2));
        //TODO
    }
}
