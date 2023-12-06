package util;

import java.util.Scanner;

public class InputUtil {
    public static InputUtil instance;

    private InputUtil() {
    }

    public static InputUtil getInstance() {
        return instance == null ? instance = new InputUtil() : instance;
    }

    public int inputInt(String title){
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextInt();
    }


    public byte inputByte(String title){
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextByte();
    }

    public String inputString(String title){
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextLine();
    }
    public double inputDouble(String title){
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextDouble();
    }
}
