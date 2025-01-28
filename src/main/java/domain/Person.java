package domain;

import domainHelper.NameFormatter;

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
        setId(id);
        setName(name);
        setBirthYear(birthYear);
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = NameFormatter.formatName(name);
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        if (birthYear >= 1900 && birthYear <= 2100) {
            this.birthYear = birthYear;
        } else throw new IllegalArgumentException("birthYear must be between 1900 and 2100");
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Id: %d, Name: %s, Birth Year: %d", id, name, birthYear);
    }


}
