package spike;
import dao.SiteDao;

import domain.Site;

import java.util.List;

/**
 * En klass som testar SiteDao
 * @Author Emil
 * @Version 2025-01-28
 */

public class SpikeLocation {
    public static void main(String[] args) {
        SiteDao siteDao = new SiteDao();
        Site location = new Site("Måssvängsvägen", "Springfield", "ILannois", "USAs",62701, 123);
        location = siteDao.save(location);

        System.out.println("-----TEST SAVE--------");
        List<Site> list = siteDao.getAll();
        for (Site locations : list) {
            System.out.println(locations);
        }
        //AHA, eftersom att denna site inte fått sitt id tilldelat kan den därmed inte
        //updatera och därför funkar inte denna metod!


        System.out.println("------TEST UPDATE--------");
        location.setStreet("Testvägen");
        location.setCity("Washington");
        location.setCountry("Spain");
        location.setZip(8000);
        location.setStreetNumber(43);
        location =  siteDao.update(location);
        list = siteDao.getAll();
        for (Site locations : list) {
            System.out.println(locations);
        }

        System.out.println("------TEST DELETE--------");
        siteDao.delete(location);
        list = siteDao.getAll();
        for (Site locations : list) {
            System.out.println(locations);
        }

        /**
         * Tests worked, more tests with more locations,,,,
         */
        Site location2 = new Site("Måssvängsvägen", "Springfield", "ILannois", "USAs",62701, 123);
        location2 = siteDao.save(location2);
        Site location3 = new Site("Test", "Test", "Gävle", "USAs", 222, 222);
        location3 = siteDao.save(location3);
        System.out.println("-----SECOND TESTS HERE--------\n");
        System.out.println("-----TEST SAVE2--------");
        list = siteDao.getAll();
        for (Site locations : list) {
            System.out.println(locations);
        }

        System.out.println("------TEST UPDATE2--------");
        location2.setStreet("Testvägen");
        location2.setCity("Washington");
        location2.setCountry("Spain");
        location2.setZip(8000);
        location2.setStreetNumber(43);
        location2 =  siteDao.update(location2);
        //************************
        location3.setStreet("Testvägen");
        location3.setCity("Washington");
        location3.setCountry("Spain");
        location3.setZip(8000);
        location3.setStreetNumber(43);
        location3 =  siteDao.update(location3);
        list = siteDao.getAll();
        for (Site locations : list) {
            System.out.println(locations);
        }

        System.out.println("------TEST DELETE2--------");
        siteDao.delete(location2);
        list = siteDao.getAll();
        for (Site locations : list) {
            System.out.println(locations);
        }

        /**
         * Nöjd med samtliga tester.
         */

    }
}
