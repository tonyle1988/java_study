package fa.training.dao;

import fa.training.entities.Jobs;
import fa.training.utils.HibernateUtils;
import org.hibernate.*;

import java.io.Serializable;

public class JobDaoImpl implements JobDao {

    @Override
    public boolean save(Jobs job) throws Exception {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Serializable result = session.save(job);

            transaction.commit();

            return (result != null);

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return false;
    }

    @Override
    public Jobs findById(String jobId) throws Exception {
        Session session = null;

        try {
            session = HibernateUtils.getSessionFactory().openSession();

            Jobs job = session.get(Jobs.class, jobId);

            return job;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
