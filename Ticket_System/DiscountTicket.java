package Ticket_System;

public class DiscountTicket extends Tickets{

    public DiscountTicket(String name, Plays play) {
        super(name, play);
        this.ticketPrice = ((float)(0.5*this.play.getPlayPrice()));
        this.seatsReserved = 1;
    }
}
