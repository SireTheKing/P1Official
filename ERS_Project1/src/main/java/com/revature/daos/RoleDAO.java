package com.revature.daos;

import com.revature.models.User_Role;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDAO implements RoleDAOInterface
{

    /*
        -To Do's:
            - create a sql statement
            - send to DB
            - gather result set from sql statement
            - turn it into java
            - return it to the user

         - This class will be responsible for all things role data
         - This class will query the role data
     */

    @Override
    public User_Role getRoleByID(int id)
    {
        //try w/ resource block to open our connection and host our DB connection
        try(Connection conn = ConnectionUtil.getConnection())
        {
            /*
                - add sql queries we intend to run on the Database
             */
            String sql = "select * from users_role where role_id = ?;";
            System.out.println("Im in The GetRoleByID function Working!!");

            // Prepared Statement for the wildcards
            PreparedStatement ps = conn.prepareStatement(sql);
            // Since the role id is an int we will use setInt but there are other options
            ps.setInt(1,id);// the first '1',  wildcard will be equal to the id parameter.

            ResultSet rs =  ps.executeQuery();// executing the query found in the prepared statement
            // the results will be stored in the results object

            while(rs.next())
            {
                //instantiate the role object
                User_Role role = new User_Role (
                        rs.getInt("role_id"),
                        rs.getString("role_title")
                );

                return role;
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println(" WERE IN HERE STUCK/ NOT WORKING ");
        }


        return null;
    }

    @Override
    public boolean updateRole(String role_title, int role_id)
    {
        try(Connection conn = ConnectionUtil.getConnection())
        {
            // create our SQL String
            String sql = "update user_role set role_title = ? where role_id =?;";
                //- aim to change the employee to manager and vice versa

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,role_title);
            ps.setInt(2,role_id);



            //execute update
            ps.executeUpdate();

            return true;

        }
        catch(SQLException e)
        {

            e.printStackTrace();

        }
        return false;
    }
}
