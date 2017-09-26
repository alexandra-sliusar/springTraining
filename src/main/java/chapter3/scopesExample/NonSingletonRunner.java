package chapter3.scopesExample;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Oleksandra_Sliusar on 25-Sep-17.
 */
public class NonSingletonRunner {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter3/scopesExample/scope-prototype-context.xml");
        context.refresh();

        String s1 = (String) context.getBean("nonSingle");
        String s2 = (String) context.getBean("nonSingle");

        System.out.println("Identity equal: " + (s1==s2));
        System.out.println("Value equal: " + s1.equals(s2));
        System.out.println(s1);
        System.out.println(s2);
    }
}
