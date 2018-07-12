import java.util.List;
import java.io.Serializable;

public class HolaService implements Serializable {

    public PersonsCollection persons;
    public CirclesCollection circles;
    public RolesCollection roles;

    public HolaService() {
        this.persons = new PersonsCollection();
        this.roles = new RolesCollection();
        this.circles = new CirclesCollection();
    }

    public void addPersons(List<Person> persons) {
        this.persons.addPersons(persons);
    }

    public List<Role> getRoles() {
        return roles.getAll();
    }

    public void addRoles(List<Role> roles) {
        this.roles.addRoles(roles);
    }

    public List<Circle> getCircles() {
        return circles.getAll();
    }

    public void addCircles(List<Circle> circles) {
        this.circles.addCircles(circles);
    }



    public void createPerson(String name){

        Person pers = new Person();
        pers.setName(name);
        this.persons.addPerson(pers);

    }

    public void deletePerson(String name){

        this.persons.removePerson(name);

    }


    public List<Role> showRolesOfPerson(String name){
         return this.persons.findPersonByName(name).getRoles().getAll();

    }

    public List<Person> showPersons() {
        return this.persons.getAll();
    }

    public void createRole(String name, String purpose, String accountability){

        Role role = new Role(name, purpose,accountability);
        this.roles.addRole(role);

    }



    public List<Role> showRoles() {
        return this.roles.getAll();
    }


    public void deleteRole(String name){

        this.roles.removeRole(name);

    }

    public void addRoleToCircle(String roleName, String circleName){
        Circle circle = circles.findCircleByName(circleName);
        Role role = roles.findRoleByName(roleName);
        if (circle != null && role != null) {
            circle.roles.addRole(role);
        }else {
            System.out.println("There is no such a Circle or Role");
        }
    }

    public void addPersonToCircle(String personName, String circleName){
        Circle circle = circles.findCircleByName(circleName);
        Person person = persons.findPersonByName(personName);
        if (circle != null && person != null) {
            circle.persons.addPerson(person);
        }else {
            System.out.println("There is no such a Circle or Person");
        }
    }

    public void addRoleToPerson(String roleName, String personName){
        Person pers = persons.findPersonByName(personName);
        Role role = roles.findRoleByName(roleName);
        if (pers != null && role != null) {
            pers.roles.addRole(role);
        }else {
            System.out.println("There is no such a Person or Role");
        }
    }

    public void removeRoleFromPerson(String roleName, String personName){
        Person pers = persons.findPersonByName(personName);

        if (pers != null ){
            pers.roles.removeRole(roleName);

        }

    }

    public void createCircle(String name){

        Circle circle = new Circle();
        circle.setName(name);
        circles.addCircle(circle);

    }

    public List<Role> showRolesOfCircle(String name){
        return this.circles.findCircleByName(name).getRoles().getAll();

    }

    public void deleteCircle(String name){

        this.circles.removeCircle(name);

    }

    public List<Circle> showCircles() {
        return circles.getAll();
    }

    public void addSubcircleToCircle(String subcircleName, String circleName){
        Circle circle = circles.findCircleByName(circleName);
        Circle subcircle = circles.findCircleByName(subcircleName);
        if (circle != null && subcircle != null) {
            circle.subcircles.addCircle(subcircle);
        }else {
            System.out.println("There is no such a Circle or Subcircle");
        }
    }

    public void removeSubcircleFromCircle(String circleName){
        Circle circle = circles.findCircleByName(circleName);

        if (circle != null ){
            circle.subcircles.removeCircle(circleName);

        }

    }

    public List<Circle> showSubcirclesOfACircle(String circleName){
        return this.circles.findCircleByName(circleName).getSubcircles().getAll();

    }

}
