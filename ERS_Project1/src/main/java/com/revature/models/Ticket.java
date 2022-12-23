package com.revature.models;

public class Ticket
{
    private int ticket_id;

    private int ticket_amount;

    private String ticket_description;

    private int ticket_status_id_fk;
    private int ticket_type_id_fk;
    private int ticket_user_id_fk;


    public Ticket(int ticket_user_id_fk) {
        this.ticket_user_id_fk = ticket_user_id_fk;
    }

    public Ticket()
    {
    }

    public Ticket(int ticket_id, int ticket_amount,
                  String ticket_description, int ticket_status_id_fk,
                  int ticket_type_id_fk, int ticket_user_id_fk)
    {
        this.ticket_id = ticket_id;
        this.ticket_amount = ticket_amount;
        this.ticket_description = ticket_description;
        this.ticket_status_id_fk = ticket_status_id_fk;
        this.ticket_type_id_fk = ticket_type_id_fk;
        this.ticket_user_id_fk = ticket_user_id_fk;
    }

    public Ticket(int ticket_amount, String ticket_description)
    {
        this.ticket_amount = ticket_amount;
        this.ticket_description = ticket_description;
    }

    public Ticket(int ticket_id, int ticket_amount, String ticket_description, int ticket_type_id_fk, int ticket_user_id_fk) {
        this.ticket_id = ticket_id;
        this.ticket_amount = ticket_amount;
        this.ticket_description = ticket_description;
        this.ticket_type_id_fk = ticket_type_id_fk;
        this.ticket_user_id_fk = ticket_user_id_fk;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public int getTicket_amount() {
        return ticket_amount;
    }

    public void setTicket_amount(int ticket_amount) {
        this.ticket_amount = ticket_amount;
    }

    public String getTicket_description() {
        return ticket_description;
    }

    public void setTicket_description(String ticket_description) {
        this.ticket_description = ticket_description;
    }

    public int getTicket_status_id_fk() {
        return ticket_status_id_fk;
    }

    public void setTicket_status_id_fk(int ticket_status_id_fk) {
        this.ticket_status_id_fk = ticket_status_id_fk;
    }

    public int getTicket_type_id_fk() {
        return ticket_type_id_fk;
    }

    public void setTicket_type_id_fk(int ticket_type_id_fk) {
        this.ticket_type_id_fk = ticket_type_id_fk;
    }

    public int getTicket_user_id_fk() {
        return ticket_user_id_fk;
    }

    public void setTicket_user_id_fk(int ticket_user_id_fk) {
        this.ticket_user_id_fk = ticket_user_id_fk;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticket_id=" + ticket_id +
                ", ticket_amount=" + ticket_amount +
                ", ticket_description='" + ticket_description + '\'' +
                ", ticket_status_id_fk=" + ticket_status_id_fk +
                ", ticket_type_id_fk=" + ticket_type_id_fk +
                ", ticket_user_id_fk=" + ticket_user_id_fk +
                '}';
    }
}
