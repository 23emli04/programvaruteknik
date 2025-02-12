package Service;
import dao.SiteDao;
import domain.Site;

/**
 * Klass som returnerar en Site med id.
 * @author Emil
 */
public class GetSiteBySiteIdService {

    private int siteId;

    public GetSiteBySiteIdService(int siteId) {
        this.siteId = siteId;
    }

    public Site execute(){
       return new SiteDao().get(siteId);
    }
}
