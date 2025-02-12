package Service;

import dao.SiteDao;
import domain.Person;
import domain.Site;

public class GetSiteByPersonService {
    private Person person;

    GetSiteByPersonService(Person person) {
        this.person = person;
    }
    public Site execute(){
        return new SiteDao().get(person.getSiteId());
    }
}
