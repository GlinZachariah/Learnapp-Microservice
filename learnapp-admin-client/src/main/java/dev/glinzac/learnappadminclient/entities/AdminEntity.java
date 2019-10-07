package dev.glinzac.learnappadminclient.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin_entity")
public class AdminEntity {
    @Id
    @Column(name="admin_name",length = 32)
    private String adminName;

    @Column(name="admin_password")
    private String adminPassword;

    public AdminEntity() {

    }
    public AdminEntity(String adminName, String adminPassword) {
        super();
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }
    public String getAdminName() {
        return adminName;
    }
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public String getAdminPassword() {
        return adminPassword;
    }
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }


}

