package chapter6.ex04.rowMapper;

import chapter6.ex01.plainJdbc.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by Oleksandra_Sliusar on 12-Oct-17.
 */
public final class ContactMapper implements RowMapper<Contact> {

    @Override
    public Contact mapRow(ResultSet resultSet, int i) throws SQLException {
        Contact contact = new Contact();
        contact.setId(resultSet.getLong("id"));
        contact.setFirstName(resultSet.getString("first_name"));
        contact.setLastName(resultSet.getString("last_name"));
        contact.setBirthday(resultSet.getDate("birthday"));

        return contact;
    }
}
