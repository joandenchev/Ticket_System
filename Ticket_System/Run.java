package Ticket_System;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Run {
    private static final String dec1 = "--------------------------------------------------";
    private static final String dec2 = "======================================================================";
    static byte menuData;

    public static void main  (String[] args) {

        demoPlays();
        System.out.println("Ticket Console Application 1.0");
        toMain();

    }

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
        new Play("Един слон с голям балон",    13.80f, dateTime5);
        new Play("Краставицата и звяра",       14    , dateTime2);
        new Play("Моркова и руколата",         17    , dateTime3);
        new Play("Краси и 15те джуджета",      120   , dateTime6);
        new Play("Аватар: Легендата за Краси", 99.90f, dateTime4);
        new Play("Just a single raindrop",     15.50f, dateTime7);
    }

    private static void menus(){

        switch (menuData) {
            case 0, 20, 30, 40, 90 -> mainMenu();
            case 1  -> addPlay();
            case 2, 31 -> sellTicket();
            case 3, 25 -> viewPlays();
            case 4  -> showInfo();
            case 5  -> System.exit(0);
            case 9  -> addRandoms();
            case 21 -> sellNewTicket(TicketType.NORMAL);
            case 22 -> sellNewTicket(TicketType.DISCOUNTED);
            case 23 -> sellNewTicket(TicketType.GROUP);
            case 41 -> showTicketList();
            case 42 -> showTicketListForAll();
            case 91 -> addRandoms1();
            case 92 -> addRandoms2();
            default -> {
                System.out.println("\n!!!ГРЕШКА!!! Опитайте отново!");
                toMain();
            }
        }
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
                3. Преглед   на представленията
                4. Извеждане на информация
                5. ИЗХОД
                9. Добавяне  на билети със случайни стойности (ЗА ТЕСТОВЕ)%n
                Въведете номера на желаната от вас операция:
                """, dec2);
        menuData = input.nextByte();
        System.out.printf("%s%n", dec2);
        menus();
    }

    private static void addPlay(){
        Scanner input = new Scanner(System.in);
        Pattern pPrice = Pattern.compile("^(\\d+\\.\\d{2})|(\\d+)$"); //TO-DO: IMPROVE PATTERNS
        Pattern dateAndTime = Pattern.compile("^\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}$");

        System.out.printf("""
                %s
                Добавяне на представление!%n
                За отказ и връщане до главното меню въведете 0.
                Попълнете формуляра!
                VVV
                """, dec2);

        System.out.println("Наименование: ");
        String playTitle = input.nextLine();
        if (playTitle.equals("0")) {
            System.out.printf("%s%n", dec2);
            toMain();
        }

        System.out.println("Цена на обикновен билет: ");
        float playPrice = Float.parseFloat(input.next());
        if (playPrice == 0) {
            System.out.printf("%s%n", dec2);
            toMain();
        }

        System.out.println("Дата и час на представлението: ");
        System.out.println("!!!ФОРМАТИРА СЕ ПО СЛЕДНИЯ НАЧИН: dd/MM/yyyy HH:mm");
        String s1 = input.next();
        if (s1.equals("0")) toMain();
        String s2 = input.next();
        if (s2.equals("0")) toMain();
        String s = s1 + " " + s2;


        Matcher matcher1 = pPrice.matcher(Float.toString(playPrice));
        Matcher matcher2 = dateAndTime.matcher(s);
        boolean matchFound1 = matcher1.find();
        boolean matchFound2 = matcher2.find();

        if (matchFound1 && matchFound2) {
            System.out.println("Представлението е успешно добавено в списъка!");
            System.out.printf("%s%n", dec2);
        } else {
            System.out.println("Не сте въвели правилно стойностите! Моля опитайте отново!");
            System.out.println("Примерно въвеждане: 29/09/2021 20:10");
            System.out.printf("%s%n", dec2);
            addPlay();
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(s,formatter);
        new Play(playTitle, playPrice, dateTime);

        toMain();
    }

    private static void sellTicket(){
        Scanner input = new Scanner(System.in);

        System.out.printf("""
                %s
                Продажба на билет!%n
                Опции:
                0. Отказ (Връщане към началното меню)
                1. Продажба на обикновен билет
                2. Продажба на билет с намаление (за деца и пенсионери)
                3. Продажба на групов билет (за няколко души)
                5. Преглед на представленията%n
                VVV
                """, dec2);
        menuData = (byte) (input.nextByte()+20);
        System.out.printf("%s%n", dec2);
        menus();
    }

    private static void sellNewTicket(TicketType type){
        String ticketString;
        switch (type){
            case NORMAL -> ticketString = "обикновен билет";
            case DISCOUNTED -> ticketString = "билет с намаление";
            case GROUP -> ticketString = "групов билет";
            default -> ticketString = "билет";
        }

        Scanner input = new Scanner(System.in);

        System.out.printf("""
                %s
                Продажба на %s!%n
                За отказ и връщане до главното меню въведете 0.
                Попълнете формуляра!
                VVV
                """, dec2, ticketString);

        System.out.println("Име на клиента:");
        String customerName = input.nextLine();
        if (customerName.equals("0")) toMain();

        System.out.println("Номер на представлението:");
        int playNumber = input.nextInt();
        if (playNumber == 0) toMain();

        Ticket ticket;
        switch (type){
            case NORMAL -> ticket = new NormalTicket(customerName, playNumber);
            case DISCOUNTED -> ticket = new DiscountedTicket(customerName, playNumber);
            case GROUP -> {
                System.out.println("Големина на групата:");
                short peopleCount = input.nextShort();
                if   (peopleCount == 0)      toMain();
                ticket = new GroupTicket(customerName, playNumber, peopleCount);
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }


        System.out.println("\nЕто го и билетчето...");
        System.out.println(dec1);
        System.out.print(ticket);
        System.out.println(dec1);
        System.out.printf("%n%s%n", dec2);

        sellTicket();
    }

    private static void viewPlays(){

        System.out.print("\n" + dec2);

        for (Play i : Play.allPlays) {
            System.out.println("\n" + dec1);
            System.out.print(i);
            System.out.println(dec1);
        }

        System.out.println("\nОпции:");
        System.out.println("0. Назад");
        System.out.println("1. Продай билет");
        System.out.println("\nVVV");

        Scanner input = new Scanner(System.in);
        menuData = (byte) (input.nextByte() + 30);
        System.out.printf("%s%n", dec2);
        menus();
    }

    private static void addRandoms(){
        Scanner input = new Scanner(System.in);

        System.out.printf("""
                %s
                Генериране на билети!%n
                Опции:
                0. Назад
                1. Генерирай за определено представление
                2. Генерирай за случайни представления
                VVV
                """, dec2);

        menuData = (byte) (input.nextByte()+90);
        System.out.printf("%s%n", dec2);
        menus();
    }

    private static void addRandoms1(){

        Scanner input = new Scanner(System.in);

        System.out.printf("""
                %s
                Генерация на билети!%n
                За отказ и връщане до главното меню въведете 0.
                Попълнете формуляра!
                VVV
                """, dec2);

        System.out.println("Номер на представлението, за което ще се генерират билети:");
        int playNumber = input.nextInt();
        if (playNumber == 0) toMain();

        System.out.println("Колко билета искате да генерирате?");
        int amount = input.nextInt();
        if (amount == 0) toMain();

        Others.addRandoms(playNumber, amount);
        System.out.printf("Процесът беше успешен!%n%s%n", dec2);
        toMain();
    }

    private static void addRandoms2(){

    }

    private static void showInfo(){
        Scanner input = new Scanner(System.in);

        System.out.printf("""
                %s
                Извеждане на информация!%n
                Опции:
                0. Отказ (Връщане към началното меню)
                1. Извеждане на всички продадени билети за дадена постановка
                2. Извеждане на абсолютно всички продадени билети
                3. Извеждане на подробна информация за дадено представление
                4. ИЗВЕЖДАНЕ НА АБСОЛЮТНО ВСИЧКО БАЦЕ%n
                VVV
                """, dec2);
        menuData = (byte) (input.nextByte()+40);
        System.out.printf("%s%n", dec2);
        menus();
    }

    private static void showTicketList(){
        Scanner input = new Scanner(System.in);

        System.out.printf("""
                %s
                Извеждане на информация!%n
                За отказ и връщане до главното меню въведете 0.
                Въведете номера на желаното представление!
                VVV
                """, dec2);
        int playNumber = input.nextInt();
        if (playNumber == 0) toMain();
        showTicketList1(Objects.requireNonNull(Others.playFinder(playNumber)));
    }

    private static void showTicketListForAll(){
        for (Play i : Play.allPlays) {
            showTicketList1(i);
        }
    }

    private static void showTicketList1(Play play){

        System.out.println("\n");
        for (Ticket i : play.ticketList) {
            System.out.println(i.toListedString());
        }
    }
}
