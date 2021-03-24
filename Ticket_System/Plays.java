package Ticket_System;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

//TO-DO: ADD DATABASE SUPPORT!

public class Plays {
    private       int     playNumber;
    private       String  playName;
    private final short   playPrice;
    private final LocalDateTime dateTime;

    protected LinkedList<Tickets> ticketList = new LinkedList<>();
    private   static int   playNumberCounter = 0;

    public Plays(String playName, short price, String dateTime) {
        this.playNumber = ++playNumberCounter;
        this.playName   = playName;
        this.playPrice  = price;
        this.dateTime   = LocalDateTime.parse(dateTime, formatter);
    }

    public String getPlayName() { return playName; }
    public void setPlayName(String playName) { this.playName = playName; }

    public int getPlayNumber() { return playNumber; }
    public void setPlayNumber(short playNumber) { this.playNumber = playNumber; }

    public short getPlayPrice() { return playPrice; }
    public LocalDateTime getDateTime() { return dateTime; }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH-mm : dd/MM/yyyy");

    public float getProfit(@NotNull Plays play){
        float profit = 0;
        for (Tickets p : play.ticketList) {
            profit = profit + (p.getTicketPrice()*p.getSeatsReserved());
        }
        return profit;
    }
}
