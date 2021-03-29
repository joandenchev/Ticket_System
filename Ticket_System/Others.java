package Ticket_System;

import java.time.format.DateTimeFormatter;

public abstract class Others {

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    //НАМИРА ПРЕДСТАВЛЕНИЕ СПРЯМО СПРЯМО НОМЕРА МУ
    public static Play playFinder(int playNumber){
        for (Play i : Play.allPlays) {
            if (playNumber == i.getPlayNumber()){
                return i;
            }
        } return null;
    }

}
