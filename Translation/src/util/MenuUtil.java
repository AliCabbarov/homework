package util;

public class MenuUtil {
    private static MenuUtil instance;
    private MenuUtil(){}

    public static MenuUtil getInstance() {
        return instance == null ? instance = new MenuUtil() : instance;
    }
    public int entryMenu(){
        System.out.println(
                "[1]. Azerbaijan to English\n" +
                        "[2]. English to Azerbaijan\n" +
                        "[3]. Show Wordlist\n" +
                        "[4]. Show word count\n" +
                        "[5]. Add new words\n" +
                        "[6]. exit");
        return InputUtil.getInstance().inputInt("Choose option: ");
    }

}
