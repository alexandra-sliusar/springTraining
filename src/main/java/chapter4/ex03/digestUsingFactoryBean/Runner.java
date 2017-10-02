package chapter4.ex03.digestUsingFactoryBean;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Oleksandra_Sliusar on 28-Sep-17.
 */
public class Runner {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter4/ex03.digestUsingFactoryBean/factory-bean.xml");
        context.refresh();

        MessageDigester digester = (MessageDigester) context.getBean("digester");
        digester.digest("Hellgsegsegsgsegqq2r12435!!yh !");
    }
}
