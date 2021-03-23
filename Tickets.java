import java.util.LinkedList;

public abstract class Tickets {
    protected final String name;
    protected float price;
    protected final int ticketNumber;
    protected short count;
    protected final Plays play;


    private static int ticketNumberCounter = 0;

    public Tickets(String name, float price, Plays play) {
        this.name = name;
        this.price = price;
        this.play = play;
        this.ticketNumber = ++ticketNumberCounter;
        this.play.allTickets.add(this);
    }

    public float getPrice() { return price; }
    public short getCount() { return count; }

}
