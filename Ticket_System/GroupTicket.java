package Ticket_System;

public class GroupTicket extends Tickets{

    public GroupTicket(String name, Plays play, short count) {
        super(name, play);
        this.seatsReserved = count;
        if (count >= 20) {
            this.ticketPrice = (this.play.getPlayPrice() - 2)*this.seatsReserved;
        } else {
            this.ticketPrice = (this.play.getPlayPrice())*this.seatsReserved;
        }
    }
}
