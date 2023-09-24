package comparator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("a", "b", 13));
        users.add(new User("b", "l", 32));
        users.add(new User("c", "h", 1));
        users.add(new User("c", "n", 98));
        users.add(new User("b", "a", 2));
        System.out.println(users);
        users.sort(new ComparatorByAge().thenComparing(new ComparatorByName()).reversed());
        System.out.println(users);

    }
}