package chapter3.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("messageRenderer")
public class StandardOutMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider;

    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException
                    ("You must set the property messageProvider "
                            + StandardOutMessageRenderer.class.getSimpleName());
        }
        System.out.println(messageProvider.getMessage());
    }

    @Autowired
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
