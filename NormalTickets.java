public class NormalTickets extends Tickets{

    public NormalTickets(String name, float price, Plays play) {
        super(name, price, play);
        this.count = 1;
    }
}
