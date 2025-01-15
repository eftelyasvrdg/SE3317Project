package model;

import java.util.List;

public class NotificationsDecorator extends MessageDecorator{
    private List<String> notifications;

    public NotificationsDecorator(Message message, List<String> notifications) {
        super(message);
        this.notifications = notifications;
    }

    @Override
    public String getMessage() {
        String baseMessage = super.getMessage();
        if (notifications != null && !notifications.isEmpty()) {
            StringBuilder notificationMessages = new StringBuilder();
            for (String notification : notifications) {
                notificationMessages.append("\n").append(notification);
            }
            return baseMessage + notificationMessages.toString();
        }
        return baseMessage;
    }
}
