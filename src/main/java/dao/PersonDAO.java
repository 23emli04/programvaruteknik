package dao;

import java.sql.*;


public class PersonDAO {
    private static final String INSERT_STUDENT_SQL = "INSERT INTO `Users` (student_name, age) VALUES (?, ?)";
    private static PersonDAO instance = null;

    public PersonDAO() {
    }

    public static PersonDAO getInstance() {
        if (instance == null) {
            instance = new PersonDAO();
        }
        return instance;
    }

    public void addPerson(int age, String studentName) {
        try {
            PreparedStatement preparedStatement = DbConnectionManager.getInstance()
                    .prepareStatement(INSERT_STUDENT_SQL, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, studentName);
            preparedStatement.setInt(2, age);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {

                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        long generatedId = generatedKeys.getLong(1);
                        System.out.println("Inserted student ID: " + generatedId);
                    }
                }
            } else {
                System.err.println("Inserting student failed, no rows affected.");
            }

            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println("Error inserting student: " + e.getMessage());
        }
    }


}
