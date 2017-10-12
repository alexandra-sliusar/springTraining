package chapter6.ex06.annotationDaoConfig;

import chapter6.ex01.plainJdbc.Contact;
import chapter6.ex01.plainJdbc.ContactTelDetail;
import chapter6.ex05.resultSetExtractor.ContactWithDetailExtractor;
import chapter6.ex06.annotationDaoConfig.requests.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Oleksandra_Sliusar on 12-Oct-17.
 */
@Repository("contactDao")
public class JdbcContactDao implements ContactDao {
    private DataSource dataSource;

    private SelectAllContacts selectAllContacts;
    private SelectContactByFirstName selectContactByFirstName;
    private UpdateContact updateContact;
    private InsertContact insertContact;
    private InsertContactTelDetail insertContactTelDetail;
    private StoredFunctionFirstNameById storedFunctionFirstNameById;

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllContacts = new SelectAllContacts(dataSource);
        this.selectContactByFirstName = new SelectContactByFirstName(dataSource);
        this.updateContact = new UpdateContact(dataSource);
        this.insertContact = new InsertContact(dataSource);
        this.storedFunctionFirstNameById = new StoredFunctionFirstNameById(dataSource);
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public List<Contact> findAll() {
        return selectAllContacts.execute();
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("first_name", firstName);
        return selectContactByFirstName.executeByNamedParam(paramMap);
    }

    @Override
    public String findFirstNameById(Long id) {
        List<String> result = storedFunctionFirstNameById.execute(id);
        return result.get(0);
    }

    @Override
    public List<Contact> findAllWithDetail() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        String sql = "select c.id, c.first_name, c.last_name, c.birthday, " +
                "t.id as contact_tel_id, t.tel_type, t.tel_number from " +
                "Contact c " +
                "left join Contact_tel_detail t " +
                "on c.id = t.contact_id";
        return jdbcTemplate.query(sql, new ContactWithDetailExtractor());
    }

    @Override
    public void insert(Contact contact) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("first_name", contact.getFirstName());
        paramMap.put("last_name", contact.getLastName());
        paramMap.put("birthday", contact.getBirthday());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertContact.updateByNamedParam(paramMap, keyHolder);
        contact.setId(keyHolder.getKey().longValue());
    }

    @Override
    public void insertWithDetail(Contact contact) {
        this.insertContactTelDetail = new InsertContactTelDetail(dataSource);
        insert(contact);

        Map<String, Object> paramMap = new HashMap<>();
        List<ContactTelDetail> contactTelDetails = contact.getContactTelDetails();
        if (contactTelDetails != null) {
            for (ContactTelDetail contactTelDetail : contactTelDetails) {
                paramMap.put("contact_id", contact.getId());
                paramMap.put("tel_type", contactTelDetail.getTelType());
                paramMap.put("tel_number", contactTelDetail.getTelNumber());
                insertContactTelDetail.updateByNamedParam(paramMap);
            }
        }
        insertContactTelDetail.flush();

    }

    @Override
    public void update(Contact contact) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("first_name", contact.getFirstName());
        paramMap.put("last_name", contact.getLastName());
        paramMap.put("birthday", contact.getBirthday());
        paramMap.put("id", contact.getId());

        updateContact.updateByNamedParam(paramMap);
    }
}
