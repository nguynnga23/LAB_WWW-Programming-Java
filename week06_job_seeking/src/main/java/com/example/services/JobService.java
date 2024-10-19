package com.example.services;
import com.example.entity.Job;
import com.example.respositories.JobRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    @Autowired
    private JobRespository jobRespository;
    public void create(Job job) {
        jobRespository.create(job);
    }

    public Job findById(int id) {
        return jobRespository.findById(id);
    }

    public void update(Job job) {
        jobRespository.update(job);
    }

    public void delete(int id) {
        jobRespository.delete(id);
    }


}
