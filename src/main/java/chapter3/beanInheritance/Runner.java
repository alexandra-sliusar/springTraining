package chapter3.beanInheritance;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Oleksandra_Sliusar on 26-Sep-17.
 */
public class Runner {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter3/beanInheritance/bean-inheritance-context.xml");
        context.refresh();

        SimpleBean parentBean = (SimpleBean) context.getBean("parentBean");
        System.out.println("Parent: " + parentBean);
        SimpleBean childBean = (SimpleBean) context.getBean("childBean");
        System.out.println("Child: " + childBean);
    }
}
