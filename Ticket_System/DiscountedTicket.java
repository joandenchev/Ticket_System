package Ticket_System;

public class DiscountedTicket extends Ticket {

    public DiscountedTicket(String name, Play play) {
        super(name, play);
        this.ticketPrice = ((float)(0.5*this.play.getPlayPrice()));
        this.seatsReserved = 1;
    }
}
