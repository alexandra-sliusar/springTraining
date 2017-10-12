package chapter6.ex04.rowMapper;

import chapter6.ex01.plainJdbc.Contact;
import chapter6.ex01.plainJdbc.ContactTelDetail;
import chapter6.ex02.dataSourceJdbc.ContactDao;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * Created by Oleksandra_Sliusar on 12-Oct-17.
 */
public class Runner {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter6/row-mapper-context.xml");
        context.refresh();

        ContactDao contactDao  = context.getBean("contactDao", ContactDao.class);
        List<Contact> contacts = contactDao.findAll();
        for (Contact contact: contacts){
            System.out.println(contact);
            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetail contactTelDetail: contact.getContactTelDetails()){
                    System.out.println("---" + contactTelDetail);
                }
            }
            System.out.println();
        }
    }
}
