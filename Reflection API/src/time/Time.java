package time;

import java.time.LocalDateTime;

public class Time {
    private final int hour;
    private final int minute;
    private final int second;
    private final int nanoSecond;

    public Time() {
        this.hour = LocalDateTime.now().getHour();
        this.minute = LocalDateTime.now().getMinute();
        this.second = LocalDateTime.now().getSecond();
        this.nanoSecond = LocalDateTime.now().getNano();
    }
    @TimeManager("hour: ")

    public int getHour() {
        return hour;
    }
    @TimeManager

    public int getMinute() {
        return minute;
    }
    @TimeManager("second: ")

    public int getSecond() {
        return second;
    }
    @TimeManager("nano Second: ")

    public int getNanoSecond() {
        return nanoSecond;
    }
}
