import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;

public class PersonsCollection implements Serializable {
    public List<Person> persons;

    public PersonsCollection() {

        this.persons = new ArrayList<>();
    }

    public List<Person> getAll() {

        return this.persons;
    }
    
    public void addPerson(Person person) {

        this.persons.add(person);
    }

    public void addPersons(List<Person> persons) {
        for (Person person : persons) {
            this.persons.add(person);
        }
    }

    public void removePerson(String personName) {
        if (findPersonByName(personName) != null) {
            this.persons.remove(findPersonByName(personName));
        }

    }

    public Person findPersonByName(String personName) {
        for (Person person : this.persons) {
            if (person.getName().equals(personName)) {
                return person;
            }
        }
        return null;
    }
}
