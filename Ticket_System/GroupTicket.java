package Ticket_System;

public class GroupTicket extends Tickets{
    protected float discountedPrice;
    protected String[] otherNames;

    public GroupTicket(String name, float price, Plays play, short count) {
        super(name, price, play);
        this.count = count;
        if (count >= 20) {
            this.discountedPrice = this.price - 2;
        } else {
            this.discountedPrice = this.price;
        }
    }
}
