import java.time.*;
import java.time.format.DateTimeFormatter;

public class MainDateTasks {
    public static void main(String[] args) {
        //1. LocaleDateTime nədir? Numune kodu yazın // LocalDateTime classi tarixi ve zamani gostermek ucundur
        LocalDateTime localDateTime = LocalDateTime.of(2023, 10, 20, 20, 55);
        System.out.println(localDateTime);

        //2. LocaleTime və LocalDate nədir?Numune kodu yazın
        LocalDate localDate = LocalDate.of(20203, 10, 23); // Yalniz tarixi gostermek ucundur
        System.out.println(localDate);
        LocalTime localTime = LocalTime.of(20,55);// yalniz zaman; gostermek ucundur
        System.out.println(localTime);

        //3. İstifadəçidən bir tarix alın və həmin tarixi gün/ay/il olarağ çap edin. Amma, ildə sadəcə son 2 rəqəm yazılsın. Nümunə: 10/01/23

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("'Date: 'dd'/'MM'/'yy");
        LocalDate localDate1 = LocalDate.now();
        System.out.println(dateTimeFormatter.format(localDate1));

        //4.  of() - methodu nə üçün istifadə olunur? Numune kodu yazın
        //of() metodu hər hansı zaman classından istifadə eddərkən ona zamanı özümüz ötürmək üçün istifadə olunur
        LocalDateTime localDateTime1 = LocalDateTime.of(2003,2,22,11,3,10,99);
        System.out.println(localDateTime1);

        //5.Bir tarixi ay gün il olarağ ayrı ayrılığda çap edin.
        LocalDate localDate2 =LocalDate.now();
        System.out.println("Years: " + localDate2.getYear() + " Month: " + localDate2.getMonth() + " Day: " + localDate2.getDayOfMonth());

        //6. İlin neçənci günündə olduğumuzu hansı methodla öyrənə bilərik nümunə göstərin.
        //bunu getDayOfYear() metodu ile oyrene bilerik
        LocalDate localDate3 = LocalDate.now();
        System.out.println(localDate3.getDayOfYear());

        //7. LocaleTime.now() çap edərkən, mikrosaniyələri necə silə bilərik? Nümunə göstərin.
        //bunu DateTimeFormatter classi ile ede bilerik
        LocalTime localTime1 = LocalTime.now();
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("'clock: 'hh':'mm':'ss");
        System.out.println(localTime1.format(dateTimeFormatter1));

        //8.Duration ve Periodun ferqi nedir numuneler gosterin
        //Period tarix arasındakı zaman fərqini hesablaya bilir yəni ancaq LoacalDate qəbul edir.
        //Duration isə saat arasındakı ferqi  hesablaya bilir yeni  class qebul edir
        //----------------Period----------------------------
        LocalDate localDate4 =LocalDate.of(2023,2,2);
        LocalDate localDate5 = LocalDate.now();
        Period period = Period.between(localDate4,localDate5);
        System.out.println(period);
        //-----------------------Duration----------------------------
        LocalTime localTime2 = LocalTime.of(20,50);
        LocalTime localTime3 =LocalTime.now();
        Duration duration = Duration.between(localTime2,localTime3);
        System.out.println(duration);

        //9.Instant , Clock , Zone ferqler nelerdir numuler gosterin (her birisine aid kod numunesi yazaraq )
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock); // clock sadəcə zamanı qaytarır və bunun default zone - a görə ya da System UTC - ə görə
        Instant instant = Instant.now();
        System.out.println(instant); // UTC saatını qaytarır
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);// default zone time ni qaytarir və həmin zonun UTC saatından olan fərqini göstərir





    }
}