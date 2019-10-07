package dev.glinzac.learnappuserclient.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class UserDetails {
    @Id
    @Column(name="user_name",length = 64)
    private String userName;

    @Column(name="full_name",nullable=false)
    private String fullName;

    @Column(name="user_password",nullable=false)
    private String userPassword;

    @Column(name="user_role",nullable=false)
    private String userRole;

    @Column(name="user_account_status",nullable=false)
    private String accountStatus;

    public UserDetails() {
        super();
    }

    public UserDetails(String userName, String fullName,String userPassword, String userRole, String accountStatus) {
        super();
        this.userName = userName;
        this.fullName = fullName;
        this.userPassword = userPassword;
        this.userRole = userRole;
        this.accountStatus = accountStatus;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getUserRole() {
        return userRole;
    }
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
    public String getAccountStatus() {
        return accountStatus;
    }
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }


}
