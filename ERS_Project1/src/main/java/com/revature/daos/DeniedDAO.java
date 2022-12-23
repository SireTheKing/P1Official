package com.revature.daos;

import com.revature.models.Ticket;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DeniedDAO implements TicketDAOInterface
{


    @Override
    public ArrayList<Ticket> getTicketByID(int id)
    {
        try(Connection conn = ConnectionUtil.getConnection())
        {
            String sql = "select * from ticket where ticket_status_id_fk = 3;";
            Statement s = conn.createStatement();//takes query

            ResultSet rs = s.executeQuery(sql);

            ArrayList<Ticket> ticketsList = new ArrayList<>();

            while(rs.next())
            {
                Ticket t = new Ticket(
                        rs.getInt("ticket_id"),
                        rs.getInt("ticket_amount"),
                        rs.getString("ticket_description"),
                        rs.getInt("ticket_status_id_fk"),
                        rs.getInt("ticket_type_id_fk"),
                        rs.getInt("ticket_user_id_fk")
                );

                ticketsList.add(t);

            }

            return ticketsList;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean InsertTicket(int amount, String description, int user_id) {
        return false;
    }
}
