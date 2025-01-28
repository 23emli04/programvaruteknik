package spike;
import dao.LocationDao;
import domain.Location;

import java.util.List;

public class SpikeLocation {
    public static void main(String[] args) {
        LocationDao locationDao = new LocationDao();
        Location location = new Location("123 Main St", "Springfield", "ILannois", "USA",62701, 123);
        locationDao.save(location);
        List<Location> list = locationDao.getAll();
        for (Location locations : list) {
            System.out.println(locations);
        }
    }
}
