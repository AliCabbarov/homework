package org.example.util;

public class MenuUtil {
    public static byte entryMenu(){
        System.out.println("--------| Entry Menu |--------" +
                "\n[0] -> System Exit" +
                "\n[1] -> Find by username" +
                "\n[2] -> Find all" +
                "\n[3] -> Find by id" +
                "\n[4] -> insert" +
                "\n[5] -> Update" +
                "\n[6] -> Delete");
        return InputUtil.getInstance().inputByte("Choose option: ");
    }
}
