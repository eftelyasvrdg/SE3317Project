package model;

import java.time.LocalDate;

public class BirthdayMessageDecorator extends MessageDecorator {
    private String userBirthday;

    public BirthdayMessageDecorator(Message message, String userBirthday) {
        super(message);
        this.userBirthday = userBirthday;
    }

    @Override
    public String getMessage() {
        String baseMessage = super.getMessage();
        String today = LocalDate.now().toString();
        if (today.equals(userBirthday)) {
            return baseMessage + "\nHappy Birthday!";
        }
        return baseMessage;
    }
}
