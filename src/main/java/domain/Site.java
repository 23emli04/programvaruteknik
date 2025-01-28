package domain;

import java.util.List;

public class Site {
    private Location location;
    private List<Buildings> buildingsList;
    private int id;

    public Site(Location location, List<Buildings> buildingsList, int id) {
        this.id = id;
        setLocation(location);
        setBuildings(buildingsList);
    }

    public Site(Location location, List<Buildings> buildingsList) {
        setLocation(location);
        setBuildings(buildingsList);
    }

    public int getId() {
        return id;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }


    public List<Buildings> getBuildingsList() {
        return buildingsList;
    }

    public void setBuildings(List<Buildings> buildingsList) {
        this.buildingsList = buildingsList;
    }


}
