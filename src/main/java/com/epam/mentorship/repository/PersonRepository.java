package com.epam.mentorship.repository;

import com.epam.mentorship.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aftor on 20.11.16.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
