package chapter3;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by Oleksandra_Sliusar on 21-Sep-17.
 */
public class XmlConfigWithBeanFactory {
    public static void main(String[] args) {
        //an example of internal structure
        //in plain situation better to use applicationContext
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader rdr = new XmlBeanDefinitionReader(factory);
        rdr.loadBeanDefinitions(new ClassPathResource("chapter3/bean-factory-config.xml"));

        Oracle oracle = (Oracle) factory.getBean("oracle");
        System.out.println(oracle.defineMeaningOfLife());
    }
}
