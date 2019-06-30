package persons;

public class Person implements Comparable<Person> {
    long id;
    String name;
    String city;

    public Person(long id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object person) {
        return person instanceof Person ? this.id == ((Person) person).id : false;
    }

    @Override
    public int compareTo(Person o) {
        return Long.compare(this.id, o.id);
    }
}
