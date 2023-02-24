package fa.training.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Employees", schema = "dbo", indexes = {
        @Index(columnList = "first_name, last_name", name = "IDX_EMP_NAME") })
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Employee_Project", schema = "dbo",
            joinColumns = { @JoinColumn(referencedColumnName = "employee_id") },
            inverseJoinColumns = { @JoinColumn(referencedColumnName = "project_id") })
    private Set<Projects> projects;

    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "job_id")
    private Jobs job;

    @Column(name = "first_name", length = 3, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 3, nullable = false)
    private String lastName;

    @Column(name = "email", length = 255, unique = true)
    private String email;

    @Column(name = "phone_number", length = 255, unique = true)
    private String phoneNumber;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @Column(name = "salary")
    private double salary;

    @Column(name = "commission_pct")
    private double commissionPct;


    public Set<Projects> getProjects() {
        return projects;
    }

    public void setProjects(Set<Projects> projects) {
        this.projects = projects;
    }

    public Employees() {
    }

    public Employees(String firstName, String lastName, String email, String phoneNumber, LocalDate hireDate,
                     double salary, double commissionPct) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commissionPct = commissionPct;
    }

    public Jobs getJob() {
        return job;
    }

    public void setJob(Jobs job) {
        this.job = job;
    }
}
