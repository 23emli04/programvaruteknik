package Service;

import dao.PersonDao;
import dao.SiteDao;
import domain.Person;
import domain.Site;

import java.util.List;
import java.util.stream.Collector;

/**
 * Klass som egentligen bara vidare befordrar till PersonDAO
 * @author Emil Lindström Moffatt
 *
 */

public class PersonService {

    public Person getPersonById(int id) {
       return new PersonDao().get(id);
    }
    public List<Person> getAll() {
        return new PersonDao().getAll();
    }
    public Person save(Person person) {
       return new PersonDao().save(person);
    }
    public Person update(Person person) {
        return new PersonDao().update(person);
    }

    public Site getSiteByPerson(Person person) {
          Site site = new SiteDao().get(person.getSiteId());
          return site;

    }
    public Site getSiteByPersonId(int id) {
        Person person = new PersonDao().get(id);
        return getSiteByPerson(person);
    }
}
