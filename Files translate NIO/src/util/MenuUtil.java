package util;

public class MenuUtil {
    private static MenuUtil instance;
    private MenuUtil(){}

    public static MenuUtil getInstance() {
        return instance == null ? instance = new MenuUtil() : instance;
    }
    public int entryMenu(){
        System.out.println(
                "[0]. Exit\n" +
                "[1]. Play\n" +
                "[2]. Show Word\n" +
                "[3]. Add word");
        return InputUtil.getInstance().inputInt("Choose option: ");
    }

}
