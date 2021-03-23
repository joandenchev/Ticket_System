public class GroupTicket extends Tickets{

    public GroupTicket(String name, float price, Plays play, short count) {
        super(name, price, play);
        this.count = count;
    }
}
