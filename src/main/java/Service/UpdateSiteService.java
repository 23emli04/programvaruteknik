package Service;

import dao.SiteDao;
import domain.Site;

public class UpdateSiteService {
    private Site site;
    public UpdateSiteService(Site site) {
        this.site = site;
    }
    public Site execute(){
        return new SiteDao().update(site);
    }
}
