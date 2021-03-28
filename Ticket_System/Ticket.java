package Ticket_System;

public abstract class Ticket {

    protected final int    ticketNumber;
    protected final String customerName;
    protected final Play   play;
    protected       float  ticketPrice;
    protected       short  seatsReserved;


    private static int ticketNumberCounter = 0;

    public Ticket(String customerName, Play play) {
        this.ticketNumber = ++ticketNumberCounter;
        this.customerName = customerName;
        this.play = play;
        this.play.ticketList.addFirst(this);
    }

    public float getTicketPrice() { return ticketPrice; }
    public short getSeatsReserved() { return seatsReserved; }

}
