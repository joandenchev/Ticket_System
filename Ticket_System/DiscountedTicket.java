package Ticket_System;

public class DiscountedTicket extends Ticket {

    public DiscountedTicket(String name, int playNumber) {
//CHANGED LINE
        //SECOND CHANGED LINE!!!!
        super(name, playNumber);
        ticketPrice = ((float) (0.5 * play.getPlayPrice()));
        peopleCount = 1;
        type = TicketType.DISCOUNTED;
    }
}
