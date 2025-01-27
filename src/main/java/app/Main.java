package app;


import dao.PersonDao;
import domain.Person;

public class Main {

    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();
        Person person1 = new Person(2001, "Erik");
        Person savedPerson1 = personDao.save(person1);
        Person person2 = new Person(2002, "Filip");
        Person savedPerson2 = personDao.save(person2);
        Person person3 = new Person(2003, "Gustav");
        Person savedPerson3 = personDao.save(person3);




    }
}