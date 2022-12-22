package com.revature.controllers;


import com.google.gson.Gson;
import com.revature.daos.AuthDAO;
import com.revature.models.Employee;
import com.revature.models.LoginDTO;
import io.javalin.http.Handler;

public class AuthController
{
    AuthDAO aDAO = new AuthDAO();

    //login is a post request
    public Handler loginHandler = (ctx) ->
    {
        //ctx.body to grab http request data
        String body = ctx.body();

        Gson gson = new Gson();

        LoginDTO lDTO = gson.fromJson(body, LoginDTO.class);

        Employee loggedInEmployee = aDAO.login(lDTO.getUser_name(),lDTO.getPass_word());

        if(loggedInEmployee != null )
        {

            String userJSON = gson.toJson(loggedInEmployee);
            ctx.result(userJSON);
            ctx.status(202);
        }
        else {
            ctx.status(401);
            ctx.result("Made it here ");
        }
    };
}
