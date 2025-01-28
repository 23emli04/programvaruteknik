package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import db.DbConnectionManager;
import domain.Location;
import domain.Person;

public class LocationDao implements Dao<Location> {
    DbConnectionManager dbConManagerSingleton = null;

    public LocationDao() {
        dbConManagerSingleton = DbConnectionManager.getInstance();
    }


    @Override
    public Location get(int id) {
        Location location = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            String query = "SELECT street, city, state, zip, country, street_number, location_id FROM lab_locations WHERE id = ?";
            preparedStatement = dbConManagerSingleton.prepareStatement(query, id);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next())
                throw new NoSuchElementException("The location with id " + id + " doesen't exist in database");
            else {
                String street = resultSet.getString("street");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                int zip = resultSet.getInt("zip");
                String country = resultSet.getString("country");
                int streetNumber = resultSet.getInt("street_number");
                int locationId = resultSet.getInt("location_id");
                location = new Location(street, city, state, country, zip, streetNumber, locationId);
            }

            dbConManagerSingleton.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return location;
    }

    @Override
    public List<Location> getAll() {
        List<Location> locations = new ArrayList<>();
        try {
            ResultSet resultSet = dbConManagerSingleton.excecuteQuery(
                    "SELECT street, city, state, country, zip, street_number, location_id FROM lab_locations");
            while (resultSet.next()) {
                String street = resultSet.getString("street");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                int zip = resultSet.getInt("zip");
                String country = resultSet.getString("country");
                int streetNumber = resultSet.getInt("street_number");
                int locationId = resultSet.getInt("location_id");
                Location location = new Location(street, city, state, country, zip, streetNumber, locationId);
                locations.add(location);
            }
            dbConManagerSingleton.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locations;
    }

    @Override
    public Location save(Location t) {
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try {
            preparedStatement = dbConManagerSingleton.prepareStatement(
                    "INSERT INTO lab_locations (street, city, state, zip, street_number, country) VALUES (?, ?, ?, ?, ?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );
            preparedStatement.setString(1, t.getStreet());
            preparedStatement.setString(2, t.getCity());
            preparedStatement.setString(3, t.getState());
            preparedStatement.setInt(4, t.getZip());
            preparedStatement.setInt(5, t.getStreetNumber());
            preparedStatement.setString(6, t.getCountry());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Saving person failed, no rows affected.");
            }

            generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                t = new Location(t.getStreet(), t.getCity(), t.getState(), t.getCountry(), t.getZip(), t.getStreetNumber(), generatedId);
            } else {
                throw new SQLException("Saving person failed, no ID obtained.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return t;
    }

    @Override
    public Location update(Location location) {
        return null;
    }

    @Override
    public Location delete(Location location) {
        return null;
    }
}
