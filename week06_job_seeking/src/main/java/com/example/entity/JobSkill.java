package com.example.entity;

public class JobSkill {
    private Job job;
    private Skill skill;
    private int requiredLevel;

    public JobSkill() {
    }

    public JobSkill(Job job, Skill skill, int requiredLevel) {
        this.job = job;
        this.skill = skill;
        this.requiredLevel = requiredLevel;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    @Override
    public String toString() {
        return "JobSkill{" +
                "job=" + job +
                ", skill=" + skill +
                ", requiredLevel=" + requiredLevel +
                '}';
    }
}
