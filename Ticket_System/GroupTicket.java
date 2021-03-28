package Ticket_System;

public class GroupTicket extends Ticket {

    public GroupTicket(String name, int playNumber, short peopleCount) {
        super(name, playNumber);
        this.peopleCount = peopleCount;
        if (peopleCount >= 20) {
            this.ticketPrice = (this.play.getPlayPrice() - 2) * this.peopleCount;
        } else {
            this.ticketPrice = (this.play.getPlayPrice()) * this.peopleCount;
        }
    }

    @Override
    public String toString() {
        char space = ' ';

        int f1 = this.play.getPlayTitle().length();
        int f1Space = 50 - (16 + f1);
        assert f1Space > 0;
        StringBuilder f1String = new StringBuilder();
        f1String.append(String.valueOf(space).repeat(f1Space));

        int f2 = this.customerName.length();
        int f5 = String.valueOf(this.peopleCount).length();
        int f2Space = 50 - (26 + f2 + f5);
        assert f2Space > 0;
        StringBuilder f2String = new StringBuilder();
        f2String.append(String.valueOf(space).repeat(f2Space));

        int f3 = String.valueOf(this.ticketNumber).length();
        int f4 = String.format("%.2f", this.ticketPrice).length();
        int f3Space = 50 - (35 + f3 + f4);
        assert f3Space > 0;
        StringBuilder f3String = new StringBuilder();
        f3String.append(String.valueOf(space).repeat(f3Space));


        return String.format("""
                        %s%s%s
                        Клиент: %s%sВажи за общо %d души
                        номер на билета: %d%sцена на билета: %.2fлв
                        """, this.play.getPlayTitle().toUpperCase(), f1String, this.play.getDateTime().format(formatter),
                this.customerName, f2String, this.peopleCount,
                this.ticketNumber, f3String, this.ticketPrice);
    }
}
