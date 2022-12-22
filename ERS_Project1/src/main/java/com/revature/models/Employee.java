package com.revature.models;

import javax.management.relation.Role;

public class Employee
{

    private int user_id;
    private String user_name;
    private String pass_word;
    private String first_name;
    private String last_name;
    private int role_id_fk;
    private Role role;

    public Employee()
    {
    }

    public Employee(int user_id, String user_name, String pass_word, String first_name, String last_name, int role_id_fk, Role role) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.pass_word = pass_word;
        this.first_name = first_name;
        this.last_name = last_name;
        this.role_id_fk = role_id_fk;
        this.role = role;
    }

    public Employee(String user_name, String pass_word, String first_name, String last_name, int role_id_fk, Role role)
    {
        this.user_name = user_name;
        this.pass_word = pass_word;
        this.first_name = first_name;
        this.last_name = last_name;
        this.role_id_fk = role_id_fk;
        this.role = role;
    }

    public Employee(String user_name, String pass_word, String first_name, String last_name, int role_id_fk) {
        this.user_name = user_name;
        this.pass_word = pass_word;
        this.first_name = first_name;
        this.last_name = last_name;
        this.role_id_fk = role_id_fk;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPass_word() {
        return pass_word;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getRole_id_fk() {
        return role_id_fk;
    }

    public void setRole_id_fk(int role_id_fk) {
        this.role_id_fk = role_id_fk;
    }

    public Role getRole(int role_id_fk) {
        return role;
    }

    public void setRole(User_Role user_role)
    {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", pass_word='" + pass_word + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", role_id_fk=" + role_id_fk +
                ", role=" + role +
                '}';
    }
}
