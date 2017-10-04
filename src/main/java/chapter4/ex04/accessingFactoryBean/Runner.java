package chapter4.ex04.accessingFactoryBean;

import chapter4.ex03.digestUsingFactoryBean.MessageDigestFactoryBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.security.MessageDigest;

/**
 * Created by Oleksandra_Sliusar on 03-Oct-17.
 *
 * get factory bean by using &beanName operator
 */
public class Runner {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("chapter4/ex03.digestUsingFactoryBean/factory-bean.xml");
        ctx.refresh();
        MessageDigest digest = (MessageDigest) ctx.getBean("shaDigest");
        MessageDigestFactoryBean factoryBean =
                (MessageDigestFactoryBean) ctx.getBean("&shaDigest");
        try {
            MessageDigest shaDigest = factoryBean.getObject();
            System.out.println(shaDigest.digest("Hello world".getBytes()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
