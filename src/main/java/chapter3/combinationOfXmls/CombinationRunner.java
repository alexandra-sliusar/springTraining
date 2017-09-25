package chapter3.combinationOfXmls;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Oleksandra_Sliusar on 25-Sep-17.
 */
public class CombinationRunner {
    public static void main(String[] args) {
        GenericXmlApplicationContext parentContext = new GenericXmlApplicationContext();
        parentContext.load("chapter3/combination-parent-context.xml");
        parentContext.refresh();

        GenericXmlApplicationContext childContext = new GenericXmlApplicationContext();
        childContext.load("chapter3/combination-child-context.xml");
        childContext.setParent(parentContext);
        childContext.refresh();

        SimpleClass simpleClass1 = (SimpleClass) childContext.getBean("simple1");
        SimpleClass simpleClass2 = (SimpleClass) childContext.getBean("simple2");
        SimpleClass simpleClass3 = (SimpleClass) childContext.getBean("simple3");

        System.out.println(simpleClass1.getValue());
        System.out.println(simpleClass2.getValue());
        System.out.println(simpleClass3.getValue());
    }
}
