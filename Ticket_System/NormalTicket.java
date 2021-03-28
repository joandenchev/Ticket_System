package Ticket_System;

public class NormalTicket extends Ticket {

    public NormalTicket(String name, Play play) {
        super(name, play);
        this.ticketPrice = this.play.getPlayPrice();
        this.seatsReserved = 1;
    }
}
