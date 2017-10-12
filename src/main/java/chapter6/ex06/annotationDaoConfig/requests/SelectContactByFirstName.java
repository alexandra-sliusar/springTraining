package chapter6.ex06.annotationDaoConfig.requests;

import chapter6.ex01.plainJdbc.Contact;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Created by Oleksandra_Sliusar on 12-Oct-17.
 */
public class SelectContactByFirstName extends MappingSqlQuery<Contact> {
    //':' exact before parameter
    private static String SQL_FIND_BY_FIRST_NAME =
            "select id, first_name, last_name, birthday from Contact " +
                    "where first_name = :first_name";

    public SelectContactByFirstName(DataSource dataSource) {
        super(dataSource, SQL_FIND_BY_FIRST_NAME);
        super.declareParameter(new SqlParameter("first_name", Types.VARCHAR));
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
