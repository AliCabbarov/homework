package util;

import java.util.Random;

public class RandomUtil {
    private static RandomUtil instance;
    private RandomUtil(){}

    public static RandomUtil getInstance() {
        return instance ==  null ? instance = new RandomUtil() : instance;
    }

    public int getRandomIndex(int lengt){
        Random random = new Random();
        return random.nextInt(lengt);
    }

}
