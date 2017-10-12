package chapter6.ex06.annotationDaoConfig.requests;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlFunction;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * Created by Oleksandra_Sliusar on 12-Oct-17.
 */
public class StoredFunctionFirstNameById extends SqlFunction<String> {
    private static String SQL = "select getFirstNameByld(?)";

    public StoredFunctionFirstNameById (DataSource dataSource){
        super(dataSource, SQL);
        declareParameter(new SqlParameter(Types.INTEGER));
        compile();
    }
}
