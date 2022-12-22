package com.revature.daos;

import com.revature.models.Employee;
import com.revature.models.User_Role;
import com.revature.utils.ConnectionUtil;

import javax.management.relation.Role;
import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO implements EmployeeDAOInterface
{

    @Override
    public ArrayList<Employee> getEmployees()
    {
        try( Connection conn = ConnectionUtil.getConnection())
        {
            // A string to rep the sql statement
            // select * from employees
            String sql = "select * from ticket_user;";// create query

            //no wildcard so we only need a statement

            Statement s = conn.createStatement();//take query


            // now we will execute the query and save the results in the result set
            ResultSet rs = s.executeQuery(sql);//put in result set

            //Instantiate the empty arraylist to hold incoming employee data
            ArrayList<Employee> employeeList = new ArrayList();

            while(rs.next())
            {
                Employee e = new Employee(
               // rs.getInt("user_id"),
                rs.getString("user_name"),
                rs.getString("pass_word"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getInt("role_id_fk"),
                        null
                        );
                int roleFk = rs.getInt("role_id_fk");

                //Instantiate a Role Object using the id we gathered
                RoleDAO rDAO = new RoleDAO();

                User_Role r = rDAO.getRoleByID(roleFk);

                e.setRole(r);// set role to new object above
                e.setRole_id_fk(roleFk);

                employeeList.add(e);

            }

                return employeeList;


        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println(" WERE in the get employees function");
        }

        return null;// if something go wrong after the catch we will return null
    }

    @Override
    public Employee InsertEmployee(Employee emp)
    {
        try(Connection conn = ConnectionUtil.getConnection())
        {
            String sql = "insert into ticket_user(user_name, pass_word, first_name, last_name, role_id_fk) values (?, ?, ?, ?, 1);";

            PreparedStatement ps = conn.prepareStatement(sql);

            //fill in the wild card (user_name, pass_word, first_name, last_name, role_id_fk)
            ps.setString(1,emp.getUser_name());
            ps.setString(2,emp.getPass_word());
            ps.setString(3, emp.getFirst_name());
            ps.setString(4, emp.getLast_name());

            ps.executeUpdate();

            return emp;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
