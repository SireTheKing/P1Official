package com.revature.models;

public class Type
{
    private int ticket_type_id;
    private String ticket_type_title;

    public Type(int ticket_type_id, String ticket_type_title) {
        this.ticket_type_id = ticket_type_id;
        this.ticket_type_title = ticket_type_title;
    }

    public Type(String ticket_type_title) {
        this.ticket_type_title = ticket_type_title;
    }

    public int getTicket_type_id() {
        return ticket_type_id;
    }

    public void setTicket_type_id(int ticket_type_id) {
        this.ticket_type_id = ticket_type_id;
    }

    public String getTicket_type_title() {
        return ticket_type_title;
    }

    public void setTicket_type_title(String ticket_type_title) {
        this.ticket_type_title = ticket_type_title;
    }

    @Override
    public String toString() {
        return "Type{" +
                "ticket_type_id=" + ticket_type_id +
                ", ticket_type_title='" + ticket_type_title + '\'' +
                '}';
    }
}

