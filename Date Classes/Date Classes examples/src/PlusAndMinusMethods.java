import java.time.LocalDateTime;

public class PlusAndMinusMethods {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.plusHours(2));
        System.out.println(localDateTime.minusHours(2));  // month, years, nanosecond ve.s

    }
}
