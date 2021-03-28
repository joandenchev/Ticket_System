package Ticket_System;

public abstract class Methods {

    public static Play playFinder(int playNumber){
        for (Play i : Play.allPlays) {
            if (playNumber == i.getPlayNumber()){
                return i;
            }
        } return null;
    }

}
