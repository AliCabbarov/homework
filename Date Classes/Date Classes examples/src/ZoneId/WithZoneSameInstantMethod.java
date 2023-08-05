package ZoneId;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class WithZoneSameInstantMethod {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/Barbados"));
        System.out.println(zonedDateTime);
        ZonedDateTime zonedDateTime1 = zonedDateTime.withZoneSameInstant(ZoneId.of("Asia/Baku")); // daxil edilən regiona görə digər regiondakı saatı hesablayır
        System.out.println(zonedDateTime1);
    }
}
