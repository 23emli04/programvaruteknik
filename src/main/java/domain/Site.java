package domain;

import domainHelper.NameFormatter;

/**
 * En klass för en "site" som fungerar som en stor adress, med diverse attribut.
 * Syftar till att vara en arbetsplats entitet.
 * //TODO skapa fler attribut som t.ex CiteManager, CiteOwner osv.
 *
 * @Author Emil Lindström Moffatt
 * @Version 2025-01-28
 */

public class Site {
    private String street;
    private String city;
    private String state;
    private int zip;
    private String country;
    private int streetNumber;
    private int siteId;


    public Site(String street, String city, String state, String country, int zip, int streetNumber) {
        setStreet(street);
        setCity(city);
        setState(state);
        setCountry(country);
        setZip(zip);
        setStreetNumber(streetNumber);
    }

    public Site(String street, String city, String state, String country, int zip, int streetNumber, int siteId) {
        this(street, city, state, country, zip, streetNumber);
        this.siteId = siteId;
    }

    public String getStreet() {
        return street;
    }

    /**
     * Metod som ändrar gatunamnet och använder NameFormatter för att se till att namnet blir
     * någolunda formatterat.
     *
     * @param street ett korrekt gatunamn.
     * @see NameFormatter
     */
    public void setStreet(String street) {
        if (street != null && !street.isEmpty()) {
            this.street = NameFormatter.formatName(street);
        } else throw new IllegalArgumentException("Street cannot be empty");
    }

    public String getCity() {
        return city;
    }

    /**
     * Metod som ändrar stadsnamnet och använder NameFormatter för att se till att namnet blir
     * någolunda formatterat.
     *
     * @param city ett korrekt gatunamn.
     * @see NameFormatter
     */
    public void setCity(String city) {
        if (city != null && !city.isEmpty()) {
            this.city = NameFormatter.formatName(city);
        } else throw new IllegalArgumentException("City cannot be empty");
    }

    public String getState() {
        return state;
    }

    /**
     * Metod som ändrar kommunnamnet och använder NameFormatter för att se till att namnet blir
     * någolunda formatterat.
     *
     * @param state ett korrekt kommunnamn.
     * @see NameFormatter
     */

    public void setState(String state) {
        if (state != null && !state.isEmpty()) {
            this.state = NameFormatter.formatName(state);
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

    /**
     * Metod som ändrar landnamnet och använder NameFormatter för att se till att namnet blir
     * någolunda formatterat.
     *
     * @param country ett korrekt land.
     * @see NameFormatter
     */

    public void setCountry(String country) {
        if (country != null && !country.isEmpty()) {
            this.country = NameFormatter.formatName(country);
        } else throw new IllegalArgumentException("Country cannot be empty");
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        if (streetNumber > 0)
            this.streetNumber = streetNumber;
    }

    public int getId() {
        return siteId;
    }

    @Override
    public String toString() {
        return String.format("Id: %d, Street: %s, Street Number: %d, City: %s, State: %s, Country: %s, Zip: %d",
                siteId, street, streetNumber, city, state, country, zip);
    }

}
