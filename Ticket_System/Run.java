package Ticket_System;

import java.util.LinkedList;
import java.util.Scanner;

public class Run {
    static String dec1 = "----------------------------------------------------------------------";
    static String dec2 = "======================================================================";
    static final LinkedList<Plays> allPlays= new LinkedList<>();

    public static void main  (String[] args) {

        System.out.println("Ticket Console Application 1.0");
        menus((byte) 0);

    }

    private static void menus(byte menu){
        if (menu == 0){
            mainMenu();
        } else if (menu == 2){
            sellTicket();
        } else {
            System.out.println("ГРЕШКА! Моля изберете съществуваща опция!");
            menus(menu);
        }
    }

    private static byte mainMenu(){
        Scanner input = new Scanner(System.in);

        System.out.printf("""
                %s
                ГЛАВНО МЕНЮ!%n
                Опции:
                1. Добавяне  на представление
                2. Продажба  на билет
                3. Преглед   на постановките
                4. Добавяне  на билети със случайни стойности (ЗА ТЕСТВАНЕ)
                5. Извеждане на информация
                6. ИЗХОД%n
                Въведете номера на желаната от вас операция:
                """, dec2);
        byte i = input.nextByte();
        System.out.printf("%s%n", dec2);
        return i;
    }

    private static byte addPlay(){
        Scanner input = new Scanner(System.in);

        System.out.printf("""
                %n%s
                Добавяне на представление!%n
                Въведете данните за представлението:
                """, dec2);
        byte i = input.nextByte();
        System.out.printf("%s%%n", dec2);
        return (byte) (i+20);
    }

    private static byte sellTicket(){
        Scanner input = new Scanner(System.in);

        System.out.printf("""
                %n%s
                Продажба на билет!%n
                Опции:
                1. Продажба на обикновен билет
                2. Продажба на билет с намаление (за деца и пенсионери)
                3. Продажба на групов билет (за няколко души)
                4. Отказ (Връщане към началното меню)%n
                Въведете номера на желаната от вас операция:
                """, dec2);
        byte i = input.nextByte();
        System.out.printf("%s%%n", dec2);
        return (byte) (i+20);
    }
}
