package chapter6.ex06.annotationDaoConfig;

import chapter6.ex01.plainJdbc.Contact;

import java.util.List;

/**
 * Created by Oleksandra_Sliusar on 12-Oct-17.
 */
public interface ContactDao {
    List<Contact> findAll();
    List<Contact> findByFirstName(String firstName);
    String findFirstNameById(Long id);
    List<Contact> findAllWithDetail();
    void insert(Contact contact);
    void  insertWithDetail(Contact contact);
    void update(Contact contact);
}
