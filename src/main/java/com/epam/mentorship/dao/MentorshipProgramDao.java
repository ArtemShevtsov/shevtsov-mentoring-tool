package com.epam.mentorship.dao;

import com.epam.mentorship.entity.MentorshipProgram;
import com.epam.mentorship.entity.OfficeLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

/**
 * Created by aftor on 17.09.16.
 */
@Component
public class MentorshipProgramDao implements EntryDao<MentorshipProgram> {
    @Autowired
    private JdbcTemplate jdbcEmbeddedH2Template;

    private final String GET_ALL_PROGRAMS_QUERY = "select * from mentorshipPrograms;";
    private final String GET_PROGRAM_BY_ID_QUERY = "select * from mentorshipPrograms where id = ?;";
    private final String INSERT_PROGRAM_QUERY =
            "insert into mentorshipPrograms(name, location, startDate, endDate) values (?,?,?,?);";
    private final String UPDATE_PROGRAM_QUERY =
            "update mentorshipPrograms set name=?, location=?, startDate=?, endDate=? where id=?;";

    @Override
    public RowMapper<? extends MentorshipProgram> entityRowMapper() {
        return (rs, rowNum) -> {
            MentorshipProgram mentorshipProgram = new MentorshipProgram();
            mentorshipProgram.setId(rs.getInt("id"));
            mentorshipProgram.setName(rs.getString("name"));
            mentorshipProgram.setLocation(OfficeLocation.getFromString(rs.getString("location")));
            mentorshipProgram.setStartDate(rs.getDate("startDate"));
            mentorshipProgram.setEndDate(rs.getDate("endDate"));

            return mentorshipProgram;
        };
    }

    @Override
    public List<? extends MentorshipProgram> getAll() {
        List<? extends MentorshipProgram> query = jdbcEmbeddedH2Template.query(GET_ALL_PROGRAMS_QUERY, entityRowMapper());
        return query;
    }

    @Override
    public MentorshipProgram getById(Integer id) {
        Object[] params = {id};
        MentorshipProgram mentorshipProgram = jdbcEmbeddedH2Template.queryForObject(GET_PROGRAM_BY_ID_QUERY, params, entityRowMapper());
        return mentorshipProgram;
    }

    @Override
    public MentorshipProgram insertRecord(MentorshipProgram value) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcEmbeddedH2Template.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(INSERT_PROGRAM_QUERY, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, value.getName());
            preparedStatement.setString(2, value.getLocation().toString());
            preparedStatement.setDate(3, new Date(value.getStartDate().getTime()));
            preparedStatement.setDate(4, new Date(value.getEndDate().getTime()));
            return preparedStatement;
        }, generatedKeyHolder);

        value.setId(generatedKeyHolder.getKey().intValue());
        return value;
    }

    @Override
    public MentorshipProgram updateRecord(MentorshipProgram value) {
        jdbcEmbeddedH2Template.update(UPDATE_PROGRAM_QUERY,
                value.getName(),
                value.getLocation().toString(),
                value.getStartDate(),
                value.getEndDate(),
                value.getId());
        return value;
    }
}
