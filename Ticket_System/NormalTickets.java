package Ticket_System;

public class NormalTickets extends Tickets{

    public NormalTickets(String name, Plays play) {
        super(name, play);
        this.ticketPrice = this.play.getPlayPrice();
        this.seatsReserved = 1;
    }
}
