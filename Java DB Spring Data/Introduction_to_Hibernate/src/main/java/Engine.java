import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class Engine implements Runnable {

    private static final String SALARY = "50000";
    private final EntityManager entityManager;
    private final BufferedReader reader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {

        System.out.println("Welcome to 'Exercise: Introduction to Hibernate'");
        System.out.println("Please edit your 'username' and 'password' in 'persistence.xml' file!");
        System.out.println();


        System.out.print("Please choose Ex number (2-13) or '0' for Exit : ");
        String exercise = null;
        try {
            exercise = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        while (!"0".equals(exercise)) {
            switch (exercise) {
                case "2":
                    List<Town> towns = entityManager.createQuery("SELECT t FROM Town t WHERE length(t.name)<=5 ", Town.class).getResultList();
                    entityManager.getTransaction().begin();
                    towns.forEach(entityManager::detach);
                    for (Town town : towns) {
                        town.setName(town.getName().toLowerCase());
                    }
                    towns.forEach(entityManager::merge);
                    entityManager.flush();
                    entityManager.getTransaction().commit();
                    break;
                case "3":
                    System.out.print("Please enter full name : ");

                    String fullName = null;
                    try {
                        fullName = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println();
                    List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e " +
                            "WHERE concat(e.firstName,' ',e.lastName) = :name", Employee.class)
                            .setParameter("name", fullName)
                            .getResultList();
                    System.out.println(employees.size() == 0 ? "No" : "Yes");
                    break;
                case "4":
                    List<Employee> employees2 = entityManager.createQuery("SELECT e FROM Employee e " +
                            "WHERE e.salary > 50000", Employee.class)
                            .getResultList();
                    employees2.forEach(employee -> System.out.println(employee.getFirstName()));
                    break;
                case "5":
                    List<Employee> employees3 = entityManager.createQuery("SELECT e FROM Employee e " +
                            "WHERE e.department.name = 'Research and Development' ORDER BY e.salary ,e.id", Employee.class)
                            .getResultList();
                    employees3.forEach(employee -> System.out.printf("%s %s  from Research and Development - %.2f%n", employee.getFirstName(), employee.getLastName(), employee.getSalary()));
                    break;
                case "6":
                    Address addres = new Address();
                    addres.setText("Vitoshka 15");
                    entityManager.getTransaction().begin();
                    entityManager.persist(addres);
                    entityManager.getTransaction().commit();
                    System.out.print("Please enter valid employee last name : ");
                    String lastName = null;
                    try {
                        lastName = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println();
                    Employee empl = entityManager.createQuery("SELECT e FROM Employee e WHERE e.lastName = :lastname", Employee.class)
                            .setParameter("lastname", lastName)
                            .getSingleResult();
                    entityManager.getTransaction().begin();
                    empl.setAddress(addres);
                    entityManager.getTransaction().commit();
                    break;
                case "7":
                    List<Address> addresses = entityManager.createQuery("SELECT a FROM Address a " +
                            "ORDER BY a.employees.size DESC ", Address.class).setMaxResults(10)
                            .getResultList();
                    addresses.forEach(adr -> System.out.printf("%s, %s - %d%n", adr.getText(), adr.getTown().getName(), adr.getEmployees().size()));
                    break;
                case "8":
                    System.out.print("Please enter valid employee Id : ");
                    int id = -1;
                    try {
                        id = Integer.parseInt(reader.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println();
                    Employee employee = entityManager.find(Employee.class, id);
                    System.out.printf("%s %s -  %s%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle());
                    employee.getProjects().stream().sorted(Comparator.comparing(Project::getName)).forEach(pr -> System.out.println("\t" + pr.getName()));
                    break;
                case "9":
                    List<Project> projects = entityManager.createQuery("SELECT p FROM Project p " +
                            "ORDER BY p.startDate DESC", Project.class).setMaxResults(10)
                            .getResultList();
                    projects.stream().sorted(Comparator.comparing(Project::getName))
                            .forEach(p -> System.out.printf("Project name: %s %n\tProject Description: %s%n\tProject Start Date:%s%n\tProject End Date:%n"
                                    , p.getName(), p.getDescription(), p.getStartDate(), p.getEndDate()));

                    break;
                case "10":
                    entityManager.getTransaction().begin();
                    int affectedRows = entityManager.createQuery("UPDATE Employee e SET e.salary = e.salary*1.12 " +
                            "WHERE e.department.id IN (1,2,4,11) ").executeUpdate();
                    entityManager.getTransaction().commit();

                    List<Employee> employees4 = entityManager.createQuery("SELECT e FROM Employee e " +
                            "WHERE e.department.name IN ('Engineering', 'Tool Design', 'Marketing' , 'Information Services')",Employee.class)
                            .getResultList();
                    employees4.forEach(e -> System.out.printf("%s %s (%.2f)%n", e.getFirstName(), e.getLastName(), e.getSalary()));
                    break;
                case "11":
                    System.out.print("Please enter pattern for employee first name : ");
                    String pattern = "";
                    try {
                        pattern = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println();
                    pattern = pattern + "%";
                    List<Employee> employees5 = entityManager.createQuery("SELECT e FROM Employee e " +
                            "WHERE e.firstName LIKE :patt",Employee.class)
                            .setParameter("patt", pattern)
                            .getResultList();
                    employees5.forEach(e -> System.out.printf("%s %s - %s - (%.2f)%n", e.getFirstName(), e.getLastName(), e.getJobTitle(), e.getSalary()));
                    break;
                case "12":
                   entityManager.createQuery("SELECT MAX(e.salary) AS max_salary, e.department.name FROM Employee e " +
                            "WHERE  e.salary NOT BETWEEN 30000 AND 70000 GROUP BY e.department.name  ")
                            .getResultList();
              //      employees7.forEach(e -> System.out.printf("%s %n", e.getDepartment()));
                    System.out.println("Print is under construction !!!");
                    break;
                case "13":
                    System.out.print("Please enter town name : ");
                    String town = "";
                    try {
                        town = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println();
                    entityManager.getTransaction().begin();
                    int affectedAddresses = entityManager.createQuery("DELETE FROM Address a " +
                            "WHERE a.town.name = :twn ").setParameter("twn",town).executeUpdate();
                    entityManager.createQuery("DELETE FROM Town t " +
                            "WHERE t.name = :twn ").setParameter("twn",town).executeUpdate();
                    entityManager.getTransaction().commit();
                    break;
                default:
                    System.out.println("Please enter correct input number !!!");
            }

            System.out.println();
            System.out.print("Please choose Ex number (2-13) or '0' for Exit : ");
            try {
                exercise = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("Good bye! See you soon :) !!!");
    }
}
