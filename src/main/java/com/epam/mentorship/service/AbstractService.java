package com.epam.mentorship.service;

import java.util.List;

/**
 * Created by aftor on 11.09.16.
 */
public interface AbstractService<T> {
    public List<? extends T> getAll();
    public T getById(Integer id);
    public T insertRecord(T value);
    public T updateRecord(T value);
}