package Ticket_System;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Run {
    private static final String dec1 = "--------------------------------------------------";
    private static final String dec2 = "======================================================================";
    static byte menuData; //ПРОМЕНЛИВА, ДАВАЩА ФУНКЦИОНАЛНОСТ НА МЕТОДА menus

    public static void main  (String[] args) {

        System.out.println("Ticket Console Application 1.0");
        demoPlays();
        toMain();

    }

    //ДОБАВЯ ПРЕДВАРИТЕЛНО ПОТГОТВЕНИ ПРЕДСТАВЛЕНИЯ В allPlays
    private static void demoPlays(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        String s1 = "04/05/2021 18:00";
        LocalDateTime dateTime1 = LocalDateTime.parse(s1,formatter);
        String s2 = "04/05/2021 17:30";
        LocalDateTime dateTime2 = LocalDateTime.parse(s2,formatter);
        String s3 = "05/05/2021 19:00";
        LocalDateTime dateTime3 = LocalDateTime.parse(s3,formatter);
        String s4 = "30/05/2021 12:50";
        LocalDateTime dateTime4 = LocalDateTime.parse(s4,formatter);
        String s5 = "04/05/2021 19:10";
        LocalDateTime dateTime5 = LocalDateTime.parse(s5,formatter);
        String s6 = "06/05/2021 18:00";
        LocalDateTime dateTime6 = LocalDateTime.parse(s6,formatter);
        String s7 = "05/05/2021 18:20";
        LocalDateTime dateTime7 = LocalDateTime.parse(s7,formatter);


        new Play("Летящата риба",              13.50f, dateTime1);
        new Play("Един слон с голям балон",    13.30f, dateTime5);
        new Play("Краставицата и звяра",       14    , dateTime2);
        new Play("Моркова и рукулата",         17    , dateTime3);
        new Play("Краси и 15те джуджета",      120   , dateTime6);
        new Play("Аватар: Легендата за Краси", 99.90f, dateTime4);
        new Play("Just a single raindrop",     15.50f, dateTime7);
    }

    //МЕТОД КОЙТО ОПРЕДЕЛЯ КОЕ МЕНЮ ДА СЕ ПОКАЖЕ СЛЕД ИЗВЪРШВАНЕ НА ДАДЕНА ОПЕРАЦИЯ
    private static void menus(){

        switch (menuData) {
            case 0, 20, 30 -> mainMenu();
            case 1 -> addPlay();
            case 2, 31 -> sellTicket();
            case 3, 25 -> viewPlays();
            case 4 -> showInfo();
            case 5 -> System.exit(0);
            case 9 -> addRandoms();
            case 21 -> sellNormalTicket();
            case 22 -> sellDiscountedTicket();
            case 23 -> sellGroupTicket();
            default -> {
                System.out.println("\n!!!ГРЕШКА!!! Опитайте отново!");
                toMain();
            }
        }
        menus();
    }
    //ПОКАЗВА ГЛАВНОТО МЕНЮ
    private static void toMain(){
        menuData = 0;
        mainMenu();
    }

    //ГЛАВНО МЕНЮ
    private static void mainMenu(){
        Scanner input = new Scanner(System.in);

        System.out.printf("""
                %s
                ГЛАВНО МЕНЮ!%n
                Опции:
                1. Добавяне  на представление
                2. Продажба  на билет
                3. Преглед   на представленията
                4. Добавяне  на билети със случайни стойности (ЗА ТЕСТВАНЕ)
                5. Извеждане на информация
                6. ИЗХОД%n
                Въведете номера на желаната от вас операция:
                """, dec2);
        byte i = input.nextByte();
        input.close();
        System.out.printf("%s", dec2);
        menuData = i;
        menus();
    }

    //МЕНЮ ЗА ДОБАВЯНЕ НА ПРЕДСТАВЛЕНИЕ (Валидацията е на ужасно basic level, но ме домързя да я довършвам)
    private static void addPlay(){
        Scanner input = new Scanner(System.in);
        Pattern pPrice = Pattern.compile("^(\\d+\\.\\d{2})|(\\d+)$"); //TO-DO: IMPROVE PATTERNS
        Pattern dateAndTime = Pattern.compile("^\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}$");

        System.out.printf("""
                %n%s
                Добавяне на представление!%n
                За отказ и връщане до главното меню въведете 0.
                Попълнете формуляра!
                VVV
                """, dec2);

        System.out.println("Наименование: ");
        String playTitle = input.nextLine();
        if (playTitle.equals("0")) toMain();

        System.out.println("Цена на обикновен билет: ");
        float playPrice = Float.parseFloat(input.next());
        if (playPrice == 0) toMain();

        System.out.println("Дата и час на представлението: ");
        System.out.println("!!!ФОРМАТИРА СЕ ПО СЛЕДНИЯ НАЧИН: dd/MM/yyyy HH:mm");
        String s1 = input.next();
        if (s1.equals("0")) toMain();
        String s2 = input.next();
        if (s2.equals("0")) toMain();
        String s = s1 + " " + s2;
        input.close();

        Matcher matcher1 = pPrice.matcher(Float.toString(playPrice));
        Matcher matcher2 = dateAndTime.matcher(s);
        boolean matchFound1 = matcher1.find();
        boolean matchFound2 = matcher2.find();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(s,formatter);

        if (matchFound1 && matchFound2) {
            new Play(playTitle, playPrice, dateTime);
            System.out.println("Представлението е успешно добавено в списъка!");
            System.out.printf("%s", dec2);
        } else {
            System.out.println("Не сте въвели правилно стойностите! Моля опитайте отново!");
            System.out.printf("%s", dec2);
            addPlay();
        }
        toMain();
    }

    //МЕНЮ ЗА ПРОДАВАНЕ НА БИЛЕТИ
    private static void sellTicket(){
        Scanner input = new Scanner(System.in);

        System.out.printf("""
                %n%s
                Продажба на билет!%n
                Опции:
                0. Отказ (Връщане към началното меню)
                1. Продажба на обикновен билет
                2. Продажба на билет с намаление (за деца и пенсионери)
                3. Продажба на групов билет (за няколко души)
                5. Преглед на представленията%n
                Въведете номера на желаната от вас операция:
                """, dec2);
        byte i = input.nextByte();
        input.close();
        System.out.printf("%s", dec2);
        menuData = (byte) (i + 20);
    }

    //МЕТОДИ ЗА ПРОДАВАНЕ НА БИЛЕТИ

    private static void sellNewTicket(TicketType type){

    }
    private static void sellNormalTicket(){
        Scanner input = new Scanner(System.in);

        System.out.printf("""
                %n%s
                Продажба на %s!%n
                За отказ и връщане до главното меню въведете 0.
                Попълнете формуляра!
                VVV
                """, dec2, ticket);

        System.out.println("Име на клиента:");
        String customerName = input.nextLine();
        if (customerName.equals("0")) toMain();

        System.out.println("Номер на представлението:");
        int playNumber = input.nextInt();
        input.close();
        if (playNumber == 0) toMain();
        Ticket ticket = new NormalTicket(customerName, playNumber);

        System.out.println("Ето го и билетчето...");
        System.out.println(dec1);
        System.out.print(ticket);
        System.out.println(dec1);
        System.out.printf("%n%s", dec2);

        sellTicket();
    }

    private static void sellDiscountedTicket(){
        Scanner input = new Scanner(System.in);

        System.out.printf("""
                %n%s
                Продажба на билет с намаление!%n
                За отказ и връщане до главното меню въведете 0.
                Попълнете формуляра!
                VVV
                """, dec2);

        System.out.println("Име на клиента:");
        String customerName = input.nextLine();
        if (customerName.equals("0")) toMain();

        System.out.println("Номер на представлението:");
        int playNumber = input.nextInt();
        input.close();
        if (playNumber == 0) toMain();
        Ticket ticket = new DiscountedTicket(customerName, playNumber);

        System.out.println("Ето го и билетчето...");
        System.out.println(dec1);
        System.out.print(ticket);
        System.out.println(dec1);
        System.out.printf("%n%s", dec2);

        sellTicket();
    }

    private static void sellGroupTicket(){
        Scanner input = new Scanner(System.in);

        System.out.printf("""
                %n%s
                Продажба на билет групов билет!%n
                За отказ и връщане до главното меню въведете 0.
                Попълнете формуляра!
                VVV
                """, dec2);

        System.out.println("Име на клиента:");
        String customerName = input.nextLine();
        if (customerName.equals("0")) toMain();

        System.out.println("Големина на групата:");
        short peopleCount = input.nextShort();
        if (peopleCount == 0) toMain();

        System.out.println("Номер на представлението:");
        int playNumber = input.nextInt();
        input.close();
        if (playNumber == 0) toMain();
        Ticket ticket = new GroupTicket(customerName, playNumber, peopleCount);

        System.out.println("Ето го и билетчето...");
        System.out.println(dec1);
        System.out.print(ticket);
        System.out.println(dec1);
        System.out.printf("%n%s", dec2);

        sellTicket();
    }

    private static void viewPlays(){

        for (Play i : Play.allPlays) {
            System.out.println("\n" + dec1);
            System.out.print(i);
            System.out.println(dec1);
        }

        System.out.println("0. Назад");
        System.out.println("1. Продай билет");

        Scanner input = new Scanner(System.in);
        menuData = (byte) (input.nextByte() + 30);
        input.close();
        System.out.printf("%s", dec2);
        menus();
    }

    private static void addRandoms(){

    }

    private static void showInfo(){

    }
}
