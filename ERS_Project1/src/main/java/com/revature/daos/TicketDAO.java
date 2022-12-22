package com.revature.daos;

import com.revature.models.Ticket;
import com.revature.models.User_Role;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class TicketDAO implements TicketDAOInterface {
    @Override
    public ArrayList<Ticket> getTicketByID(int id)
    {
        try(Connection conn = ConnectionUtil.getConnection())
        {
            String sql = "select * from ticket where ticket_status_id_fk = 1;";
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
            System.out.println("In the TicketDAO");
        }
        return null;
    }


        @Override
        public boolean InsertTicket(int amount, String description) {

            try(Connection conn = ConnectionUtil.getConnection())
            {
                String sql = " insert into ticket( ticket_amount, ticket_description, ticket_status_id_fk) values(?,?,1);";

                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setInt(1,amount);
                ps.setString(2, description);

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





