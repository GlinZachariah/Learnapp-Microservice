package dev.glinzac.learnappmentorclient.models;

public class UserModel {
    private String userName;
    private String fullName;
    private String userPassword;
    private String userRole;
    private String accountStatus;

    public UserModel() {

    }
    public UserModel(String userName, String fullName, String userPassword, String userRole, String accountStatus) {
        super();
        this.userName = userName;
        this.fullName = fullName;
        this.userPassword = userPassword;
        this.userRole = userRole;
        this.accountStatus = accountStatus;
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
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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

