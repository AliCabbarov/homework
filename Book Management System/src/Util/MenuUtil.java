package Util;

public class MenuUtil {
    public static int entryMenu(){
        System.out.println("\n[1]. Display books\n" +
                "[2]. Search book\n" +
                "[3]. Add books\n" +
                "[4]. Update book\n" +
                "[5]. Remove book\n"+
                "[0]. exit system");
        return InputUtil.inputRequiredInt("choose option: ");
    }
}
