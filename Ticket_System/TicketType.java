package Ticket_System;

import java.util.List;
import java.util.Random;

public enum TicketType {
    NORMAL,
    DISCOUNTED,
    GROUP;

    private static final List<TicketType> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static TicketType randomType()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
