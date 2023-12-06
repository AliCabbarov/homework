package util;

import java.util.Random;

public class RandomUtil {
    private static RandomUtil instance;
    private RandomUtil(){

    }

    public static RandomUtil getInstance() {
        return instance ==  null ? instance = new RandomUtil() : instance;
    }
    public int inputRandom(){
        Random random = new Random();
        return random.nextInt(100) + 100;
    }
}
