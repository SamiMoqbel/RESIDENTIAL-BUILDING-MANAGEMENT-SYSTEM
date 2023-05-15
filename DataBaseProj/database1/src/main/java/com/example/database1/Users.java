package com.example.database1;
public class Users {
    private String password;
    private String Email;
    private String type;

    public Users( String email, String password,String type) {
        this.Email=email;
        this.password = password;
        this.type=type;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

}
