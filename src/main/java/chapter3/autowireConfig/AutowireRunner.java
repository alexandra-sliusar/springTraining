package chapter3.autowireConfig;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Oleksandra_Sliusar on 26-Sep-17.
 */
public class AutowireRunner {


    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter3/autowireConfig/autowire-context.xml");
        context.refresh();

        System.out.println("Using byName:\n");
        context.getBean("targetByName");

        System.out.println("\nUsing byType:\n");
        context.getBean("targetByType");

        System.out.println("\nUsing constructor:\n");
        context.getBean("targetConstructor");
    }
}
