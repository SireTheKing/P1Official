package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.daos.ApprovedDAO;
import com.revature.daos.DeniedDAO;
import com.revature.daos.TicketDAO;
import com.revature.models.Ticket;
import com.revature.models.TicketDTO;
import io.javalin.http.Handler;

import java.util.ArrayList;


public class TicketController
{
    TicketDAO tDAO = new TicketDAO();
    ApprovedDAO appDAO = new ApprovedDAO();

    DeniedDAO DDAO = new DeniedDAO();


    public Handler getPendingTickets = (ctx) ->
    {
        ArrayList<Ticket> tickets = tDAO.getPendingTicketByID(1);

        Gson gson = new Gson();

        String JSONTicket = gson.toJson(tickets);

        ctx.result(JSONTicket);
        ctx.status(202);

    };

    public Handler getApprovedTickets = (ctx) ->
    {
        ArrayList<Ticket> tickets = appDAO.getTicketByID(2);

        Gson gson = new Gson();

        String JSONTicket = gson.toJson(tickets);


        ctx.result(JSONTicket);
        if(ctx.result(JSONTicket) != null) {
            ctx.status(202);
        }
        else {
            ctx.status(404);
        }

    };

    public Handler getDeniedTickets = (ctx) ->
    {
        ArrayList<Ticket> tickets = DDAO.getTicketByID(3);

        Gson gson = new Gson();

        String JSONTicket = gson.toJson(tickets);


        ctx.result(JSONTicket);
        if(ctx.result(JSONTicket) != null) {
            ctx.status(202);
        }
        else {
            ctx.status(404);
        }

    };

    public Handler insertTicketHandler = (ctx) ->
    {
        String body = ctx.body();

        Gson gson = new Gson();
        TicketDTO tDTO = gson.fromJson(body, TicketDTO.class);

        if(tDAO.InsertTicket(tDTO.getAmount(), tDTO.getDescription()))
        {
            ctx.status(201);
            ctx.result(body);
        }
        else
        {
            ctx.status(401);
            ctx.result(" Not here");
        }

    };
}
