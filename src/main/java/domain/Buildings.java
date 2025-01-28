package domain;

import domainHelper.NameFormatter;
import java.util.List;

public class Buildings {
    private List<Rooms> roomsList;
    private int id;
    private String name;
    private Location location;

    public Buildings(List<Rooms> roomsList, int id, Location location) {
        this.roomsList = roomsList;
        this.id = id;
    }
    public Buildings(String name, List<Rooms> roomsList, Location location) {
        this.roomsList = roomsList;
        this.name = name;
        this.location = location;
    }

    public Buildings(List<Rooms> roomsList, int id, String name, Location location) {
        this.roomsList = roomsList;
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    public void setAddress(String address) {

    }

    public List<Rooms> getRoomsList() {
        return roomsList;
    }

    public void setRoomsList(List<Rooms> roomsList) {
        this.roomsList = roomsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
