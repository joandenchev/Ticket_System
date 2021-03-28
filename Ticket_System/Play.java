package Ticket_System;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Play {
    private       int     playNumber;
    private       String  playTitle;
    private final float   playPrice;
    private final LocalDateTime dateTime;

    protected LinkedList<Ticket> ticketList = new LinkedList<>();
    static final  LinkedList<Play> allPlays = new LinkedList<>();
    private  static int   playNumberCounter = 0;

    public Play(String playName, float price, LocalDateTime dateTime) {
        this.playNumber = ++playNumberCounter;
        this.playTitle  = playName;
        this.playPrice  = price;
        this.dateTime   = dateTime;
        allPlays.addFirst(this);
    }

    public String getPlayTitle() { return playTitle; }
    public void setPlayTitle(String playTitle) { this.playTitle = playTitle; }

    public int getPlayNumber() { return playNumber; }
    public void setPlayNumber(short playNumber) { this.playNumber = playNumber; }

    public float getPlayPrice() { return playPrice; }
    public LocalDateTime getDateTime() { return dateTime; }


    public float getProfit(@NotNull Play play){
        float profit = 0;
        for (Ticket p : play.ticketList) {
            profit = profit + (p.getTicketPrice()*p.getPeopleCount());
        }
        return profit;
    }
}
