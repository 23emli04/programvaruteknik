package domain;

public class Location {
    private String street;
    private String city;
    private String state;
    private int zip;
    private String country;
    private int streetNumber;
    private int locationId;

    public Location(String street, String city, String state,  String country, int zip, int streetNumber) {
        setStreet(street);
        setCity(city);
        setState(state);
        setCountry(country);
        setZip(zip);
        setStreetNumber(streetNumber);
    }

    public Location(String street, String city, String state, String country,int zip, int streetNumber, int locationId) {
        this(street, city, state, country, zip, streetNumber);
        this.locationId = locationId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        if (street != null && !street.isEmpty()) {
            this.street = street;
        } else throw new IllegalArgumentException("Street cannot be empty");
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city != null && !city.isEmpty()) {
            this.city = city.trim();
        } else throw new IllegalArgumentException("City cannot be empty");
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        if (state != null && !state.isEmpty()) {
            this.state = state.trim();
        } else throw new IllegalArgumentException("State cannot be empty");
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        if (zip > 0)
            this.zip = zip;
        else throw new IllegalArgumentException("Zip cannot be empty");
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country != null && !country.isEmpty()) {
            this.country = country.trim();
        } else throw new IllegalArgumentException("Country cannot be empty");
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        if (streetNumber > 0)
            this.streetNumber = streetNumber;
    }

    public int getLocationId() {
        return locationId;
    }
    @Override
    public String toString() {
        return String.format("Id: %d, Street: %s, Street Number: %d, City: %s, State: %s, Country: %s, Zip: %d",
                locationId, street, streetNumber, city, state, country, zip);
    }

}
