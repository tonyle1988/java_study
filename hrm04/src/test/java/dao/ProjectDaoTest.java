package dao;

import fa.training.dao.ProjectDao;
import fa.training.dao.ProjectDaoImpl;
import fa.training.entities.Employees;
import fa.training.entities.Projects;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectDaoTest {
    static ProjectDao projectDao;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        projectDao = new ProjectDaoImpl();
    }

    @Test
    void testSave() throws Exception {
        Employees employee = new Employees("Nguyen", "Dang Khoa", "khoadk@fsoft.com.vn", "0988777665", LocalDate.of(2019, 1, 1), 1000, 1.1);
        Projects project = new Projects("IT Fundamental", LocalDate.of(2020, 10, 1), "Fsoft Academey It Fundamental Training Program", LocalDate.of(2020, 12, 31));

        Set<Employees> employees = new HashSet<>();
        employees.add(employee);

        Set<Projects> projects = new HashSet<>();
        projects.add(project);

        project.setEmployees(employees);
        //employee.setProjects(projects);

        assertTrue(projectDao.save(project));
    }
}
