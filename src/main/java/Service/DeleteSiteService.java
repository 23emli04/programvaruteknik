package Service;

import dao.SiteDao;
import domain.Site;

public class DeleteSiteService {
    private Site site;

    public DeleteSiteService(Site site) {
        this.site = site;
    }
    public Site execute(){
       return new SiteDao().delete(site);
    }
}
