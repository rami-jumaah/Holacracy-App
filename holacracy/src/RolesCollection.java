import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;

public class RolesCollection implements Serializable {

    public List<Role> roles;



    public RolesCollection() {

        this.roles = new ArrayList<>();
    }

    public List<Role> getAll() {

        return this.roles;
    }
    public void addRole(Role role) {

        this.roles.add(role);
    }

    public void addRoles(List<Role> roles) {
        for (Role role : roles) {
            this.roles.add(role);
        }
    }

    public void removeRole(String roleName) {
        if (findRoleByName(roleName) != null) {
            this.roles.remove(findRoleByName(roleName));
        }

    }

    public Role findRoleByName(String roleName) {
        for (Role role : this.roles) {
            if (role.getName().equals(roleName)) {
                return role;
            }
        }
        return null;
    }
}
