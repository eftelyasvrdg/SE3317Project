package model;

public class BasicMessage extends Message{
    private String day;
    private String date;

    public BasicMessage(String day, String date) {
        this.day = day;
        this.date = date;
    }

    @Override
    public String getMessage() {
        return "Day : " + day + ", Date : " + date;
    }
}
