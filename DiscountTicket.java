public class DiscountTicket extends Tickets{

    public DiscountTicket(String name, float price, Plays play) {
        super(name, price, play);
        this.price = ((float)(0.5*price));
        this.count = 1;
    }
}
