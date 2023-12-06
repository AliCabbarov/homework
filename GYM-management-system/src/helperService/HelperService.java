package helperService;

import data.GlobalData;
import enums.Exception;
import exception.ApplicationException;
import model.User;
import util.InputUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static util.InputUtil.getInstance;

public class HelperService {
    private static long id;
    private static int countIndex = 0;

    //        public static void oneMinusCountIndex() {
//        countIndex--;
//    }
    public static boolean appropriationCustomer() {
        User user = fillUser();
        if (user != null) {
            GlobalData.users[countIndex] = user;
            countIndex++;
            return true;
        }
        return false;
    }

    private static User fillUser() {
        try {
            String name = InputUtil.getInstance().inputString("Enter the name: ");
            String surname = InputUtil.getInstance().inputString("Enter the surname: ");
            String fin = InputUtil.getInstance().inputString("Enter the fin: ");
            String serialNumber = InputUtil.getInstance().inputString("Enter the serial number (passport): ");
            LocalDate expirationDate = dateFormat("Enter the membership expiration date :");
            int departures = InputUtil.getInstance().inputInt("Enter the number of departures: ");
            double amount = getInstance().inputDouble("Enter the amount: ");
            return new User(++id, name, surname, fin, serialNumber, departures, expirationDate, amount, LocalDateTime.now(), null);
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public static LocalDate expirationDateCount(LocalDate localDate, int day) {
        return localDate.plusDays(day);
    }


    public static void deleteNullCustomer() {
        int nullCount = 0;
        for (int i = 0; i < GlobalData.users.length; i++) {
            if (GlobalData.users[i] == null) {
                nullCount++;
            }

        }
        User[] tempUser = GlobalData.users;
        GlobalData.users = new User[GlobalData.users.length - nullCount];
        for (int i = 0; i < GlobalData.users.length; i++) {
            GlobalData.users[i] = tempUser[i];
        }
        zeroCountIndex();
    }

    public static void zeroCountIndex() {
        if (GlobalData.users.length == 0) {
            GlobalData.users = null;
            countIndex = 0;
        }
    }

    public static void nullGlobalDataException() {
        if (GlobalData.users == null) {
            throw new ApplicationException(Exception.NOT_FOUND_EXCEPTION);
        }
    }

    public static LocalDate dateFormat(String message) {
        try {
            String date = getInstance().inputString(message + " (dd/MM/yyyy)");
            String[] dateSplit = date.split("/");
            int day = Integer.parseInt(dateSplit[0]);
            int month = Integer.parseInt(dateSplit[1]);
            int year = Integer.parseInt(dateSplit[2]);
            return LocalDate.of(year, month, day);
        } catch (RuntimeException exception) {
            System.err.println(Exception.WRONG_FORMAT_EXCEPTION.getMessage());
            return null;
        }
    }
}
