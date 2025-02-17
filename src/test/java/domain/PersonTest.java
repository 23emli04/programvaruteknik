package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person wPerson;

    @BeforeEach
    void setUp() {
        wPerson = new Person("Nisse", 2019,1);
    }
    @AfterEach
    void tearDown() {
        wPerson = null;
    }
    @Test
    void getName() {
        assertEquals("Nisse", wPerson.getName());
    }
    @Test
    void setNameWithNumbers() {
        assertThrows(IllegalArgumentException.class, () -> wPerson.setName("999"));
    }
    @Test
    void setNameWithCapitalLetters() {
        wPerson.setName("NISSE ERIKSSON");
        assertEquals("Nisse Eriksson", wPerson.getName());
    }
    @Test
    void setNameWithMultipleSpaces() {
        wPerson.setName("Nisse      Eriksson");
        assertEquals("Nisse Eriksson", wPerson.getName());
    }
    @Test
    void setNameWithNumbersAndCapitalLetters() {
        assertThrows(IllegalArgumentException.class, () -> wPerson.setName("Nisse123 Eriksson"));
    }
    @Test
    void setNameWithTwoCharacters() {
       assertThrows(IllegalArgumentException.class, () -> wPerson.setName("Ye"));
    }
    @Test
    void setNameEasy(){
        wPerson.setName("Erik");
        assertEquals("Erik", wPerson.getName());
    }
    @Test
    void setNameMedium(){
        wPerson.setName("Kalle Karlsson");
        assertEquals("Kalle Karlsson", wPerson.getName());
    }
    @Test
    void setNameAsNull(){
        assertThrows(IllegalArgumentException.class, () -> wPerson.setName(null));
    }
    @Test
    void getBirthYear() {
        assertEquals(2019, wPerson.getBirthYear());
    }
    @Test
    void setBirthYearBeyondScope() {
        assertThrows(IllegalArgumentException.class, () -> wPerson.setBirthYear(2200));
    }
    @Test
    void setCorrectBirthYear() {
        wPerson.setBirthYear(1999);
        assertEquals(1999, wPerson.getBirthYear());
    }
    @Test
    void setBirthYearWithCharacters(){
        assertThrows(IllegalArgumentException.class, () -> wPerson.setBirthYear('A'));
    }
    @Test
    void testToString() {
        assertEquals("Id: 0, Name: Nisse, Birth Year: 2019, siteId: 1", wPerson.toString());
    }
    @Test
    void createPersonWithBadInputs(){
        assertThrows(IllegalArgumentException.class, () -> wPerson = new Person("134",2,1));

    }
}