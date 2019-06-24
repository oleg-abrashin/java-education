package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import persons.Person;

import static org.junit.Assert.*;

public class PersonTestTest{

    private static final long ID1 = 1;
    private static final String NAME1 = "Adam";
    private static final String CITY1 = "Edem";

    private static final long ID2 = 2;
    private static final String NAME2 = "Eva";
    private static final String CITY2 = "Tel-Aviv";

    Person person1;

    @Before
    public void setUp() throws Exception {
        person1 = new Person(ID1,NAME1,CITY1);
    }

    @After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void testPerson(){
        Person person2 = new Person(ID1,NAME1,CITY1);
        assertNotEquals(person1,5);
        assertEquals(person1,person2);
    }

    @org.junit.Test
    public void testGetId(){
        assertEquals(ID1,person1.getId());
    }

    @org.junit.Test
    public void testGetName(){
        assertEquals(NAME1,person1.getName());
    }

    @org.junit.Test
    public void testGetCity(){
        assertEquals(CITY1,person1.getCity());
    }

    @org.junit.Test
    public void setName() {
        person1.setName(NAME2);
        assertEquals(NAME2, person1.getName());
    }

    @org.junit.Test
    public void setCity() {
        person1.setCity(CITY2);
        assertEquals(CITY2, person1.getCity());
    }

}