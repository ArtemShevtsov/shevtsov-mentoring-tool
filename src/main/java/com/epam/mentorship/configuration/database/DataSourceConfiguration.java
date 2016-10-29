package com.epam.mentorship.configuration.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by aftor on 10.09.16.
 */
@Configuration
public class DataSourceConfiguration {

    @Bean
    public DataSource embeddedH2DataSource(){
        EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = dbBuilder.setType(EmbeddedDatabaseType.H2)
                .setName("mentorship-db")
                .addScript("classpath:create-db.sql")
                .build();
        return db;
    }

    @Bean
    public JdbcTemplate jdbcEmbeddedH2Template() {
        return new JdbcTemplate(embeddedH2DataSource(), true);
    }
}
