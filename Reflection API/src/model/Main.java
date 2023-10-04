package model;

import java.lang.reflect.Constructor;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        Type type = new Type(user.getClass().getPackageName(),user.getClass().getName(),user.getClass().getDeclaredMethods(),user.getClass().getDeclaredFields(), (Constructor<User>[]) user.getClass().getDeclaredConstructors());
        System.out.println(type);


    }
}
