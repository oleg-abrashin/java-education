package tests.persons;

import org.junit.Before;
import org.junit.Test;
import persons.Person;

import static org.junit.Assert.*;

public class PersonTest {
    private static final long ID1 = 123;
    private static final String NAME1 = "Moshe";
    private static final String CITY1 = "Haifa";
    private static final String NAME2 = "Vasya";
    private static final String CITY2 = "Tel Aviv";

    Person person1;

    @Before
    public void setUp() throws Exception {
        person1 = new Person(ID1, NAME1, CITY1);
    }

    @Test
    public void getId() {
        assertEquals(ID1, person1.getId());
    }

    @Test
    public void getName() {
        assertEquals(NAME1, person1.getName());
    }

    @Test
    public void setName() {
        person1.setName(NAME2);
        assertEquals(NAME2, person1.getName());
    }

    @Test
    public void getCity() {
        assertEquals(CITY1, person1.getCity());
    }

    @Test
    public void setCity() {
        person1.setCity(CITY2);
        assertEquals(CITY2, person1.getCity());
    }
}