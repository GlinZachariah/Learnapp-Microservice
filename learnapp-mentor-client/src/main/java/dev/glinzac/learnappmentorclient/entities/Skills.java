package dev.glinzac.learnappmentorclient.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skills")
public class Skills {
    @Id
    @Column(name = "skillname",length = 32)
    private String skillName;

    public Skills(){

    }

    public Skills(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
