package model;

public abstract class MessageDecorator  extends Message {
    protected Message message;

    public MessageDecorator(Message message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message.getMessage();
    }

}
