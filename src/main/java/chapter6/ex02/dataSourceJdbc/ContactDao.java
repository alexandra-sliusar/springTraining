package chapter6.ex02.dataSourceJdbc;

import chapter6.ex01.plainJdbc.Contact;

import java.util.List;

/**
 * Created by Oleksandra_Sliusar on 10-Oct-17.
 */
public interface ContactDao {
    String findLastNameById(Long id);
    List<Contact> findAll();
    List<Contact> findAllWithDetail();
}
