package chapter4.ex02.usingDestroy;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Oleksandra_Sliusar on 28-Sep-17.
 */
public class Runner {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter4/ex02/usingDestroy/using-destroy-method.xml");
        context.refresh();

        System.out.println("Call destroy method");
        context.destroy();
        System.out.println("Done.");
    }
}
