package util;

public class MenuUtil {
    public static MenuUtil instance;

    private MenuUtil() {
    }

    public static MenuUtil getInstance() {
        return instance == null ? instance = new MenuUtil() : instance;
    }

    public byte entryMenu(){
        System.out.println("0. exit\n" +
                "1. Register gym member\n" +
                "2. Show all members\n" +
                "3. Enter the gym\n" +
                "4. Update departures\n");
        return InputUtil.getInstance().inputByte("Choose option: ");
    }
}
