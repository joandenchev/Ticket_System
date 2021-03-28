package Ticket_System;

public class GroupTicket extends Ticket {

    public GroupTicket(String name, Play play, short count) {
        super(name, play);
        this.seatsReserved = count;
        if (count >= 20) {
            this.ticketPrice = (this.play.getPlayPrice() - 2)*this.seatsReserved;
        } else {
            this.ticketPrice = (this.play.getPlayPrice())*this.seatsReserved;
        }
    }
}
