package chapter4.ex08.applicationEvent;

import org.springframework.context.ApplicationListener;

/**
 * Created by Oleksandra_Sliusar on 04-Oct-17.
 */
//следит за MessageEvent, потому что есть в generics. неявно действует
public class MessageEventListener implements ApplicationListener<MessageEvent> {
    @Override
    public void onApplicationEvent(MessageEvent event) {
        MessageEvent msgEvt = event;
        System.out.println("Received: " + msgEvt.getMessage());
    }
}
