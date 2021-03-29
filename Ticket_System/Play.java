package Ticket_System;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Play {
    private final int     playNumber;
    private final String  playTitle;
    private final float   playPrice;
    private final LocalDateTime dateTime;

    protected LinkedList<Ticket> ticketList = new LinkedList<>(); //ЛИСТ С ПРОДАДЕНИТЕ БИЛЕТИ (ВСЯКО ПРЕДСТАВЛЕНИЕ СИ ИМА ОТДЕЛЕН)
    static final  LinkedList<Play> allPlays = new LinkedList<>(); //ЛИСТ С ВСИЧКИ РЕГИСТРИРАНИ ПРЕДСТАВЛЕНИЯ
    private  static int   playNumberCounter = 0;

    public Play(String playName, float price, LocalDateTime dateTime) {
        playNumber = ++playNumberCounter; //ВСЯКО ПРЕДСТАВЛЕНИЕ ИМА НОВ НОМЕР
        playTitle  = playName;
        playPrice  = price;
        this.dateTime   = dateTime;
        allPlays.addLast(this); //ДОБАВЯ СЕ В СПИСЪКА С ВСИЧКИ ПРЕДСТАВЛЕНИЯ
    }

    public String getPlayTitle() { return playTitle; }

    public int getPlayNumber() { return playNumber; }

    public float getPlayPrice() { return playPrice; }
    public LocalDateTime getDateTime() { return dateTime; }


    public float getProfit(){
        float profit = 0;
        for (Ticket p : this.ticketList) {
            profit = profit + (p.getTicketPrice());
        }
        return profit;
    }

    public int getViewersCount(){
        int viewers = 0;
        for (Ticket p : this.ticketList) {
            viewers = viewers + (p.peopleCount);
        }
        return viewers;
    }

    public int getNormalViewers(){
        int viewers = 0;
        for (Ticket p : this.ticketList) {
            if (p.type == TicketType.NORMAL)
            viewers = viewers + (p.peopleCount);
        }
        return viewers;
    }

    public int getDiscountedViewers(){
        int viewers = 0;
        for (Ticket p : this.ticketList) {
            if (p.type == TicketType.DISCOUNTED)
                viewers = viewers + (p.peopleCount);
        }
        return viewers;
    }

    public int getGroupViewers(){
        int viewers = 0;
        for (Ticket p : this.ticketList) {
            if (p.type == TicketType.GROUP)
                viewers = viewers + (p.peopleCount);
        }
        return viewers;
    }

    @Override
    public String toString(){
        char space = ' ';

        int f1 = playTitle.length();
        int f1Space =  50-(f1+16);
        assert f1Space > 0;
        StringBuilder f1String = new StringBuilder();
        f1String.append(String.valueOf(space).repeat(f1Space));

        int f3 = String.valueOf(playNumber).length();
        int f4 = String.format("%.2f", playPrice).length();
        int f3Space = 50-(29+f3+f4);
        assert f3Space > 0;
        StringBuilder f3String = new StringBuilder();
        f3String.append(String.valueOf(space).repeat(f3Space));

        return String.format("""
                %s%s%s
                номер на представлението: %d%s %.2fлв
                """, playTitle.toUpperCase(), f1String,
                dateTime.format(Others.formatter),
                playNumber, f3String, playPrice);
    }
}
