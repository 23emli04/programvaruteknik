package spike;
import dao.SiteDao;

import domain.Site;

import java.util.List;

/**
 * En klass som testar SiteDao.6
 * @Author Emil
 * @Version 2025-01-28
 */

public class SpikeLocation {
    public static void main(String[] args) {
        SiteDao locationDao = new SiteDao();
        Site location = new Site("Måssvängsvägen", "Springfield", "ILannois", "USAs",62701, 123);
        locationDao.save(location);
        List<Site> list = locationDao.getAll();
        for (Site locations : list) {
            System.out.println(locations);
        }
    }
}
