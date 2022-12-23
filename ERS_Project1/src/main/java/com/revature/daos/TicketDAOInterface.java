package com.revature.daos;

import com.revature.models.Employee;
import com.revature.models.Ticket;
import org.eclipse.jetty.util.DateCache;

import java.util.ArrayList;

public interface TicketDAOInterface
{
        ArrayList<Ticket> getTicketByID(int id);
        // An array list to store some random amount employees and return multiple emplpoyees

        boolean InsertTicket(int amount, String description, int user_id);
        // so the user can see what they inserted - confirmation check point

}
