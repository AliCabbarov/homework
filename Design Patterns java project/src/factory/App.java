package factory;

public class App {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification emailNotify =  notificationFactory.createNotification(NotificationType.EMAIL);
        emailNotify.sendNotification("salam");
    }
}
