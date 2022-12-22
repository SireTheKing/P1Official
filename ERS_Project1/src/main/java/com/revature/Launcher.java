package com.revature;

import com.revature.controllers.AuthController;
import com.revature.controllers.EmployeeController;
import com.revature.controllers.TicketController;
import com.revature.daos.EmployeeDAO;
import com.revature.daos.RoleDAO;
import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;
import io.javalin.Javalin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Launcher
{
    public static void main(String[] args)
    {
        // creating the connection object
        try(Connection conn = ConnectionUtil.getConnection()) {
            System.out.println("connection works! ");
        } catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("connection failed. :/");
        }
        //Creating a Javalin object
        Javalin app = Javalin.create(
                config -> {
                    config.enableCorsForAllOrigins();// this allows us to process http request from anywhere
                }

        ).start(3000);

            // - Testing and it works
        // role
        RoleDAO rDAO = new RoleDAO();
        System.out.println(rDAO.getRoleByID(1));
        // employee
        EmployeeDAO eDAO = new EmployeeDAO();
        //System.out.println(eDAO.getEmployees());
        // neatly call all from for loop
        ArrayList<Employee> employees = eDAO.getEmployees();

        for(Employee e : employees)
        {
            System.out.println(e);
        }

        //Employee newEmp = new Employee(6,"SpiderWoMan1","wors","jasmine","Carswell",1,rDAO.getRoleByID(1));
        //System.out.println(eDAO.InsertEmployee(newEmp));
        //eDAO.InsertEmployee(newEmp);

        //update
        // rDAO.updateRole("i ant to update role_id_fk from ticket_user") if a manager


        //Instantiating controllers
        EmployeeController ec = new EmployeeController();
        AuthController ac = new AuthController();
        TicketController tc = new TicketController();

        //get all employee endpoint (get - insert)
        app.get("/employees", ec.getEmployeeHandler);
        app.post("/employees", ec.insertEmployeeHandler);

        app.post("/ticket", tc.insertTicketHandler);

        // login endpoints
        app.post("/login", ac.loginHandler);

    }
}
