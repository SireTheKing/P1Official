package com.revature.daos;

import com.revature.models.Ticket;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class TicketDAO implements TicketDAOInterface {
    public ArrayList<Ticket> getPendingTicketByID(int id)
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
    public ArrayList<Ticket> getTicketByID(int id) {

        {
            try (Connection conn = ConnectionUtil.getConnection()) {
                String sql = "select * from ticket where ticket_status_id_fk = 1;";
                Statement s = conn.createStatement();//takes query

                ResultSet rs = s.executeQuery(sql);

                ArrayList<Ticket> ticketsList = new ArrayList<>();

                while (rs.next()) {
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
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("In the TicketDAO");
            }
            return null;
        }
    }

    @Override
        public boolean InsertTicket(int amount, String description, int user_id) {

            try(Connection conn = ConnectionUtil.getConnection())
            {
                String sql = " insert into ticket( ticket_amount, ticket_description, ticket_status_id_fk, ticket_user_id_fk) values(?,?,1,?);";

                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setInt(1,amount);
                ps.setString(2, description);
                ps.setInt(3,user_id);

                ps.executeUpdate();

                return true;

            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            return false;

        }

        public boolean updateTicketStatus(int ticket_id, int status_id)
        {
            try(Connection conn = ConnectionUtil.getConnection())
            {
                String sql = "update ticket set ticket_status_id_fk = ? where ticket_id = ?";

                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1,status_id);
                ps.setInt(2,ticket_id);

                ps.executeUpdate();

                return true;

            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            return false;
        }

        public Ticket getTicketByTicketID(int ticket_id)
        {
            try(Connection conn = ConnectionUtil.getConnection())
            {
                String sql = "Select * from ticket where ticket_id = ? ;";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1,ticket_id);

                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {
                    Ticket t = new Ticket(
                            rs.getInt("ticket_id"),
                            rs.getInt("ticket_amount"),
                            rs.getString("ticket_description"),
                            rs.getInt("ticket_status_id_fk"),
                            rs.getInt("ticket_type_id_fk"),
                            rs.getInt("ticket_user_id_fk")
                    );
                    return t;
                }

            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            return null;
        }

    }





