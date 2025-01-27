package spike;

import db.DbConnectionManager;
import domain.Person;

import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author awi
 */
public class Spike1 {

    public static void main(String[] args) {
        DbConnectionManager dbConManagerSingleton = DbConnectionManager.getInstance();
        ArrayList<Person> list = new ArrayList<>();

        try {
            ResultSet resultSet = dbConManagerSingleton.excecuteQuery("SELECT id, name, birth_year FROM lab_persons");
            while (resultSet.next()) {
                String name = resultSet.getString(2).trim();
                System.out.printf("Id: %d, Name: %s, Birth year: %d\n",
                        resultSet.getInt(1),
                        name,
                        resultSet.getInt(3));
            // Debug kod har legat här
            }
            dbConManagerSingleton.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
      // Debug kod har legat här
    }
}

// Reservplats för kod som hälper till att debugga encoding problem med å, ä och ö.

/*    byte[] bytes = name.getBytes(StandardCharsets.UTF_8);
                StringBuilder hexString = new StringBuilder();
                for (byte b : bytes) {
                    hexString.append(String.format("%02X", b));
                }

                System.out.println("Name in HEX: " + hexString);
                for (int i = 0; i < name.length(); i++) {
                    char c = name.charAt(i);
                    System.out.printf("Char: %c, Unicode: %04x%n", c, (int) c);
                }*/
//  System.out.println("Default Charset: " + java.nio.charset.Charset.defaultCharset());
//  System.out.println("file.encoding: " + System.getProperty("file.encoding"));