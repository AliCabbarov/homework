package util;

import java.util.Scanner;

public class MenuUtil {
    public static int menuEntry() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("[1]. eat\n" +
                "[2]. drink\n" +
                "[3]. show health status");

        System.out.print("Choose option: ");
        return scanner.nextInt();
    }
}
