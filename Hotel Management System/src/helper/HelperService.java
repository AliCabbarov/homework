package helper;

import data.GlobalData;
import model.Customer;
import model.Room;
import util.InputUtil;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HelperService {
    private static HelperService instance;
    private HelperService(){}

    public static HelperService getInstance() {
        return instance == null ? instance = new HelperService() : instance;
    }
    public  DateTimeFormatter timeFormatter(LocalDateTime time){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy ' ' hh/mm/ss");
        dateTimeFormatter.format(time);
        return dateTimeFormatter;
    }
    public  LocalDateTime now(){
        return LocalDateTime.now();
    }
    public  double doubleFormatter(double value){
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return Double.parseDouble(String.valueOf(decimalFormat));
    }
    public boolean isNegative(LocalDateTime before,LocalDateTime after){
        Duration duration = Duration.between(before,after);
        return duration.isNegative();
    }
    public Duration duration(LocalDateTime date){
        return Duration.between(LocalDateTime.now(),date);
    }
    public LocalDateTime enterDate(String message){
        try {
            String stringBirthday = InputUtil.getInstance().inputString(message +  " (dd/MM/YYYY/hh): ");
            String[] split = stringBirthday.split("/");
            int day = (byte) Integer.parseInt(split[0]);
            int month = (byte) Integer.parseInt(split[1]);
            int years = Integer.parseInt(split[2]);
            int hours = Integer.parseInt(split[3]);
            return LocalDateTime.of(years,month,day,hours,0);
        }catch (RuntimeException exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }
    public LocalDate birthday(String message){
        try {
            String stringBirthday = InputUtil.getInstance().inputString(message +  " (dd/MM/YYYY): ");
            String[] split = stringBirthday.split("/");
            int day = (byte) Integer.parseInt(split[0]);
            int month = (byte) Integer.parseInt(split[1]);
            int years = Integer.parseInt(split[2]);
            return LocalDate.of(years,month,day);
        }catch (RuntimeException exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public Room searchRoom(Customer customer) {
        for (Room room: GlobalData.rooms) {
            if(room.getRoomNumber() == customer.getRoomNumber()){
                return room;
            }
        }
        return null;
    }
}
