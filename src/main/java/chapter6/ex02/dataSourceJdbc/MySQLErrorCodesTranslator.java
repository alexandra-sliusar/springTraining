package chapter6.ex02.dataSourceJdbc;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

import java.sql.SQLException;

/**
 * Created by Oleksandra_Sliusar on 10-Oct-17.
 *
 * Поскольку в Spring рекомендуется использовать исключения времени выполнения,
 * а не проверяемые исключения, необходим механизм трансляции проверяемого
 *  исключения SQLException в исключение времени выполнения Spring JDBC.
 *
 * Так как исключения, связанные с SQL в Spring, представляют собой исключения
 * времени выполнения, они могуг быть намного более детализированными, чем проверяемые
 * исключения.
 */
public class MySQLErrorCodesTranslator extends SQLErrorCodeSQLExceptionTranslator {

    @Override
    protected DataAccessException customTranslate(String task, String sql, SQLException sqlex){
        if (sqlex.getErrorCode() == -12345){
            return new DeadlockLoserDataAccessException(task,sqlex);
        }
        return null;
    }

}
