package Ticket_System;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

public class Plays {
    private String playName;
    private short playNumber;
    protected LinkedList<Tickets> ticketList = new LinkedList<>();

    public Plays(String playName, short playNumber) {
        this.playName = playName;
        this.playNumber = playNumber;
    }

    public float getProfit(@NotNull Plays play){
        float profit = 0;
        for (Tickets p : play.ticketList) {
            profit = profit + (p.getPrice()*p.getCount());
        }
        return profit;
    }

    public String getPlayName() { return playName; }
    public void setPlayName(String playName) { this.playName = playName; }

    public short getPlayNumber() { return playNumber; }
    public void setPlayNumber(short playNumber) { this.playNumber = playNumber; }
}