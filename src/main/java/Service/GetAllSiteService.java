package Service;

import dao.SiteDao;
import domain.Site;

import java.util.List;

public class GetAllSiteService {

    public List<Site> execute() {
        return new SiteDao().getAll();
    }
}
