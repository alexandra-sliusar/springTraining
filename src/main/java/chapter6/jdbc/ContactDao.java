package chapter6.jdbc;

import chapter6.Contact;

import java.util.List;

/**
 * Created by Oleksandra_Sliusar on 06-Oct-17.
 */
public interface ContactDao {

    List<Contact> findAll();
    List<Contact> findByFirstName(String firstName);
    String findLastNameById(Long id);
    String findFirstNameById(Long id);
    void insert(Contact contact);
    void update(Contact contact);
    void delete(Long contactId);
}
