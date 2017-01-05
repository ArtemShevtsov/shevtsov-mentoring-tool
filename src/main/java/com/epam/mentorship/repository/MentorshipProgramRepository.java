package com.epam.mentorship.repository;

import com.epam.mentorship.entity.MentorshipProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aftor on 26.11.16.
 */
@Repository
public interface MentorshipProgramRepository extends JpaRepository<MentorshipProgram, Integer> {
}
