package chapter2;

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

    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
