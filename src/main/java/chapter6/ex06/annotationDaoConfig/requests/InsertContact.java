package chapter6.ex06.annotationDaoConfig.requests;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * Created by Oleksandra_Sliusar on 12-Oct-17.
 */
public class InsertContact extends SqlUpdate {
    private static String SQL_INSERT_CONTACT =
            "insert into Contact (first_name, last_name, birthday) values " +
                    "(:first_name, :last_name, :birthday)";
    public InsertContact(DataSource dataSource){
        super(dataSource,SQL_INSERT_CONTACT);
        super.declareParameter(new SqlParameter("first_name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("last_name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("birthday", Types.DATE));
        super.setGeneratedKeysColumnNames(new String[]{"id"});
        super.setReturnGeneratedKeys(true);
    }
}
