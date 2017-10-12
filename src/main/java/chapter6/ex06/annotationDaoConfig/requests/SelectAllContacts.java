package chapter6.ex06.annotationDaoConfig.requests;

import chapter6.ex01.plainJdbc.Contact;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Oleksandra_Sliusar on 12-Oct-17.
 */
public class SelectAllContacts extends MappingSqlQuery<Contact> {
    private static String SQL_SELECT_ALL_CONTACT =
            "select id, first_name, last_name, birthday from Contact";

    public SelectAllContacts(DataSource dataSource){
        super(dataSource,SQL_SELECT_ALL_CONTACT);
    }

    @Override
    protected Contact mapRow(ResultSet resultSet, int i) throws SQLException {
        Contact contact = new Contact();
        contact.setId(resultSet.getLong("id"));
        contact.setFirstName(resultSet.getString("first_name"));
        contact.setLastName(resultSet.getString("last_name"));
        contact.setBirthday(resultSet.getDate("birthday"));
        return contact;
    }
}
