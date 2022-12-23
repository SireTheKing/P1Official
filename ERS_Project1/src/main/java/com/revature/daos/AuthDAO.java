package com.revature.daos;

import com.revature.models.Employee;
import com.revature.models.User_Role;
import com.revature.utils.ConnectionUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDAO
{
    // I would put my register here but im using insert

    // Return the user based on the username and password

    public Employee login(String user_name, String pass_word)
    {
        try(Connection conn = ConnectionUtil.getConnection())
        {
            String sql = "Select * from ticket_user where user_name = ? and pass_word = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user_name);
            ps.setString(2,pass_word);

            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                Employee e = new Employee(
                        rs.getInt("user_id"),
                rs.getString("user_name"),
                rs.getString("pass_word"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getInt("role_id_fk"),
                        null
                );

                int roleFK = rs.getInt("role_id_fk");

                RoleDAO rDAO = new RoleDAO();
                User_Role r = rDAO.getRoleByID(roleFK);
                e.setRole(r);

                return e;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
