package dev.glinzac.learnappadminclient.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Technology {
    @Id
    @Column(length = 32)
    private String skillName;
    public Technology() {

    }

    public Technology(String skill) {
        super();
        this.skillName = skill;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skill) {
        this.skillName = skill;
    }

}
