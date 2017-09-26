package chapter3.manualDependencyDefinition;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Oleksandra_Sliusar on 26-Sep-17.
 */
public class ManualDependencyRunner {
    public static GenericXmlApplicationContext context;

    public static void main(String[] args) {
        context = new GenericXmlApplicationContext();
        context.load("chapter3/manualDependencyDefinition/manual-dependency-context.xml");
        context.refresh();
        context.getBean("beanA");
    }
}

class ClassA {
    ClassA() {
        ClassB b = (ClassB) ManualDependencyRunner.context.getBean("beanB");
        System.out.println(b.value);
    }
}

class ClassB {
    public String value = "Bean B";
}
