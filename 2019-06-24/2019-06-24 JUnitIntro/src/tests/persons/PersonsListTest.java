package tests.persons;

import interfaces.IPersons;
import org.junit.*;
import persons.Person;
import persons.PersonsArrayList;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PersonsListTest {

    private static final long ID1 = 123;
    private static final long ID2 = 234;
    private static final long ID3 = 345;
    private static final long IDN = 000;

    private static final String NAME1 = "Abc";
    private static final String NAME2 = "Bcd";
    private static final String NAME3 = "Cde";
    private static final String NAMEN = "New";

    private static final String CITY1 = "Zyx";
    private static final String CITY2 = "Yxw";
    private static final String CITY3 = "Xwv";
    private static final String CITYN = "New city";

    Person person1;
    Person person2;
    Person person3;

    IPersons persons;

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("setUpClass() running");
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("tearDownClass() running");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("setUp() running");
        person1 = new Person(ID1, NAME1, CITY1);
        person2 = new Person(ID2, NAME2, CITY2);
        person3 = new Person(ID3, NAME3, CITY2);
        persons = new PersonsArrayList();
        persons.addPerson(person1);
        persons.addPerson(person2);
        persons.addPerson(person3);
    }

    @After
    public void tearDown() throws Exception{
        System.out.println("tearDown() running");
    }

    @Test
    public void addPerson() {
        assertFalse(persons.addPerson(person1));
        Person newPerson = new Person(IDN, NAMEN, CITYN);
        assertTrue(persons.addPerson(newPerson));
        assertEquals(newPerson, persons.getPerson(IDN));
    }

    @Test
    public void removePerson() {
        assertFalse(persons.removePerson(IDN));
        assertTrue(persons.removePerson(ID1));
        assertNull(persons.getPerson(ID1));
    }

    @Test
    public void updatePersonCity() {
        assertTrue(persons.updatePersonCity(ID3, CITY1));
        assertEquals(CITY1, persons.getPerson(ID3).getCity());
    }

    @Test
    public void size() {
        assertEquals(3, persons.size());
    }

    @Test
    public void getPerson() {
        assertNull(persons.getPerson(IDN));
        assertEquals(person1, persons.getPerson(ID1));
    }

    @Test
    public void getAllPersons() {
        ArrayList<Person> listPersons = getListPersons();
        for (Person person : persons.getAllPersons()) {
            assertTrue(listPersons.contains(person));
            listPersons.remove(person);
        }
        assertTrue(listPersons.isEmpty());
    }

    private ArrayList<Person> getListPersons() {
        ArrayList<Person> res = new ArrayList<>();
        res.add(person1);
        res.add(person2);
        res.add(person3);
        return res;
    }

    @Test
    public void getPersonsByCity() {
        Person[] arExpected = {
                person2, person3
        };
        Person[] actual = persons.getPersonsByCity(CITY2);
        Arrays.sort(actual);
        assertArrayEquals(arExpected, actual);
    }
}