package Ticket_System;

public class DiscountTicket extends Tickets{
    protected float discountedPrice;

    public DiscountTicket(String name, float price, Plays play) {
        super(name, price, play);
        this.discountedPrice = ((float)(0.5*price));
        this.count = 1;
    }
}
