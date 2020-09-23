package net.mikeski.problem.config;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.h2.jdbc.JdbcClob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
 * Class IBATISConfig created by mike 9/22/20 9:22 PM
 */
@Configuration
public class IBATISConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(IBATISConfig.class);

    @Bean
    public TypeHandler<String> jdbcClobTypeHander() {
        return new H2ClobTypeHandler();
    }
}

