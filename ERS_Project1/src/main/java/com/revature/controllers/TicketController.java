package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.daos.TicketDAO;
import com.revature.models.Ticket;
import com.revature.models.TicketDTO;
import io.javalin.http.Handler;

import java.util.ArrayList;


public class TicketController
{
    TicketDAO tDAO = new TicketDAO();

    /*
    public Handler getEmployeeHandler = (ctx) ->
    {
        ArrayList<Ticket> tickets = tDAO.getTicketByID(int id);

    }
             */
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
