package chapter6.ex06.annotationDaoConfig;

import chapter6.ex01.plainJdbc.Contact;
import chapter6.ex06.annotationDaoConfig.requests.SelectAllContacts;
import chapter6.ex06.annotationDaoConfig.requests.SelectContactByFirstName;
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

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllContacts = new SelectAllContacts(dataSource);
        this.selectContactByFirstName = new SelectContactByFirstName(dataSource);
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

        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("first_name",firstName);
        return selectContactByFirstName.executeByNamedParam(paramMap);
    }

    @Override
    public String findFirstNameById(Long id) {
        return null;
    }

    @Override
    public List<Contact> findAllWithDetail() {
        return null;
    }

    @Override
    public void insert(Contact contact) {

    }

    @Override
    public void insertWithDetail(Contact contact) {

    }

    @Override
    public void update(Contact contact) {

    }
}
