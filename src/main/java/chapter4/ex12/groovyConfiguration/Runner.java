package chapter4.ex12.groovyConfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

/**
 * Created by Oleksandra_Sliusar on 05-Oct-17.
 */
public class Runner {
    public static void main(String[] args) {
        ApplicationContext context = new GenericGroovyApplicationContext
                ("chapter4/ex12_groovyConfiguration/beans.groovy");
        Contact contact = (Contact) context.getBean("contact");
        System.out.println(contact);
    }
}
