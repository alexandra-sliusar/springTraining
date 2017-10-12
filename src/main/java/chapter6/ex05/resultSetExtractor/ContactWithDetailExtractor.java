package chapter6.ex05.resultSetExtractor;

import chapter6.ex01.plainJdbc.Contact;
import chapter6.ex01.plainJdbc.ContactTelDetail;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Oleksandra_Sliusar on 12-Oct-17.
 */
public class ContactWithDetailExtractor implements ResultSetExtractor<List<Contact>> {
    @Override
    public List<Contact> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Map<Long, Contact> map = new HashMap<>();
        Contact contact;
        while (resultSet.next()) {
            Long id = resultSet.getLong("id");
            contact = map.get(id);

            if (contact == null) {
                contact = new Contact();
                contact.setId(id);
                contact.setFirstName(resultSet.getString("first_name"));
                contact.setLastName(resultSet.getString("last_name"));
                contact.setBirthday(resultSet.getDate("birthday"));
                contact.setContactTelDetails(new ArrayList<ContactTelDetail>());
                map.put(id, contact);
            }
            Long contactTelDetailId = resultSet.getLong("contact_tel_id");
            if (contactTelDetailId > 0) {
                ContactTelDetail contactTelDetail = new ContactTelDetail();
                contactTelDetail.setId(contactTelDetailId);
                contactTelDetail.setContactId(id);
                contactTelDetail.setTelType(resultSet.getString("tel_type"));
                contactTelDetail.setTelNumber(resultSet.getString("tel_number"));
                contact.getContactTelDetails().add(contactTelDetail);
            }
        }
        return new ArrayList<>(map.values());
    }

}
