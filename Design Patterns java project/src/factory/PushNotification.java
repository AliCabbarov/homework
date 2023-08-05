package factory;

public class PushNotification implements Notification{
    @Override
    public void sendNotification(String message) {
        System.out.println("send Push: " + message);
    }
}
