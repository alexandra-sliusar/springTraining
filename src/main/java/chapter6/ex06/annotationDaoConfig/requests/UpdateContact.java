package chapter6.ex06.annotationDaoConfig.requests;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * Created by Oleksandra_Sliusar on 12-Oct-17.
 */
public class UpdateContact extends SqlUpdate {
    private static String SQL_UPDATE_CONTACT =
            "update Contact set " +
                    "first_name = :first_name, " +
                    "last_name = :last_name, " +
                    "birthday = :birthday " +
                    "where id= :id";
    public UpdateContact(DataSource dataSource){
        super(dataSource,SQL_UPDATE_CONTACT);
        super.declareParameter(new SqlParameter("first_name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("last_name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("birthday", Types.DATE));
        super.declareParameter(new SqlParameter("id", Types.INTEGER));
    }
}
