package com.training.iba.entity;

import java.util.Objects;

public class User {
    private Role role;
    private String login;
    private String password;
    private PersonalInfo info;

    public User(){}

    public User(Role role, String login, String password) {
        this.role = role;
        this.login = login;
        this.password = password;
    }

    public User(Role role, String login, String password, PersonalInfo info) {
        this.role = role;
        this.login = login;
        this.password = password;
        this.info = info;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PersonalInfo getInfo() {
        return info;
    }

    public void setInfo(PersonalInfo info) {
        this.info = info;
    }

    public enum Role{
        USER,ADMIN
    }


    @Override
    public String toString() {
        return "User[" +
                "role=" + role +
                ", login= " + login +
                ", password= " + password +
                ", info= " + info + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return role == user.role &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(info, user.info);
    }

    @Override
    public int hashCode() {
        return role.hashCode() + login.hashCode() + password.hashCode() + info.hashCode();
    }
}
