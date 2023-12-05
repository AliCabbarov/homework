package az.DivAcademy.util;

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
                "\n[3]. Login Menu");
        return InputUtil.getInstance().inputByte("Choose option: ");
    }

    public byte likeOrDislike() {
        System.out.println("[1]. Like\n" +
                "[2]. Dislike");
        return InputUtil.getInstance().inputByte("Choose option: ");
    }
    public byte adminMenu(){
        System.out.println("-----------| Admin Menu |-----------\n" +
                "[0] - > Exit \n" +
                "[1] - > Back \n" +
                "[2] - > Add Book \n" +
                "[3] - > Add couriers\n" +
                "[4] - > Track Orders \n" +
                "[5] - > View Books \n" +
                "[6] - > View Customers\n" +
                "[7] - > View Couriers\n");
        return InputUtil.getInstance().inputByte("Choose option: ");
    }

    public byte loginMenu(){
        System.out.println("--------| Login Menu | --------\n" +
                "[0] - > Exit \n" +
                "[1] - > Login \n" +
                "[2] - > Sign up \n" +
                "[3] - > Back\n");
        return InputUtil.getInstance().inputByte("Choose option: ");
    }

    public byte customerMenu(){
        System.out.println("---------| Customer Menu |---------\n" +
                "[0] - > Exit \n" +
                "[1] - > Back \n" +
                "[2] - > Place Order \n" +
                "[3] - > Add a comment\n" +
                "[4] - > Like or Dislake\n" +
                "[4] - > View book\n" +
                "[5] - > Search book\n" +
                "[6] - > Track Orders \n" +
                "[7] - > Cancel Order\n");
        return InputUtil.getInstance().inputByte("Choose option: ");
    }
}
