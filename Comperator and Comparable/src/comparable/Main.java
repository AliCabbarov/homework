package comparable;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("a", "b", 13));
        users.add(new User("b", "l", 32));
        users.add(new User("c", "h", 1));
        users.add(new User("c", "n", 98));
        users.add(new User("b", "a", 2));
        Collections.sort(users);

        //ve ya asagidaki kimi

        users.sort(Comparator.reverseOrder());
        System.out.println(users);
    }
}
