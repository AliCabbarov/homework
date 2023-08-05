import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterExamples {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(" 'Tarix: 'yyyy MMMM dd ");
        System.out.println(dateTimeFormatter.format(localDateTime));
    }
}
