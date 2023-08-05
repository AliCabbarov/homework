package ZoneId;

import java.time.ZoneId;

public class getAvailableZoneIds {
    public static void main(String[] args) {

        for (String zoneName : ZoneId.getAvailableZoneIds()) {
            System.out.println(zoneName);

        }
    }
}
