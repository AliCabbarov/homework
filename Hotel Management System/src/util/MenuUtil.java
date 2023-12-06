package util;

public class MenuUtil {
    private static MenuUtil instance;
    private MenuUtil(){}

    public static MenuUtil getInstance() {
        return instance ==  null ? instance = new MenuUtil()  : instance;
    }
    public byte entryMenu(){
        System.out.println("[0] -> Exit System\n" +
                "[1] -> Admin Service\n" +
                "[2] -> Reservation\n" +
                "[3] -> Customer service");
        return InputUtil.getInstance().inputByte("Choose option: ");
    }
    public byte adminMenu(){
        System.out.println("[0] -> Exit System\n" +
                "[1] -> Back\n" +
                "[2] -> Register Room\n" +
                "[3] -> Show customer info\n" +
                "[4] -> Show room info (All rooms)\n" +
                "[5] -> Show reservation\n" +
                "[6] -> Show hotel Info\n" +
                "[7] -> Search customer\n" +
                "[8] -> Update Rooms");
        return InputUtil.getInstance().inputByte("Choose option: ");
    }
    public byte customerMenu(){
        System.out.println("[0] -> Exit System\n" +
                "[1] -> Back\n" +
                "[2] -> Sign up\n" +
                "[3] -> Login");
        return InputUtil.getInstance().inputByte("Choose option: ");
    }
    public byte LoginMenu(){
        System.out.println("[0] -> Exit System\n" +
                "[1] -> Back\n" +
                "[2] -> Show reservation\n" +
                "[3] -> End date update\n" +
                "[4] -> Increase money Account\n" +
                "[5] -> Cancel to reservation\n" +
                "[6] -> Show Customer");
        return InputUtil.getInstance().inputByte("Choose option: ");
    }


}
