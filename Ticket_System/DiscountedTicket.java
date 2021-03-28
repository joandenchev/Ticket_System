package Ticket_System;

public class DiscountedTicket extends Ticket {

    public DiscountedTicket(String name, int playNumber) {
        super(name, playNumber);
        this.ticketPrice = ((float) (0.5 * this.play.getPlayPrice()));
        this.peopleCount = 1;
    }
}
