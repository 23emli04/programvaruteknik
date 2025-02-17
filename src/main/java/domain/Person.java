package domain;

import domainHelper.NameFormatter;

import java.time.LocalDate;

import static com.sun.tools.javac.resources.CompilerProperties.Fragments.Local;

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
    private int siteId;

    public Person(String name, int birthYear) {
        setName(name);
        setBirthYear(birthYear);
    }

    public Person(int id, String name, int birthYear) {
        setId(id);
        setName(name);
        setBirthYear(birthYear);
    }

    public Person(String name, int birthYear, int siteId) {
        setName(name);
        setBirthYear(birthYear);
        setSiteId(siteId);
    }

    public Person(int id, String name, int birthYear, int siteId) {
        setId(id);
        setName(name);
        setBirthYear(birthYear);
        setSiteId(siteId);
    }

    private void setId(int id) {
        this.id = id;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }
    public int getSiteId() {
        return this.siteId;
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
        int maxBirthYear = LocalDate.now().getYear();
        int minBirthYear = maxBirthYear - 130;
        if (birthYear >= minBirthYear && birthYear <= maxBirthYear) {
            this.birthYear = birthYear;
        } else throw new IllegalArgumentException("birthYear must be between 1900 and 2100");
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Id: %d, Name: %s, Birth Year: %d, siteId: %d", id, name, birthYear, siteId);
    }


}
