import java.time.LocalDate;

public class MainUser {
    public static void main(String[] args) {
        LocalDate birthday  =LocalDate.of(2010,7,14);
        User user = new User("srthealik", "1234", birthday);
        LoginUser loginUser = new LoginUser();
        loginUser.loginMethode(user);

    }
}
