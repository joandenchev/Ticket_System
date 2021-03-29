package Ticket_System;

public class NormalTicket extends Ticket {

    public NormalTicket(String name, int playNumber) {
        super(name, playNumber);
        ticketPrice   = play.getPlayPrice();
        peopleCount = 1;
    }
}
