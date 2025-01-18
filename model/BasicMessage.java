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
        if (day != " " && date != " "){
            return "Day : " + day + ", Date : " + date;
        }
       else return null;
    }
}
