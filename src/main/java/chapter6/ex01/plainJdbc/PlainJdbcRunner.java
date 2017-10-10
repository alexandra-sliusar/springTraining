package chapter6.ex01.plainJdbc;

import chapter6.ex01.plainJdbc.jdbc.ContactDao;
import chapter6.ex01.plainJdbc.jdbc.PlainContactDao;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Oleksandra_Sliusar on 09-Oct-17.
 */
public class PlainJdbcRunner {
    private static ContactDao contactDao = new PlainContactDao();

    public static void main(String[] args) {
        System.out.println("Listing initial contact data:");
        listAllContacts();
        System.out.println();

        System.out.println("Insert a new contact:");
        Contact contact = new Contact();
        contact.setFirstName("Jacky");
        contact.setLastName("Jacko");
        contact.setBirthday(new Date(new GregorianCalendar(2010, 10, 10).getTime().getTime()));
        contactDao.insert(contact);

        System.out.println("Listing contacts after adding contact");
        listAllContacts();
        System.out.println();

        System.out.println("Deleting created contact:");
        contactDao.delete(contact.getId());

        System.out.println("Listing contacts after deletion:");
        listAllContacts();
    }

    private static void listAllContacts() {
        List<Contact> contacts = contactDao.findAll();
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

}
