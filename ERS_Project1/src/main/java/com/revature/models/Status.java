package com.revature.models;

public class Status
{
    private int ticket_type_id;
    private String ticket_status_title;

    public Status()
    {
    }

    public Status(int ticket_type_id, String ticket_status_title) {
        this.ticket_type_id = ticket_type_id;
        this.ticket_status_title = ticket_status_title;
    }

    public Status(String ticket_status_title)
    {
        this.ticket_status_title = ticket_status_title;
    }

    public int getTicket_type_id() {
        return ticket_type_id;
    }

    public void setTicket_type_id(int ticket_type_id) {
        this.ticket_type_id = ticket_type_id;
    }

    public String getTicket_status_title() {
        return ticket_status_title;
    }

    public void setTicket_status_title(String ticket_status_title) {
        this.ticket_status_title = ticket_status_title;
    }

    @Override
    public String toString() {
        return "Status{" +
                "ticket_type_id=" + ticket_type_id +
                ", ticket_status_title='" + ticket_status_title + '\'' +
                '}';
    }
}
