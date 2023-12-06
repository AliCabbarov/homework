import helper.RoomFillWithThread;
import service.impl.ManagementServiceImpl;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Thread registerRoom = new Thread(new RoomFillWithThread());
        registerRoom.start();
        new ManagementServiceImpl().manage();

//        System.out.println("Hello world!");
//        LocalDateTime localDateTime = LocalDateTime.of(2024,12,3,20,55);
//        Duration duration = Duration.between(LocalDateTime.now(),localDateTime);
//        System.out.println(duration);
//        System.out.println(duration.isNegative());
    }
}