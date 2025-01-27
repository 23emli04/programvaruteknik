package app;

import controller.Controller;
import dao.PersonDao;
import domain.Person;

public class Main {

    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();
        Person person = new Person(2000, "Erik");
        Person savedPerson = personDao.save(person);
        System.out.println("id:" + savedPerson.getId());


    }
}