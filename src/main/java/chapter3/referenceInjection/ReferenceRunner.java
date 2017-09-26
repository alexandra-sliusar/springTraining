package chapter3.referenceInjection;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Oleksandra_Sliusar on 25-Sep-17.
 */
public class ReferenceRunner {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter3/referenceInjection/reference-injection-context.xml");
        context.refresh();

        Keeper keeper = (Keeper) context.getBean("keeper");
        System.out.println(keeper);

    }
}
