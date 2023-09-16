import java.util.Scanner;
import java.util.concurrent.Callable;

public class CallableExample implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the age: ");
        int a = scanner.nextInt();
        if(a<0){
            return false;
        } else if (a<18) {
            return false;
        }else if (a>100){
            return false;
        }else {
            return true;
        }
    }
}
