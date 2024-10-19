package com.example.services;

import com.example.entity.Candidate;
import com.example.respositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public void create(Candidate candidate) {
        candidateRepository.create(candidate);
    }

    public Candidate findById(int id) {
        return candidateRepository.findById(id);
    }

    public void update(Candidate candidate) {
        candidateRepository.update(candidate);
    }

    public void delete(int id) {
        candidateRepository.delete(id);
    }
}
