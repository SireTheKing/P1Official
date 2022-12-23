package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.daos.ApprovedDAO;
import com.revature.daos.DeniedDAO;
import com.revature.daos.TicketDAO;
import com.revature.daos.TicketHistoryDAO;
import com.revature.models.Ticket;
import com.revature.models.TicketDTO;
import io.javalin.http.Handler;

import java.util.ArrayList;


public class TicketController
{
    TicketDAO tDAO = new TicketDAO();
    ApprovedDAO appDAO = new ApprovedDAO();

    DeniedDAO DDAO = new DeniedDAO();
    TicketHistoryDAO tHDAO = new TicketHistoryDAO();


    public Handler userTicketHistory = (ctx) ->
    {
        if(AuthController.ses != null)
        {
            int userID = (Integer) AuthController.ses.getAttribute("user_id");



            //Ticket newTicket = gson.fromJson(body, Ticket.class);
/*
        if(tHDAO.InsertTicket()
        {
            ctx.status(201);
            ctx.result(body);
        }
 */
            ArrayList<Ticket> tickets = tHDAO.getTicketByID(userID);
            Gson gson = new Gson();
            String jSONHere= gson.toJson(tickets);

            ctx.result(jSONHere);
            ctx.status(202);
        }
        else {
            ctx.result("Nah Bruh");
            ctx.status(401);
        }

    };
    public Handler getPendingTickets = (ctx) ->
    {
        if(AuthController.ses != null) {
            //
            int roleID = (Integer) AuthController.ses.getAttribute("user_role_id_fk");
            if (roleID == 2) {
                ArrayList<Ticket> tickets = tDAO.getPendingTicketByID(1);

                Gson gson = new Gson();

                String JSONTicket = gson.toJson(tickets);

                ctx.result(JSONTicket);
                ctx.status(202);
            } else {
                ctx.result("You are not a manager");
                ctx.status(401);
            }
        }
        else{
            ctx.result("You are not logged in ");
            ctx.status(401);
        }
    };

    public Handler getApprovedTickets = (ctx) ->
    {
        if(AuthController.ses != null) {
            int roleID = (Integer) AuthController.ses.getAttribute("user_role_id_fk");
            if (roleID == 2)
            {

                ArrayList<Ticket> tickets = appDAO.getTicketByID(2);

                Gson gson = new Gson();

                String JSONTicket = gson.toJson(tickets);


                ctx.result(JSONTicket);
                if (ctx.result(JSONTicket) != null)
                {
                    ctx.status(202);
                } else
                {
                    ctx.result("You are not logged in");
                    ctx.status(401);
                }

            }
            else
            {
                ctx.result("You are not a manager  ");
                ctx.status(401);
            }
        }
    };

    public Handler getDeniedTickets = (ctx) ->
    {
        if(AuthController.ses != null) {
            int roleID = (Integer) AuthController.ses.getAttribute("user_role_id_fk");
            if (roleID == 2)
            {

                ArrayList<Ticket> tickets = DDAO.getTicketByID(3);

                Gson gson = new Gson();

                String JSONTicket = gson.toJson(tickets);


                ctx.result(JSONTicket);
                if (ctx.result(JSONTicket) != null)
                {
                    ctx.status(202);
                } else
                {
                    ctx.result("You are not logged in");
                    ctx.status(401);
                }

            }
            else
            {
                ctx.result("You are not a manager  ");
                ctx.status(401);
            }
        }
        };

    public Handler insertTicketHandler = (ctx) ->
    {
        if(AuthController.ses != null) {
             int userID = (Integer) AuthController.ses.getAttribute("user_id");


            String body = ctx.body();

            Gson gson = new Gson();

            TicketDTO tDTO = gson.fromJson(body, TicketDTO.class);
            if (tDTO.getDescription() != null && tDTO.getAmount() != null ) {

                if (tDAO.InsertTicket(tDTO.getAmount(), tDTO.getDescription(), userID)) {
                    ctx.status(201);
                    ctx.result(body);
                } else {
                    ctx.status(401);
                    ctx.result(" Insert Ticket Handler");
                }
            }
            else {
                ctx.result("Must enter: amount and description");
                ctx.status(406);
            }

        }
        else{
            ctx.result("You are not logged in ");
            ctx.status(401);
        }
    };

    public Handler updateStatus = (ctx) ->
    {
        if(AuthController.ses != null) {
            //
            int roleID = (Integer) AuthController.ses.getAttribute("user_role_id_fk");
            if(roleID == 2)
            {
                int currentTicketStatus = tDAO.getTicketByTicketID(Integer.parseInt(ctx.pathParam("ticket_id"))).getTicket_status_id_fk();

                if(currentTicketStatus != 1)
                {
                    ctx.result("This ticket has been processed");
                    ctx.status(406);
                }
                else
                {
                    if(tDAO.updateTicketStatus(Integer.parseInt(ctx.pathParam("ticket_id")),Integer.parseInt(ctx.body())))
                    {
                        ctx.result("Update Complete");
                        ctx.status(202);
                    }
                    else
                    {
                        ctx.result("Update failed");
                        ctx.status(401);

                    }
                }
            }
            else
            {
                ctx.result("You are not a manager");
                ctx.status(401);
            }
        }
        else{
            ctx.result("You are not logged in ");
            ctx.status(401);
        }

    };
}
