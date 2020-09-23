package net.mikeski.problem.config;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.h2.jdbc.JdbcClob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @Copyright Mike Baranski ()mike.baranski ... gmail.com)
 * <p>
 * Class H2ClobTypeHandler created by mike 9/23/20 7:21 AM
 */
@MappedJdbcTypes({JdbcType.VARCHAR, JdbcType.CLOB, JdbcType.CHAR, JdbcType.NVARCHAR})
@MappedTypes(String.class)
public class H2ClobTypeHandler implements TypeHandler<String> {

    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) {
        throw new RuntimeException("Not yet implemented");
    }

    private String getFromCol(Object col) {
        if (col == null) {
            return "";
        }
        if (col instanceof JdbcClob) {
            String returnValue = null;
            try {
                returnValue = StreamUtils.copyToString(((JdbcClob) col).getAsciiStream(), UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return returnValue;
        } else {
            return col.toString();
        }
    }

    public String getResult(ResultSet rs, String columnName) {
        try {
            return getFromCol(rs.getObject(columnName));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public String getResult(ResultSet rs, int columnIndex) {
        try {
            return getFromCol(rs.getObject(columnIndex));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public String getResult(CallableStatement rs, int columnIndex) {
        try {
            return getFromCol(rs.getObject(columnIndex));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
