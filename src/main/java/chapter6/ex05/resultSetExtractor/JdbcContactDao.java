package chapter6.ex05.resultSetExtractor;

import chapter6.ex01.plainJdbc.Contact;
import chapter6.ex02.dataSourceJdbc.ContactDao;
import chapter6.ex04.rowMapper.ContactMapper;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Oleksandra_Sliusar on 12-Oct-17.
 */
public class JdbcContactDao implements ContactDao, InitializingBean {
    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public String findLastNameById(Long id) {
        String sql = "select last_name from Contact where id =:contactId";
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("contactId", id);

        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);
    }

    @Override
    public List<Contact> findAll() {
        String sql = "select id,first_name,last_name,birthday from Contact";
        return  namedParameterJdbcTemplate.query(sql, new ContactMapper());
    }

    @Override
    public List<Contact> findAllWithDetail() {

        String sql = "select c.id, c.first_name, c.last_name, c.birthday, " +
                "t.id as contact_tel_id, t.tel_type, t.tel_number from " +
                "Contact c " +
                "left join Contact_tel_detail t " +
                "on c.id = t.contact_id";

        return namedParameterJdbcTemplate.query(sql, new ContactWithDetailExtractor());

    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        NamedParameterJdbcTemplate namedParameterJdbcTemplate
                = new NamedParameterJdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null) {
            throw new BeanCreationException("must set dataSource");
        }
        if (namedParameterJdbcTemplate == null) {
            throw new BeanCreationException("null namedParameterJdbcTemplate");
        }
    }
}
