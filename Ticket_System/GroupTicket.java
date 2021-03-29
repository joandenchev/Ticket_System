package Ticket_System;

public class GroupTicket extends Ticket {

    public GroupTicket(String name, int playNumber, short peopleCount) {
        super(name, playNumber);
        this.peopleCount = peopleCount;
        if (peopleCount >= 20) {
            ticketPrice = (play.getPlayPrice() - 2) * this.peopleCount;
        } else {
            ticketPrice = (play.getPlayPrice()) * this.peopleCount;
        }
        type = TicketType.GROUP;
    }

    @Override
    public String toString() {
        char space = ' ';

        int f1 = play.getPlayTitle().length();
        int f1Space = 50 - (16 + f1);
        assert f1Space > 0;
        StringBuilder f1String = new StringBuilder();
        f1String.append(String.valueOf(space).repeat(f1Space));

        int f2 = customerName.length();
        int f5 = String.valueOf(peopleCount).length();
        int f2Space = 50 - (26 + f2 + f5);
        assert f2Space > 0;
        StringBuilder f2String = new StringBuilder();
        f2String.append(String.valueOf(space).repeat(f2Space));

        int f3 = String.valueOf(ticketNumber).length();
        int f4 = String.format("%.2f", ticketPrice).length();
        int f3Space = 50 - (35 + f3 + f4);
        assert f3Space > 0;
        StringBuilder f3String = new StringBuilder();
        f3String.append(String.valueOf(space).repeat(f3Space));


        return String.format("""
                        %s%s%s
                        Клиент: %s%sВажи за общо %d души
                        номер на билета: %d%sцена на билета: %.2fлв
                        """, play.getPlayTitle().toUpperCase(),
                f1String, play.getDateTime().format(Others.formatter),
                customerName, f2String, peopleCount,
                ticketNumber, f3String, ticketPrice);
    }
}
