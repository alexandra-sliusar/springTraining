package chapter6.ex02.dataSourceJdbc;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by Oleksandra_Sliusar on 10-Oct-17.
 */
public class JdbcContactDao implements ContactDao, InitializingBean {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        MySQLErrorCodesTranslator errorCodesTranslator = new MySQLErrorCodesTranslator();
        errorCodesTranslator.setDataSource(dataSource);
        jdbcTemplate.setExceptionTranslator(errorCodesTranslator);
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String findLastNameById(Long id) {
        return jdbcTemplate.queryForObject("select first_name from Contact where id = ?",
                new Object[]{id}, String.class);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null) {
            throw new BeanCreationException("Must set dataSource on ContactDao");
        }
        if (jdbcTemplate == null) {
            throw new BeanCreationException("Null JdbcTemplate on ContactDao");
        }
    }
}
