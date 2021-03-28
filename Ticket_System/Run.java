package Ticket_System;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Run {
    static String dec1 = "--------------------------------------------------";
    static String dec2 = "======================================================================";
    static byte   menuData;
    static final  LinkedList<Play> allPlays = new LinkedList<>();

    public static void main  (String[] args) {

        System.out.println("Ticket Console Application 1.0");
        toMain();

    }

    private static void menus(){

        switch (menuData) {
            case 0, 24 -> mainMenu();
            case 1 -> addPlay();
            case 2 -> sellTicket();
            case 3 -> viewPlays();
            case 4 -> addRandoms();
            case 5 -> showInfo();
            case 6 -> System.exit(0);
            case 21 -> sellNormalTicket();
            case 22 -> sellDiscountedTicket();
            case 23 -> sellGroupTicket();
            default -> {
                System.out.println("!!!ГРЕШКА!!! Опитайте отново!");
                toMain();
            }
        }
        menus();
    }

    private static void toMain(){
        menuData = 0;
        mainMenu();
    }

    private static void mainMenu(){
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
        menuData = i;
        menus();
    }

    private static void addPlay(){
        Scanner input = new Scanner(System.in);
        Pattern pPrice = Pattern.compile("^(\\d+\\.\\d{2})|(\\d+)$"); //TO-DO: IMPROVE PATTERNS
        Pattern dateAndTime = Pattern.compile("\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}");

        System.out.printf("""
                %n%s
                Добавяне на представление!%n
                За отказ и връщане до главното меню въведете 0.
                Въведете данните за представлението!
                """, dec2);
        System.out.println("Наименование: ");
        String playTitle = input.nextLine();

        if (playTitle.equals("0")) toMain();

        System.out.println("Цена на обикновен билет: ");
        float playPrice = Float.parseFloat(input.next());

        System.out.println("Дата и час на представлението: ");
        System.out.println("!!!ФОРМАТИРА СЕ ПО СЛЕДНИЯ НАЧИН: dd/MM/yyyy HH:mm");
        String s1 = input.next();
        String s2 = input.next();
        String s = s1 + " " + s2;

        Matcher matcher1 = pPrice.matcher(Float.toString(playPrice));
        Matcher matcher2 = dateAndTime.matcher(s);
        boolean matchFound1 = matcher1.find();
        boolean matchFound2 = matcher2.find();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(s,formatter);

        if (matchFound1 && matchFound2) {
            new Play(playTitle, playPrice, dateTime);
            System.out.println("Представлението е успешно добавено в списъка!");
            System.out.printf("%s%n", dec2);
        } else {
            System.out.println("Не сте въвели правилно стойностите! Моля опитайте отново!");
            System.out.printf("%s%n", dec2);
            addPlay();
        }
        toMain();
    }

    private static void sellTicket(){
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
        System.out.printf("%s%n", dec2);
        menuData = (byte) (i + 20);
    }

    private static void sellNormalTicket(){
        Scanner input = new Scanner(System.in);

        System.out.println("Име на клиента: ");
        String customerName = input.nextLine();

        System.out.printf("""
                %n%s
                Продажба на обикновен билет!%n
                За отказ и връщане до главното меню въведете 0.
                Въведете данни за покупката!
                """, dec2);


    }

    private static void sellDiscountedTicket(){

    }

    private static void sellGroupTicket(){

    }

    private static void viewPlays(){

    }

    private static void addRandoms(){

    }

    private static void showInfo(){

    }
}
