package com.revature.daos;

import com.revature.models.Ticket;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TicketHistoryDAO implements TicketDAOInterface
{

    @Override
    public ArrayList<Ticket> getTicketByID(int id) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = " select * from ticket where ticket_user_id_fk = ? ;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            ArrayList<Ticket> ticketlist = new ArrayList<>();

            while (rs.next())
            {
                //instantiate the ticket object
                Ticket ticket = new Ticket(
                        rs.getInt("ticket_id"),
                        rs.getInt("ticket_amount"),
                        rs.getString("ticket_description"),
                        rs.getInt("ticket_status_id_fk"),
                        rs.getInt("ticket_type_id_fk"),
                        rs.getInt("ticket_user_id_fk")
                );

                ticketlist.add(ticket);
            }

            return ticketlist;


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
