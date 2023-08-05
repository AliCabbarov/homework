import java.time.*;

public class PeriodAndDuration {
    public static void main(String[] args) {

        //Period > sadece tarix ucundur
        LocalDate localDate = LocalDate.of(2020,10,10);
        LocalDate now = LocalDate.now();
        Period period = Period.between(localDate,now); // aradaki ferqi hesablayir
        System.out.println(period);
        System.out.println(period.getYears() + " years " + period.getMonths() + " months " + period.getDays() + " Days");


        //Duration > umumi heablaya bilir

        LocalTime localTime = LocalTime.of(20,30);
        LocalTime now1 = LocalTime.now();
        Duration duration =Duration.between(localTime,now1);
        System.out.println(duration);


    }
}
