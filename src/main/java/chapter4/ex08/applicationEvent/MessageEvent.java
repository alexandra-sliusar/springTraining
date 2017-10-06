package chapter4.ex08.applicationEvent;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Oleksandra_Sliusar on 04-Oct-17.
 */
//просто объект
public class MessageEvent extends ApplicationEvent {
    private String msg;

    public MessageEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }
}
