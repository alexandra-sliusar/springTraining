package chapter3.beanNaming;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Oleksandra_Sliusar on 25-Sep-17.
 */
public class NamingRunner {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter3/beanNaming/bean-naming-context.xml");
        context.refresh();

        String s1 = (String) context.getBean("name1");
        String s2 = (String) context.getBean("name2");
        String s3 = (String) context.getBean("name3");
        String s4 = (String) context.getBean("name4");
        String s5 = (String) context.getBean("name5");
        String s6 = (String) context.getBean("name6");

        System.out.println(s1==s2);
        System.out.println(s2==s3);
        System.out.println(s3==s4);
        System.out.println(s4==s5);
        System.out.println(s5==s6);

    }
}
