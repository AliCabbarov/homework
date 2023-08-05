import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class LoginUser {
    public  void loginMethode(User user) {
        int age = calculateAge(user);
        if (age > 18) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("enter the username: ");
            String inputUsername = scanner.nextLine();
            System.out.print("enter the password: ");
            String inputPassword = scanner.nextLine();

            if (inputUsername.equals(user.getUsername()) && inputPassword.equals(user.getPassword())) {
                if (user.getBirthday().getMonth().equals(LocalDate.now().getMonth()) && user.getBirthday().getDayOfMonth() == LocalDate.now().getDayOfMonth()) {
                    System.out.println("Welcome " + user.getUsername());
                    System.out.println("happy birthday " + user.getUsername());
                }else
                System.out.println("Welcome " + user.getUsername());
            }else {
                System.out.println("Wrong Username or password ");
            }
        }
        else System.out.println("siz login ola bilmezsiniz!!!");
    }

    public  int calculateAge(User user) {
        LocalDate localDate = LocalDate.now();
        Period period = Period.between(user.getBirthday(), localDate);
        return period.getYears();
    }

}
