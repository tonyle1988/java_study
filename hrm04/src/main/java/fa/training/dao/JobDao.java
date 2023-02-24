package fa.training.dao;

import fa.training.entities.Jobs;

public interface JobDao {
    public boolean save(Jobs job) throws Exception;

    public Jobs findById(String jobId) throws Exception;
}
