package Service;

import dao.PersonDao;
import dao.SiteDao;
import domain.Person;
import domain.Site;

public class GetSiteByPersonIdService {
    private Person person;

    public GetSiteByPersonIdService(int personId) {
       this.person = new PersonDao().get(personId);

    }
    public Site execute() {
        return new SiteDao().get(person.getSiteId());
    }
}
