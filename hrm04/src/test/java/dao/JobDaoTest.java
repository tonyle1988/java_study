package dao;

import fa.training.dao.JobDao;
import fa.training.dao.JobDaoImpl;
import fa.training.entities.Jobs;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JobDaoTest {
    static JobDao jobDao;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        jobDao = new JobDaoImpl();
    }

    @Test
    void testSave1() throws Exception {
        Jobs job = new Jobs("J01", "Java Dev1", 1000.0, 2000.0);
        assertEquals(true, jobDao.save(job));
    }
    @Test
    void testSave2() throws Exception {
        Jobs job = new Jobs("J02", "Java Dev2", 1200.0, 2200.0);
        assertEquals(true, jobDao.save(job));
    }
}
