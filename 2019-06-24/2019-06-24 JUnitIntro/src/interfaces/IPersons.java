package interfaces;

import persons.Person;

public interface IPersons {
    boolean addPerson(Person person);

    boolean removePerson(long id);

    boolean updatePersonCity(long id, String city);

    int size(); // Returns amount of persons

    Person getPerson(long id);

    Iterable<Person> getAllPersons();

    Person[] getPersonsByCity(String city);
}
