import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Question4Answer {
    public static void main(String[] args) {
        List<String> vector = new Vector<>();
        vector.add("Monday");
        vector.add("Tuesday");
        vector.add("Wednesday");
        vector.add("Thursday");
        vector.add("Friday");
        vector.add("Saturday");
        vector.add("Sunday");
        List<String> list = new ArrayList<>();
        list.add("Monday");
        list.add("Tuesday");
        list.add("Wednesday");
        list.add("Thursday");
        list.add("Friday");
        list.add("Saturday");
        list.add("Sunday");
        //4.1- Iterator və İterable den istifadə edərək hefdənin günlərini çap edin
        Iterator<String> iterator = vector.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //4.2- listdeki elementlerə get() methodu  ile muraciet edib butun elementləri çap edin
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //4.3- Friday -  axtarış edərək çap edin
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals("Friday")){
                System.out.println(list.get(i));
            }

        }
        //4.4 – listen Sunday – ı silin
        list.remove(6);

    }
}
