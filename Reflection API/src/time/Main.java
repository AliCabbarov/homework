package time;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Time time = new Time();
        for (Method method: Time.class.getDeclaredMethods()) {
            TimeManager timeManager = method.getAnnotation(TimeManager.class);
            System.out.println(timeManager.value() + method.invoke(time));
        }

    }
}
