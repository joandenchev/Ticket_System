package Ticket_System;

import java.time.format.DateTimeFormatter;

public abstract class Others {

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public static Play playFinder(int playNumber){
        for (Play i : Play.allPlays) {
            if (playNumber == i.getPlayNumber()){
                return i;
            }
        } return null;
    }

    public static void addRandoms(int playNumber, int amount){

        String customerName = "UNSPECIFIED";
        short peopleCount;
        for (int i = 0; i < amount; i++) {
            TicketType randomType = TicketType.randomType();
            switch (randomType){
                case NORMAL     -> new NormalTicket(customerName, playNumber);
                case DISCOUNTED -> new DiscountedTicket(customerName, playNumber);
                case GROUP      -> {
                    peopleCount =(short) (5 + (int)(Math.random() * ((30 - 5) + 1)));
                    new GroupTicket(customerName, playNumber, peopleCount);
                }
                default -> throw new IllegalStateException("Unexpected value!");
            }
        }

    }

    public static Ticket ticketFinder(int ticketNumber){
        for (Play i : Play.allPlays) {

            for (Ticket t : i.ticketList) {
                if (t.ticketNumber == ticketNumber) return t;
            }

        }
        return null;
    }

    public static float UltimateProfit(){
        float ultimateProfit = 0;
        for (Play p : Play.allPlays) {
            for (Ticket t : p.ticketList) {
                ultimateProfit = ultimateProfit + t.getTicketPrice();
            }
        }
        return ultimateProfit;
    }

    public static int UltimateViewerCount(){
        int ultimateViewerCount = 0;
        for (Play p : Play.allPlays) {
            for (Ticket t : p.ticketList) {
                ultimateViewerCount = ultimateViewerCount + t.getPeopleCount();
            }
        }
        return ultimateViewerCount;
    }
}
