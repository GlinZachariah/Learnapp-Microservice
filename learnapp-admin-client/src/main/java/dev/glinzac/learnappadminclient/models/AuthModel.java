package dev.glinzac.learnappadminclient.models;

public class AuthModel {
    private boolean auth;
    private String role;
    private String fullname;
    public AuthModel(){

    }

    public AuthModel(boolean auth, String role, String fullname) {
        this.auth = auth;
        this.role = role;
        this.fullname = fullname;
    }

    public boolean getAuth() {
        return auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
