import java.io.Serializable;

public class Person implements Serializable {
    public String name;
    public RolesCollection roles;


    public Person() {
        this.name = new String();
        this.roles = new RolesCollection();
    }

    public String getName() {

        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public RolesCollection getRoles() {
        return roles;
    }

    public void setRoles(RolesCollection roles) {
        this.roles = roles;
    }

}
