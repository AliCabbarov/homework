import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ClockExamples {
    public static void main(String[] args) {
        Clock clock = Clock.systemUTC();
        LocalDateTime localDate = LocalDateTime.now(clock);
        System.out.println(localDate);// UTC saatini qaytarir
        Clock clock1 = Clock.systemDefaultZone();
        LocalDateTime localDate1 = LocalDateTime.now(clock1);
        System.out.println(localDate1);// olduquqmuz zonenun saatini qaytarir
    }
}
