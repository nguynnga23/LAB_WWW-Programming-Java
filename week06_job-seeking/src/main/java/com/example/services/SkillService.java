package com.example.services;

import com.example.entity.Skill;
import com.example.respositories.SkillRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {
    @Autowired
    private SkillRespository skillRepository;
    public void create(String skillName, String description, String field ){
        skillRepository.create(skillName, description, field);
    }

    public Skill findById(int id) {
        return skillRepository.findById(id);
    }

    public void update(int id, String skillName, String description, String field) {
        skillRepository.update(id, skillName, description, field);
    }

    public void delete(int id) {
        skillRepository.delete(id);
    }
}
