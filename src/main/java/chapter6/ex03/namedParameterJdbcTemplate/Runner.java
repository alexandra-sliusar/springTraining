package chapter6.ex03.namedParameterJdbcTemplate;

import chapter6.ex02.dataSourceJdbc.ContactDao;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Oleksandra_Sliusar on 12-Oct-17.
 */
public class Runner {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter6/named-parameter-context.xml");
        context.refresh();

        ContactDao contactDao = context.getBean("contactDao", ContactDao.class);
        System.out.println("Last name for contact id 1 is: " + contactDao.findLastNameById(1L));
    }
}
