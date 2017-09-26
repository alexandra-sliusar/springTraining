package chapter3.spelExample;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Oleksandra_Sliusar on 25-Sep-17.
 */
public class SpelRunner {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.load("chapter3/spelExample/spel-example-context.xml");
        ctx.refresh();

        InjectSimpleSpel simple =
                (InjectSimpleSpel)ctx.getBean("injectSimpleSpel");
        System.out.println(simple);
    }
}
