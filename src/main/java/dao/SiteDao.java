package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import db.DbConnectionManager;
import domain.Site;

public class SiteDao implements Dao<Site> {
    DbConnectionManager dbConManagerSingleton = null;

    public SiteDao() {
        dbConManagerSingleton = DbConnectionManager.getInstance();
    }


    @Override
    public Site get(int id) {
        Site site = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            String query = "SELECT street, city, state, zip, country, street_number, site_id FROM lab_sites WHERE site_id = ?";
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
                int siteId = resultSet.getInt("site_id");
                site = new Site(street, city, state, country, zip, streetNumber, siteId);
            }

            dbConManagerSingleton.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return site;
    }

    @Override
    public List<Site> getAll() {
        List<Site> sites = new ArrayList<>();
        try {
            ResultSet resultSet = dbConManagerSingleton.excecuteQuery(
                    "SELECT street, city, state, country, zip, street_number, site_id FROM lab_sites");
            while (resultSet.next()) {
                String street = resultSet.getString("street");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                int zip = resultSet.getInt("zip");
                String country = resultSet.getString("country");
                int streetNumber = resultSet.getInt("street_number");
                int locationId = resultSet.getInt("site_id");
                Site site = new Site(street, city, state, country, zip, streetNumber, locationId);
                sites.add(site);
            }
            dbConManagerSingleton.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sites;
    }

    @Override
    public Site save(Site t) {
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try {
            preparedStatement = dbConManagerSingleton.prepareStatement(
                    "INSERT INTO lab_sites (street, city, state, zip, street_number, country) VALUES (?, ?, ?, ?, ?,?)",
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
                t = new Site(t.getStreet(), t.getCity(), t.getState(), t.getCountry(), t.getZip(), t.getStreetNumber(), generatedId);
            } else {
                throw new SQLException("Saving person failed, no ID obtained.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return t;
    }

    @Override
    public Site update(Site site) {
        PreparedStatement preparedStatement = null;
        String query = "UPDATE lab_sites SET street = ?, city = ?, state = ?, country = ?, zip = ?, street_number = ? " +
                "WHERE site_id = ?";

        try {
            preparedStatement = dbConManagerSingleton.prepareStatement(query);
            preparedStatement.setString(1, site.getStreet());
            preparedStatement.setString(2, site.getCity());
            preparedStatement.setString(3, site.getState());
            preparedStatement.setString(4, site.getCountry());
            preparedStatement.setInt(5, site.getZip());
            preparedStatement.setInt(6, site.getStreetNumber());
            preparedStatement.setInt(7, site.getId());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Update failed, no rows affected.");
            }
            return site;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return site;
    }


    @Override
    public Site delete(Site site) {
        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM lab_sites WHERE site_id = ?";

        try {
            preparedStatement = dbConManagerSingleton.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, site.getId());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Delete failed, no rows affected");
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return site;
    }
}
