package com.epam.mentorship.dao;

import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * Created by aftor on 10.09.16.
 */
public interface EntryDao<T> {
    RowMapper<? extends T> entityRowMapper();
    public List<? extends T> getAll();
    public T getById(Integer id);
    public T insertRecord(T value);
}
