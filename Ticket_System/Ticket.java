package Ticket_System;

public abstract class Ticket {

    protected final int    ticketNumber;
    protected final String customerName;
    protected final Play   play;
    protected       float  ticketPrice;
    protected       short  peopleCount;

    private   static int ticketNumberCounter = 0; //ВСЕКИ БИЛЕТ СИ ИМА РАЗЛИЧЕН НОМЕР

    public Ticket(String customerName, int playNumber) {
        ticketNumber = ++ticketNumberCounter;
        this.customerName = customerName;
        play = Others.playFinder(playNumber);
        assert play != null;
        play.ticketList.addFirst(this);
    }

    public float getTicketPrice() { return ticketPrice; }
    public short getPeopleCount() { return peopleCount; }

    @Override
    public String toString(){
        char space = ' ';

        int f1 = play.getPlayTitle().length();
        int f1Space =  50-(f1+16);
        assert f1Space > 0;
        StringBuilder f1String = new StringBuilder();
        f1String.append(String.valueOf(space).repeat(f1Space));

        int f2 = customerName.length();
        int f2Space = 50-(f2+28);
        assert f2Space > 0;
        StringBuilder f2String = new StringBuilder();
        f2String.append(String.valueOf(space).repeat(f2Space));

        int f3 = String.valueOf(ticketNumber).length();
        int f4 = String.format("%.2f", ticketPrice).length();
        int f3Space = 50-(35+f3+f4);
        assert f3Space > 0;
        StringBuilder f3String = new StringBuilder();
        f3String.append(String.valueOf(space).repeat(f3Space));


        return String.format("""
                %s%s%s
                Клиент: %s%sВажи само за 1 човек
                номер на билета: %d%sцена на билета: %.2fлв
                """, play.getPlayTitle().toUpperCase(), f1String, play.getDateTime().format(Others.formatter),
                customerName, f2String,
                ticketNumber, f3String, ticketPrice);
    }

}
