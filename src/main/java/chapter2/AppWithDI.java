package chapter2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppWithDI {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("chapter2/chapter2_context.xml");
        MessageRenderer mr = applicationContext.getBean("renderer", MessageRenderer.class);
        mr.render();
    }
}
