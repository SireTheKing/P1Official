package com.revature.models;

public class LoginDTO
{
    // Data Transfer object make a non database class to transfer data for username and password
    // - useful when you dont wanna meet an entire object
    // when you dont wanna store data in the DB


    // variable to hold firstname and lastname
    private String user_name;
    private String pass_word;

    public LoginDTO()
    {
    }

    public LoginDTO(String user_name, String pass_word) {
        this.user_name = user_name;
        this.pass_word = pass_word;
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
}
