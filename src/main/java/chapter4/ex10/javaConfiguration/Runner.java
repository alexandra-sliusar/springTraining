package chapter4.ex10.javaConfiguration;

import chapter3.message.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Oleksandra_Sliusar on 05-Oct-17.
 */
public class Runner {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        MessageRenderer renderer = (MessageRenderer) context.getBean("messageRenderer");
        renderer.render();
    }
}
