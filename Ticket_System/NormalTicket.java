package Ticket_System;

public class NormalTicket extends Ticket {

    public NormalTicket(String name, int playNumber) {
        super(name, playNumber);
        this.ticketPrice   = this.play.getPlayPrice();
        this.peopleCount = 1;
    }
}
