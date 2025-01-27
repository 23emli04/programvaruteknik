package controller;

import dao.PersonDao;
import domain.Person;

public class Controller {
    PersonDao personDao = new PersonDao();

    public Person addUser(Person person) {
        return personDao.save(person);
    }
}
