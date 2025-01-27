package domain;

/**
 * En klass som beskriver en person
 *
 * @author emil
 * @version 2025-01-27
 */
public class Person {
    private int id;
    private String name;
    private int birthYear;

    public Person(int birthYear, String name) {
        setName(name);
        setBirthYear(birthYear);
    }

    public Person(int id, String name, int birthYear) {
        this.id = id;
        setName(name);
        setBirthYear(birthYear);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name.trim();
        if (checkName(name)) {
            this.name = name;
        }
        else throw new IllegalArgumentException("Incorrect name format");
    }

    private boolean checkName(String name) {
        if (name.matches("[a-zA-Z]+")) {
            return true;
        } else return false;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        if (birthYear >= 1900 && birthYear <= 2100) {
            this.birthYear = birthYear;
        }
        else throw new IllegalArgumentException("birthYear must be between 1900 and 2100");
    }

    public int getId() {
        return id;
    }


}
