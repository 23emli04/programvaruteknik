package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import db.DbConnectionManager;
import domain.Person;

/**
 * DAO for the persistent handling of a Person object. It manages all
 * CRUD operations and conversion between the object world student and
 * the relational version student (DB version).
 * Due to the use of a DbConnectionManager the DAO doesen't need to
 * use, or even know, about any of lower level connections to the Database.
 * It 'speaks' in Objects with the object world (Domain model)and in
 * relational sql strings, tables, columns and result sets with the database.
 *
 * @author awi
 */
public class PersonDao implements Dao<Person> {

    DbConnectionManager dbConManagerSingleton = null;

    public PersonDao() {
        dbConManagerSingleton = DbConnectionManager.getInstance();
    }


    public Person get(int id) throws NoSuchElementException {
        Person student = null;
        try {
            ResultSet resultSet = dbConManagerSingleton.excecuteQuery("SELECT id, name, birth_year, site_id FROM lab_persons WHERE id=" + id);
            if (!resultSet.next())
                throw new NoSuchElementException("The person with id " + id + " doesen't exist in database");
            else
                student = new Person(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
            dbConManagerSingleton.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    public List<Person> getAll() {

        List<Person> list = new ArrayList<>();

        try {
            ResultSet resultSet = dbConManagerSingleton.excecuteQuery("SELECT id, name, birth_year, site_id FROM lab_persons");
            while (resultSet.next()) {
                list.add(new Person(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4)));


            }
            dbConManagerSingleton.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Person save(Person t) {
        PreparedStatement preparedStatement = null;
        ResultSet generatedKeys = null;

        try{
            preparedStatement = dbConManagerSingleton.prepareStatement(
                    "INSERT INTO lab_persons (name, birth_year, site_id) VALUES (?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );
            preparedStatement.setString(1, t.getName());
            preparedStatement.setInt(2, t.getBirthYear());
            preparedStatement.setInt(3, t.getSiteId());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Saving person failed, no rows affected.");
            }

            generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                t = new Person(generatedId,
                        t.getName(),
                        t.getBirthYear(),
                        t.getSiteId());
            } else {
                throw new SQLException("Saving person failed, no ID obtained.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return t;
    }


    /**
     * This method uses a temporary Student set with the desired changed values.
     * It must have a 'id' that corresponds to a existing record in the database.
     *
     * @param t - an instance of a Student with new values on attributes but
     *          an 'id' identical to an existing student in the DB
     */

    public Person update(Person t) {
        PreparedStatement preparedStatement = null;

        try {
            String updateSQL = "UPDATE lab_persons SET name = ?, birth_year = ?, site_id = ? WHERE id = ?";
            preparedStatement = dbConManagerSingleton.prepareStatement(updateSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, t.getName());
            preparedStatement.setInt(2, t.getBirthYear());
            preparedStatement.setInt(3, t.getSiteId());
            preparedStatement.setInt(4, t.getId());
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows > 0){
                t = new Person(t.getId(), t.getName(), t.getBirthYear());
            }
            System.out.println("Rows updated: " + affectedRows);
        } catch (SQLException e) {
            System.err.println("Error updating person: " + e.getMessage());
        }
        return t;
    }

    public Person delete(Person t) {
        PreparedStatement preparedStatement = null;
        try {
            String deleteSQL = "DELETE FROM lab_persons WHERE id = ?";
            preparedStatement = dbConManagerSingleton.prepareStatement(deleteSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, t.getId());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Deleting person failed, no rows affected.");
            }

            return new Person(t.getId(), t.getName(), t.getBirthYear(), t.getSiteId());
        } catch (SQLException e) {
            e.printStackTrace();}
        return null;

    }

}
