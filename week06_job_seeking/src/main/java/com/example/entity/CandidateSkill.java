package com.example.entity;

public class CandidateSkill {
    private Candidate candidate;
    private Skill skill;
    private int level;

    public CandidateSkill() {
    }

    public CandidateSkill(Candidate candidate, Skill skill, int level) {
        this.candidate = candidate;
        this.skill = skill;
        this.level = level;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "CandidateSkill{" +
                "candidate=" + candidate +
                ", skill=" + skill +
                ", level=" + level +
                '}';
    }
}
