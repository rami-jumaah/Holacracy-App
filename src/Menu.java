import java.util.List;
import java.util.Scanner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Menu {

    private HolaService holaService;

    public Menu() {
        this.holaService = new HolaService();
        this.loadHolaService();
    }

    public void saveHolaService() {
        try {
            // save holaService
            FileOutputStream fos = new FileOutputStream("holaService.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.holaService);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadHolaService() {
        try {
            // read object from file
            FileInputStream fis = new FileInputStream("holaService.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.holaService = (HolaService) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // show the main menu
    public void show() {
        System.out.println("What do you want to do?\n");
        System.out.println("Press 1 for showing the current holaservice state");
        System.out.println("Press 2 to create holaservice content");
        System.out.println("Press 3 to edit holaservice content");

        String answer = "";
        Scanner scanner = new Scanner(System.in);

        while (answer.equals("")) {
            answer = scanner.next();

            switch (answer) {
                case "1":
                    this.showCurrentEntries();
                    break;
                case "2":
                    this.createEntries();
                    break;
                case "3":
                    this.editEntries();
                    break;
                default:
                    answer = "";
                    break;
            }
        }
    }
    // choosing 1 to show current entries
    public void showCurrentEntries() {
        List<Circle> allCircles = this.holaService.showCircles();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nList of all circles: ");

        for (Circle circle : allCircles){
            System.out.print("Name: ");
            System.out.println(circle.getName());

            System.out.println("-- Roles: ");

            for (Role role : this.holaService.showRolesOfCircle(circle.getName())){
                System.out.print("----- * ");
                System.out.println(role.getName() + "\n");


            }

            System.out.println("-- Subcircles: ");

            for (Circle subcircle : this.holaService.showSubcirclesOfACircle(circle.getName())){
                System.out.print("----- * ");
                System.out.println(subcircle.getName() + "\n");


            }
        }


        this.holaService.showPersons();
        System.out.println("List of all persons: ");

        for (Person person : this.holaService.showPersons()){

            System.out.print("Name: ");
            System.out.println(person.getName());

            System.out.println("-- Roles: ");

            for (Role role : this.holaService.showRolesOfPerson(person.getName())){
                System.out.print("----- * ");
                System.out.println(role.getName() + "\n");


            }

        }


        this.holaService.showRoles();
        System.out.println("List of all Roles: ");

        for (Role role : this.holaService.showRoles()){
            System.out.println(role.getName());
        }

        System.out.println("\n");
        this.show();
    }
    // choosing 2 to create new entries
    public void createEntries() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nWhat type of entry do you want to create?\n");
        System.out.println("Press 0 for Back");
        System.out.println("Press 1 for person");
        System.out.println("Press 2 for role");
        System.out.println("Press 3 for circle");

        String answer = "";
        Scanner scanner = new Scanner(System.in);

        while (answer.equals("")) {
            answer = scanner.next();

            switch (answer) {
                case "1":
                    this.createPerson();
                    break;
                case "2":
                    this.createRole();
                    break;
                case "3":
                    this.createCircle();
                    break;
                case "0":
                    this.show();
                    break;
                default:
                    answer = "";
                    break;
            }
        }
    }

    public void createPerson() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n--------- YOU ARE CREATING A PERSON ---------\n\n");
        System.out.println("Enter the name of the person");

        String name = "";
        Scanner scanner = new Scanner(System.in);

        this.holaService.createPerson(scanner.next());

        this.saveHolaService();
        this.show();

    }

    public void createRole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n--------- YOU ARE CREATING A ROLE ---------\n\n");
        System.out.println("Enter the name of the role");

        Scanner scanner = new Scanner(System.in);

        String name = scanner.next();

        System.out.println("Enter the purpose of the role");

        String purpose = scanner.next();

        System.out.println("Enter the accountability of the role");

        String accountability = scanner.next();

        this.holaService.createRole(name, purpose, accountability);

        this.saveHolaService();


        this.show();

    }

    public void createCircle() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n--------- YOU ARE CREATING A CIRCLE ---------\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Enter the name of the circle");

        String name = "";
        Scanner scanner = new Scanner(System.in);

        this.holaService.createCircle(scanner.next());

        this.saveHolaService();


        this.show();

    }
    // choosing 3 to edit the entries
    public void editEntries() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nWhat type of entry do you want to edit?\n");
        System.out.println("Press 0 to go back");
        System.out.println("Press 1 for Add Role To Circle");
        System.out.println("Press 2 for Add Role To Person");
        System.out.println("Press 3 for Add Person To Circle");
        System.out.println("Press 4 for Remove Role From Person");
        System.out.println("Press 5 for add Subcircle To Circle");
        System.out.println("Press 6 for Remove Subcircle From Circle");
        System.out.println("Press 7 for Deleting a Person");
        System.out.println("Press 8 for Deleting a Role");
        System.out.println("Press 9 for Deleting a Circle");




        String answer = "";
        Scanner scanner = new Scanner(System.in);

        while (answer.equals("")) {
            answer = scanner.next();

            switch (answer) {
                case "0":
                    this.show();
                    break;
                case "1":
                    this.addRoleToCircleMenu();
                    break;
                case "2":
                    this.addRoleToPersonMenu();
                    break;
                case "3":
                    this.addPersonToCircleMenu();
                    break;
                case "4":
                    this.removeRoleFromPersonMenu();
                    break;
                case "5":
                    this.addSubcircleToCircleMenu();
                    break;
                case "6":
                    this.removeSubcircleFromCircleMenu();
                    break;
                case "7":
                    this.deletePersonMenu();
                    break;
                case "8":
                    this.deleteRoleMenu();
                    break;
                case "9":
                    this.deleteCircleMenu();
                    break;
                default:
                    answer = "";
                    break;
            }
        }
    }

    public void addRoleToCircleMenu() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n--------- Adding a Role to a Circle ---------\n\n");
        System.out.println("Enter the name of the circle:");

        Scanner scanner = new Scanner(System.in);

        String circleName = scanner.next() ;

        System.out.println("Enter the Role Name: ");
        String roleName = scanner.next();

        this.holaService.addRoleToCircle(roleName, circleName);

        this.saveHolaService();


        this.show();

    }

    public void addRoleToPersonMenu() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n--------- Adding a Role to a Person ---------\n\n");
        System.out.println("Enter the name of the Role:");

        Scanner scanner = new Scanner(System.in);

        String roleName = scanner.next() ;

        System.out.println("Enter the name of the Person: ");
        String personName = scanner.next();

        this.holaService.addRoleToPerson(roleName, personName);

        this.saveHolaService();


        this.show();

    }

    public void addPersonToCircleMenu() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n--------- Adding a Person to a Circle ---------\n\n");
        System.out.println("Enter the name of the Person:");

        Scanner scanner = new Scanner(System.in);

        String personName = scanner.next() ;

        System.out.println("Enter the name of the Circle: ");
        String circleName = scanner.next();

        this.holaService.addPersonToCircle(personName, circleName);

        this.saveHolaService();


        this.show();

    }

    public void removeRoleFromPersonMenu() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n--------- Removing a Role from a Person ---------\n\n");
        System.out.println("Enter the name of the Role:");

        Scanner scanner = new Scanner(System.in);

        String roleName = scanner.next() ;

        System.out.println("Enter the name of the Person: ");
        String personName = scanner.next();

        this.holaService.removeRoleFromPerson(roleName, personName);

        this.saveHolaService();


        this.show();

    }

    public void addSubcircleToCircleMenu() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n--------- Adding a Subcircle to a Circle ---------\n\n");
        System.out.println("Enter the name of the Subcircle:");

        Scanner scanner = new Scanner(System.in);

        String subcircleName = scanner.next() ;

        System.out.println("Enter the name of the Parent Circle: ");
        String circleName = scanner.next();

        this.holaService.addSubcircleToCircle(subcircleName, circleName);

        this.saveHolaService();


        this.show();

    }

    public void removeSubcircleFromCircleMenu() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n--------- Removing a Subcircle from a Circle ---------\n\n");
        System.out.println("Enter the name of the Subcircle:");

        Scanner scanner = new Scanner(System.in);

        String subcircleName = scanner.next() ;

        System.out.println("Enter the name of the Parent Circle: ");
        String circleName = scanner.next();

        this.holaService.removeSubcircleFromCircle(subcircleName, circleName);

        this.saveHolaService();


        this.show();

    }

    public void deletePersonMenu() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n--------- Deleting a Person from the System ---------\n\n");
        System.out.println("Enter the name of the Person:");

        Scanner scanner = new Scanner(System.in);

        String personName = scanner.next() ;

        this.holaService.deletePerson(personName);

        this.saveHolaService();


        this.show();

    }

    public void deleteRoleMenu() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n--------- Deleting a Role from the System ---------\n\n");
        System.out.println("Enter the name of the Role:");

        Scanner scanner = new Scanner(System.in);

        String roleName = scanner.next() ;

        this.holaService.deleteRole(roleName);

        this.saveHolaService();


        this.show();

    }

    public void deleteCircleMenu() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n--------- Deleting a Circle from the System ---------\n\n");
        System.out.println("Enter the name of the Circle:");

        Scanner scanner = new Scanner(System.in);

        String circleName = scanner.next() ;

        this.holaService.deleteCircle(circleName);

        this.saveHolaService();


        this.show();

    }



}
