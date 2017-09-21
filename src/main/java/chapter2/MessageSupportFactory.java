package chapter2;

import java.io.FileInputStream;
import java.util.Properties;

public class MessageSupportFactory {
    private static MessageSupportFactory instance;

    private Properties properties;
    private MessageProvider provider;
    private MessageRenderer renderer;

    private MessageSupportFactory() {
        properties = new Properties();


        try {
            properties.load(new FileInputStream("src/main/resources/chapter2_classtype.properties"));
            String rendererClass = properties.getProperty("renderer.class");
            String providerClass = properties.getProperty("provider.class");
            renderer = (MessageRenderer)
                    Class.forName(rendererClass).newInstance();
            provider = (MessageProvider)
                    Class.forName(providerClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    public MessageRenderer getRenderer() {
        return renderer;
    }

    public MessageProvider getProvider() {
        return provider;
    }
}
