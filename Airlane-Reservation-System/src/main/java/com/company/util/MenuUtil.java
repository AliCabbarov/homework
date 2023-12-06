package com.company.util;

public class MenuUtil {
    private static MenuUtil instance;
    private MenuUtil(){}

    public static MenuUtil getInstance() {
        return instance ==  null ? instance = new MenuUtil()  : instance;
    }

    public  byte entryMenu(){
        System.out.println("----------| Entry Menu |----------" +
                "\n[1]. Exit" +
                "\n[2]. Admin Menu" +
                "\n[3]. Customer Menu");
        return InputUtil.getInstance().inputByte("Choose option: ");
    }


    public byte adminMenu(){
        System.out.println("-----------| Admin Menu |-----------\n" +
                "[0] - > Exit \n" +
                        "[1] - > Back \n" +
                        "[2] - > Add Flight\n" +
                        "[3] - > View Tickets\n" +
                        "[4] - > View Passenger\n" +
                        "[5] - > View Notice Board \n" +
                        "[6] -> View Flight\n" +
                        "[7] -> Search All\n");
        return InputUtil.getInstance().inputByte("Choose option: ");
    }



    public byte customerMenu(){
        System.out.println("---------| Customer Menu |---------\n" +
                "[0] - > Exit \n" +
                "[1] - > Back \n" +
                "[2] - > View Flights \n" +
                "[3] - > Order Ticket\n" +
                "[4] - > Cancel Ticket\n");
        return InputUtil.getInstance().inputByte("Choose option: ");
    }

    public byte orderMenu(){
        System.out.println("--------| Order Menu |--------\n" +
                "[1] - > View Flights\n" +
                "[2] - > Search Flights");
        return InputUtil.getInstance().inputByte("Choose option: ");
    }
}
