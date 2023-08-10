package util;

import java.util.Scanner;

public class MenuUtil {
    public static int entryMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("[0]. System exit\n" +
                "[1]. Eat\n" +
                "[2]. Drink\n" +
                "[3]. Show\n" +
                "Choose option: ");
        return scanner.nextInt();
    }
}
