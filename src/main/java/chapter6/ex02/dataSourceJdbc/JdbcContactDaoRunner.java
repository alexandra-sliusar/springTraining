package chapter6.ex02.dataSourceJdbc;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Oleksandra_Sliusar on 10-Oct-17.
 */
public class JdbcContactDaoRunner {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter6/apache-jdbc-context.xml");
        context.refresh();

        ContactDao contactDao = context.getBean("contactDao", ContactDao.class);
        System.out.println("First name for contact id 1 is: " + contactDao.findLastNameById(1L));
    }
}
