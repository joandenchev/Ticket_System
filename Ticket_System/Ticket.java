package Ticket_System;

import java.time.format.DateTimeFormatter;

public abstract class Ticket {

    protected final int    ticketNumber;
    protected final String customerName;
    protected final Play   play;
    protected       float  ticketPrice;
    protected       short  peopleCount;

    protected static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private   static int ticketNumberCounter = 0;

    public Ticket(String customerName, int playNumber) {
        this.ticketNumber = ++ticketNumberCounter;
        this.customerName = customerName;
        this.play = Methods.playFinder(playNumber);
        assert this.play != null;
        this.play.ticketList.addFirst(this);
    }

    public float getTicketPrice() { return ticketPrice; }
    public short getPeopleCount() { return peopleCount; }

    @Override
    public String toString(){
        char space = ' ';

        int f1 = this.play.getPlayTitle().length();
        int f1Space =  50-(f1+16);
        assert f1Space > 0;
        StringBuilder f1String = new StringBuilder();
        f1String.append(String.valueOf(space).repeat(f1Space));

        int f2 = this.customerName.length();
        int f2Space = 50-(f2+28);
        assert f2Space > 0;
        StringBuilder f2String = new StringBuilder();
        f2String.append(String.valueOf(space).repeat(f2Space));

        int f3 = String.valueOf(this.ticketNumber).length();
        int f4 = String.format("%.2f", this.ticketPrice).length();
        int f3Space = 50-(35+f3+f4);
        assert f3Space > 0;
        StringBuilder f3String = new StringBuilder();
        f3String.append(String.valueOf(space).repeat(f3Space));


        return String.format("""
                %s%s%s
                Клиент: %s%sВажи само за 1 човек
                номер на билета: %d%sцена на билета: %.2fлв
                """, this.play.getPlayTitle().toUpperCase(), f1String, this.play.getDateTime().format(formatter),
                this.customerName, f2String,
                this.ticketNumber, f3String, this.ticketPrice);
    }

}
