package com.revature.daos;

import com.revature.models.Employee;

import java.util.ArrayList;

public interface EmployeeDAOInterface
{

    ArrayList<Employee> getEmployees();
    // An array list to store some random amount employees and return multiple emplpoyees

    Employee InsertEmployee(Employee emp);
    // so the user can see what they inserted - confirmation check point


}
