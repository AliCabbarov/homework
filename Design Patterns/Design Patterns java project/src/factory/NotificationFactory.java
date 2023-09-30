package factory;

public class NotificationFactory {
    public Notification createNotification(NotificationType type){
        switch (type){
            case SMS: return new SmsNotification();
            case PUSH: return new PushNotification();
            case EMAIL: return new EmailNotification();
            default: throw new IllegalNotificationTypeException("Invalid exception type!");
        }

    }
}
