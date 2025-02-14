package Service;

import domain.Site;
import dao.SiteDao;

public class SaveSiteService {
    private Site site;

    public SaveSiteService(Site site) {
        this.site = site;
    }
    public Site execute() {
        return new SiteDao().save(this.site);
    }
}
