package com.revature.models;

public class TicketDTO
{
    private int amount;
    private String description;

    public TicketDTO(int amount, String description)
    {
        this.amount = amount;
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
