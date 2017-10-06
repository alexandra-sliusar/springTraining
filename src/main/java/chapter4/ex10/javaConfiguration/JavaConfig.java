package chapter4.ex10.javaConfiguration;

import chapter3.message.MessageProvider;
import chapter3.message.StandardOutMessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

/**
 * Created by Oleksandra_Sliusar on 05-Oct-17.
 */
@PropertySource(value = "classpath:chapter4/ex10_javaConfiguration/message.properties")
@Configuration
public class JavaConfig {

    @Autowired
    Environment env;

    @Bean
    @Lazy
    public MessageProvider messageProvider() {
        return new ConfigurableMessageProvider(env.getProperty("message"));
    }

    @Bean
    @Scope("prototype")
    @DependsOn("messageProvider")
    public chapter3.message.MessageRenderer messageRenderer() {
        chapter3.message.MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(messageProvider());
        return renderer;
    }
}
