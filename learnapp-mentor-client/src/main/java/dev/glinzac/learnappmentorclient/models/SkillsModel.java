package dev.glinzac.learnappmentorclient.models;

import dev.glinzac.learnappmentorclient.entities.Skills;

import java.util.List;

public class SkillsModel {
    private int mentorId;
    private List<Skills> skills;

    public  SkillsModel() {

    }
    public  SkillsModel(int mentorId, List<Skills> skills) {
        super();
        this.mentorId = mentorId;
        this.skills = skills;
    }
    public int getMentorId() {
        return mentorId;
    }
    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }
    public List<Skills> getSkills() {
        return skills;
    }
    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }



}

