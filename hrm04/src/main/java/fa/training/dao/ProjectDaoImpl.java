package fa.training.dao;

import fa.training.entities.Projects;
import fa.training.utils.HibernateUtils;
import org.hibernate.*;

import java.io.Serializable;

public class ProjectDaoImpl implements ProjectDao {
    @Override
    public boolean save(Projects project) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Serializable result = session.save(project);
            transaction.commit();

            return (result != null);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
