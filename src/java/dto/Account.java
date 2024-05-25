/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Admin
 */
public class Account {
    private int id;
    private String email,fullname,password;

    public Account() {
        id=0;
        email="";
        fullname="";
        password="";
    }

    public Account(int id, String email, String fullname, String password) {
        this.id = id;
        this.email = email;
        this.fullname = fullname;
        this.password = password;
    }
    

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", email=" + email + ", fullname=" + fullname + ", password=" + password + '}';
    }
    
    
}
