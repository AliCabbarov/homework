package util;

public class MenuUtil {
    private static MenuUtil instance;
    private MenuUtil(){

    }

    public static MenuUtil getInstance() {
        return instance == null ? instance = new MenuUtil() : instance;
    }
    public byte entryMenu(){
        System.out.println("-----------------|Rent A Car Management System |-------------------\n" +
                "[0]. Exit System\n" +
                "[1]. Order Car\n" +
                "[2]. Show Order\n" +
                "[3]. Add Car\n" +
                "[4]. Return Car");
        return InputUtil.getInstance().inputByte("Choose option: ");
    }
}
