package chapter4.ex10.javaConfiguration;

import chapter3.message.MessageProvider;

/**
 * Created by Oleksandra_Sliusar on 05-Oct-17.
 */
public class ConfigurableMessageProvider implements MessageProvider {
    private String message = "Default message";

    public ConfigurableMessageProvider() {
    }

    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
