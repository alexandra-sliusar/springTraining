package chapter4.ex01.usingInit;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Oleksandra_Sliusar on 28-Sep-17.
 */
public class Runner {
    public static void main(String[] args) {
       /* System.out.println("Simple bean with init method");
        runSimpleBean();*/

       /* System.out.println("Simple bean with init interface");
        runSimpleBeanWithInterface();*/

        System.out.println("Simple bean with init annotation");
        runSimpleBeanWithAnnotation();

    }

    private static void runSimpleBean() {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter4/ex01/usingInit/using-init-method.xml");
        context.refresh();

        try {
            SimpleBean bean = (SimpleBean) context.getBean("simpleBeanl");
            System.out.println(bean);
            bean = (SimpleBean) context.getBean("simpleBean2");
            System.out.println(bean);
            bean = (SimpleBean) context.getBean("simpleBean3");
            System.out.println(bean);
        } catch (BeanCreationException ex) {
            System.out.println("An error occured in bean configuration: "
                    + ex.getMessage());
        }

    }

    private static void runSimpleBeanWithInterface() {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter4/ex01/usingInit/using-init-interface.xml");
        context.refresh();

        try {
            SimpleBeanWithInterface bean = (SimpleBeanWithInterface) context.getBean("simpleBeanl");
            System.out.println(bean);
            bean = (SimpleBeanWithInterface) context.getBean("simpleBean2");
            System.out.println(bean);
            bean = (SimpleBeanWithInterface) context.getBean("simpleBean3");
            System.out.println(bean);
        } catch (BeanCreationException ex) {
            System.out.println("An error occured in bean configuration: "
                    + ex.getMessage());
        }
    }

    private static void runSimpleBeanWithAnnotation() {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter4/ex01/usingInit/using-init-annotation.xml");
        context.refresh();

        try {
            SimpleBeanWithAnnotation bean = (SimpleBeanWithAnnotation) context.getBean("simpleBeanl");
            System.out.println(bean);
            bean = (SimpleBeanWithAnnotation) context.getBean("simpleBean2");
            System.out.println(bean);
            bean = (SimpleBeanWithAnnotation) context.getBean("simpleBean3");
            System.out.println(bean);
        } catch (BeanCreationException ex) {
            System.out.println("An error occured in bean configuration: "
                    + ex.getMessage());
        }
    }
}
