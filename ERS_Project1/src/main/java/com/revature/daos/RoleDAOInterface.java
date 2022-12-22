package com.revature.daos;

import com.revature.models.User_Role;

public interface RoleDAOInterface
{
    //This will document what functionalities that exist

    // this method returns a role given an ID
    User_Role getRoleByID(int id);//given a id it will search the database and select all from roles where id = ____ and return a role object from the database

    //a method that updates the role and allows managers to update emplyees role
    boolean updateRole(String role_title, int role_id);


}
