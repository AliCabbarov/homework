package factory;

public class SmsNotification implements Notification{
    @Override
    public void sendNotification(String message) {
        System.out.println("send SMS: " + message);

    }
}
