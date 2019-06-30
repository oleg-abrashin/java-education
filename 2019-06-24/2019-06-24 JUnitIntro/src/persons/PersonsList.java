package persons;

import interfaces.IPersons;

import java.util.ArrayList;
import java.util.List;

public abstract class PersonsList implements IPersons {

    List<Person> persons;

    @Override
    public boolean addPerson(Person person) {
        if (persons.contains(person)) {
            return false;
        }
        return persons.add(person);
    }

    @Override
    public boolean removePerson(long id) {
        Person pattern = new Person(id, null, null);
        return persons.remove(pattern);
    }

    @Override
    public boolean updatePersonCity(long id, String city) {
        Person person = getPerson(id);
        if (person == null){
            return false;
        }
        person.setCity(city);
        return true;
    }

    @Override
    public int size() {
        return persons.size();
    }

    @Override
    public Person getPerson(long id) {
        for (Person person :
                persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Iterable<Person> getAllPersons() {
        return persons;
    }

    @Override
    public Person[] getPersonsByCity(String city) {
        ArrayList<Person> res = new ArrayList<>();
        for (Person person:
                persons) {
            if (person.getCity().equals(city)){
                res.add(person);
            }
        }
        return res.toArray(new Person[0]);
    }
}
