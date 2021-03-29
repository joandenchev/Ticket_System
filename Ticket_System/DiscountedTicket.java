package Ticket_System;

public class DiscountedTicket extends Ticket {

    public DiscountedTicket(String name, int playNumber) {
        super(name, playNumber);
        ticketPrice = ((float) (0.5 * play.getPlayPrice()));
        peopleCount = 1;
        type = TicketType.DISCOUNTED;
    }
}
