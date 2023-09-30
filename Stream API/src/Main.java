import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = Stream.iterate(1, i -> i + 1)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(integerList);

        // Print all number in the intList
        // TODO: Write code here
        integerList
                .forEach(System.out::print);
        System.out.println();


        // Print numbers in the intArray which are less than 5
        // TODO: Write code here
        Predicate<Integer> predicate = i -> i < 5;
        Consumer<Integer> consumer = System.out::print;
        integerList.stream()
                .filter(predicate)
                .forEach(consumer);
        System.out.println();

        // Print the second and third numbers in intList that's greater than 5
        // TODO: Write code here

        integerList.stream()
                .filter(i -> i > 5)
                .forEach(System.out::print);
        System.out.println();

        // Print the first number in intList that's less than 5
        // if nothing is found, print -1
        // TODO: Write code here
        Collections.reverse(integerList);

        Integer first = integerList.stream()
                .filter(i -> i < 5)
                .findFirst()
                .orElse(-1);
        System.out.println(first);


        //Print first names of all users in userList
        //  TODO: Write code here
        Stream<User> userStream = Stream.of(
                new User(1, "ali", "b"),
                new User(2, "cabbar", "d"),
                new User(3, "eyvaz", "f")
        );

        userStream
                .map(User::getFirstname)
                .forEach(System.out::print);
        System.out.println();


        // Print  sum of all number in intList
        //  TODO: Write code here

        Integer reduce = integerList.stream()
                .reduce(0, Integer::sum);
        System.out.println(reduce);

        // Print Square of all number in intList
        //  TODO: Write code here
        List<Integer> collect = integerList.stream()
                .map(i -> i * i)
                .collect(Collectors.toList());
        System.out.println(collect);

        // Print factorial of all number in intList
        // TODO: Write code here

        List<Integer> collect1 = integerList.stream()
                .map(i -> IntStream.rangeClosed(2, i)
                        .reduce(1, (j, k) -> j * k))
                .collect(Collectors.toList());
        System.out.println(collect1);


        //Task
        //1.	Stream api nədir?
        // Collection sinifindən olan classları bir axışa çevirərək onların üzərindən axışını təmin edir

        //1.	Həmin listin minimum elementini tapın.
        //2.	Həmin listin maximum elementini tapın.
        // TODO: Write code here

        Integer max = integerList.stream().max(Comparator.naturalOrder()).get();
        Integer min = integerList.stream().min(Comparator.naturalOrder()).get();

        System.out.println("max: " + max +
                "\nmin: " + min);

        //IntStream.range() -> daxil etdiyimzi araliqda sonuncu daxil olmamaq şərtilə
        // ədədləri streamə çevirir.
        // kod nümunəsi yuxarıda var


        // .allMatch() , .anyMatch() , .noneMatch() nədir nə üçün istifaddə olunur (example kod nümunəsi göstərin ).
        // .allMatch() -- streamdəki bütün dəyərlər bu şərtdən keçərsə bu halda true qayıdır
        // .anyMatch() -- streamdəki heç olmazsa bir dəyər  bu şərtdən keçərsə bu halda true qayıdır
        // .noneMatch() -- streamdəki heç bir dəyər bu çərtdən keçməzsə bu halda true qayıdır
        // TODO: Write code here

        List<Integer> list = Stream.iterate(1, i -> i + 1)
                .limit(10)
                .collect(Collectors.toList());

        boolean isAllMatch = list.stream().allMatch(i -> i > 0);
        System.out.println(isAllMatch); // true

        boolean isAnyMatch = list.stream().anyMatch(i -> i > 5);
        System.out.println(isAnyMatch); // true

        boolean isNoneMatch = list.stream().noneMatch(i -> i > 11);
        System.out.println(isNoneMatch); // true


        // .reduce() nədir nə üçün istifaddə olunur ( bir neçə example kod nümunəsi göstərin ).
        // .reduce() -- Hər hansı bir əməliyyatın cavabını ilkin parametrə mənimsədir və ikinci parametri bir vahid artırır
        // TODO: Write code here

        List<Integer> nums = Stream.iterate(1, i -> i + 1)
                .limit(10)
                .collect(Collectors.toList());

        Integer reduce1 = nums.stream()
                .reduce(0, Integer::sum);
        System.out.println("reduce: " + reduce1);


        //Bir List<User> və List<String> yaradın.
        //1.	User listin içərisində məlumatları müəyyən şərt daxilində Stringə çevirib hər birini List<String>-ə toplayın. (hint: filter, map, collect) misal ollaraq User daxilindeki name gotürə bilərsiniz .
        //2.	Daha sonra həmin toplanan List<String> içərisində yalnız simvol sayı 5-dən böyükləri çap edin.
        // TODO: Write code here

        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Ali", "Cabbarov"));
        userList.add(new User(1, "Cefer", "Cabbarov"));
        userList.add(new User(1, "Feqan", "Ceferov"));

        List<String> stringLastname = userList.stream().filter(user -> user.getLastname().length() > 1)
                .map(User::getFirstname)
                .collect(Collectors.toList());
        System.out.println(stringLastname);

        stringLastname.stream()
                .filter(str -> str.length() > 3)
                .forEach(System.out::print);
        System.out.println();


        //6.	Verilmiş ədədə qədər sadə ədədləri tapın.
        // TODO: Write code here


        List<Integer> numbers = Stream.iterate(1, i -> i + 1)
                .limit(100)
                .collect(Collectors.toList());


        List<Integer> collect2 = numbers.stream()
                .filter(i -> i % 2 != 0 && i != 1 || i == 2)
                .filter(Main::simpleNumber)
                .collect(Collectors.toList());

        System.out.println(collect2);
    }

    public static boolean simpleNumber(int number){
        return  IntStream.rangeClosed(3 , (int) Math.sqrt(number))
                .allMatch(i -> number % i != 0);
    }
}