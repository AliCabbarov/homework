package tech;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        System.out.println("Field name - operating system - isPortable?");
        for (Field field: Tech.class.getDeclaredFields()) {
            OperatingSystem operatingSystem = field.getAnnotation(OperatingSystem.class);
            Portable portable = field.getAnnotation(Portable.class);
            System.out.println(field.getName() + " - " + operatingSystem.value() + " - " + portable.value());
        }
    }
}
