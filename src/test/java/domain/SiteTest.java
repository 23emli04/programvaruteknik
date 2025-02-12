package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SiteTest {
    Site site;

    @BeforeEach
    void setUp() {
        site = new Site("Testvägen", "Test Stad", "Test Kommun", "Test Land", 111,111);
    }
    @AfterEach
    void tearDown() {
        site = null;
    }

    @Test
    void getStreet() {
        assertEquals("Testvägen", site.getStreet());
    }

    @Test
    void setStreet() {
        assertThrows(IllegalArgumentException.class, () -> site.setStreet("1293"));
        site.setStreet("TEST TEST");
        assertEquals("Test Test", site.getStreet());
        assertThrows(IllegalArgumentException.class, () -> site.setStreet(""));

    }

    @Test
    void getCity() {
        assertEquals("Test Stad", site.getCity());
    }

    @Test
    void setCity() {
        assertThrows(IllegalArgumentException.class, () -> site.setCity("1234"));
        site.setCity("TEST TEST");
        assertEquals("Test Test", site.getCity());
        assertThrows(IllegalArgumentException.class, () -> site.setCity(""));
    }

    @Test
    void getState() {
        assertEquals("Test Kommun", site.getState());
    }

    @Test
    void setState() {
        assertThrows(IllegalArgumentException.class, () -> site.setState("1234"));
        site.setState("TEST TEST");
        assertEquals("Test Test", site.getState());
        assertThrows(IllegalArgumentException.class, () -> site.setState(""));
    }

    @Test
    void getZip() {
        assertEquals(111, site.getZip());
    }

    @Test
    void setZip() {
        assertThrows(IllegalArgumentException.class, () -> site.setZip(-1));
        site.setZip(111);
        assertEquals(111, site.getZip());
    }

    @Test
    void getCountry() {
        assertEquals("Test Land", site.getCountry());
        assertThrows(IllegalArgumentException.class, () -> site.setCountry("1234"));
    }

    @Test
    void setCountry() {
        assertThrows(IllegalArgumentException.class, () -> site.setCountry(""));
        site.setCountry("TEST TEST");
        assertEquals("Test Test", site.getCountry());
    }

    @Test
    void getStreetNumber() {
        assertEquals(111, site.getStreetNumber());

    }

    @Test
    void setStreetNumber() {
        assertThrows(IllegalArgumentException.class, () -> site.setStreetNumber(-1));
        site.setStreetNumber(111);
        assertEquals(111, site.getStreetNumber());
    }

    @Test
    void testToString() {
        assertEquals("Id: 0, Street: Testvägen, Street Number: 111, City: Test Stad, State: Test Kommun, Country: Test Land, Zip: 111", site.toString());
    }
}