package com.epam.mentorship.dao;

import com.epam.mentorship.entity.Person;
import com.epam.mentorship.entity.PrimarySkill;
import com.epam.mentorship.entity.ProfessionalLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;


/**
 * Created by aftor on 10.09.16.
 */
@Component
public class PersonDao implements EntryDao<Person> {

    @Autowired
    private JdbcTemplate jdbcEmbeddedH2Template;

    private final String GET_PERSON_BY_ID_QUERY = "select * from persons where id = ?;";
    private final String GET_ALL_PERSONS_QUERY = "select * from persons;";
    private final String INSERT_PERSON_QUERY =
            "insert into persons(email, firstName, lastName, birthDay, managerFullName, professionalLevel, primarySkill) values (?,?,?,?,?,?,?);";
    private final String UPDATE_PERSON_QUERY =
            "update persons set email=?, firstName=?, lastName=?, birthDay=?, managerFullName=?, professionalLevel=?, primarySkill=? where id=?;";

    @Override
    public List<? extends Person> getAll() {
        return jdbcEmbeddedH2Template.query(GET_ALL_PERSONS_QUERY, entityRowMapper());
    }

    @Override
    public Person getById(Integer id) {
        Object[] params = {id};
        return jdbcEmbeddedH2Template.queryForObject(GET_PERSON_BY_ID_QUERY, params, entityRowMapper());
    }

    @Override
    public Person insertRecord(Person value) {
        jdbcEmbeddedH2Template.update(INSERT_PERSON_QUERY,
                value.getEmail(),
                value.getFirstName(),
                value.getLastName(),
                value.getBirthDate(),
                value.getManagerFullName(),
                value.getProfessionalLevel().toString(),
                value.getPrimarySkill().toString());
        return value;
    }

    @Override
    public Person updateRecord(Person value) {
        jdbcEmbeddedH2Template.update(UPDATE_PERSON_QUERY,
                value.getEmail(),
                value.getFirstName(),
                value.getLastName(),
                value.getBirthDate(),
                value.getManagerFullName(),
                value.getProfessionalLevel().toString(),
                value.getPrimarySkill().toString(),
                value.getId());
        return value;
    }

    @Override
    public RowMapper<? extends Person> entityRowMapper() {
        return (RowMapper<Person>) (rs, rowNum) -> {
            Person person = new Person(rs.getString("firstName"), rs.getString("lastName"));
            person.setId(rs.getInt("id"));
            person.setBirthDate(rs.getDate("birthDay"));
            person.setEmail(rs.getString("email"));
            person.setManagerFullName(rs.getString("managerFullName"));
            person.setProfessionalLevel(ProfessionalLevel.getFromString(rs.getString("professionalLevel")));
            person.setPrimarySkill(PrimarySkill.getFromString(rs.getString("primarySkill")));

            return person;
        };
    }
}
