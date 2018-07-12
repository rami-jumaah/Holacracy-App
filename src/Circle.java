import java.io.Serializable;

public class Circle implements Serializable {

    public String name;
    public CirclesCollection subcircles;
    public RolesCollection roles;
    public PersonsCollection persons;

    public Circle() {
        this.name = new String();
        this.subcircles = new CirclesCollection();
        this.roles = new RolesCollection();
        this.persons = new PersonsCollection();
    }

    public void addPerson(Person person) {
        this.persons.addPerson(person);
    }

    public String getName() {
        return this.name;
    }

    public PersonsCollection getPersons() {
        return persons;
    }

    public RolesCollection getRoles() {
        return roles;
    }

    public CirclesCollection getSubcircles() {
        return subcircles;
    }

    public void setName(String name) {

        this.name = name;
    }


}
