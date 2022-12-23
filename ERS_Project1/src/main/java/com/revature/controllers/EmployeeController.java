package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.daos.EmployeeDAO;
import com.revature.models.Employee;
import io.javalin.http.Handler;

import java.util.ArrayList;

public class EmployeeController
{
    EmployeeDAO eDAO = new EmployeeDAO();

    public Handler getEmployeeHandler = (ctx) ->
    {
        ArrayList<Employee> employees = eDAO.getEmployees();
        //Problem: we cant send plain Java in an HTTP request
        //Instantiate a GSON object
        Gson gson = new Gson();

        // use the GSON .toJson() method to turn
        String JSONEmployees = gson.toJson(employees);

        // we use ctx.result to send back a HTTP response
        ctx.result(JSONEmployees);

        //ctx.result("Handler works");
        ctx.status(202);
    };

    public Handler insertEmployeeHandler = (ctx) ->
    {
        String body = ctx.body();
        //instntiate a new GSON object to JSON other way around

        Gson gson = new Gson();
        Employee newEmp = gson.fromJson(body, Employee.class);

        // calling insert employees method from dao if successful we will send new employee back response
        if(eDAO.InsertEmployee(newEmp) != null)
        {
            ctx.status(201);
            ctx.result(body);
        }
        else {
            ctx.status(406);
           ctx.result("Unavailable login");

        }



    };
}
