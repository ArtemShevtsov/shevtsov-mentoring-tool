package com.epam.mentorship.service;

import com.epam.mentorship.dao.MentorshipProgramDao;
import com.epam.mentorship.entity.MentorshipProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by aftor on 17.09.16.
 */
@Component
public class MentorshipProgramService implements IService<MentorshipProgram> {
    @Autowired
    private MentorshipProgramDao mentorshipProgramDao;


    @Override
    public List<? extends MentorshipProgram> getAll() {
        List<? extends MentorshipProgram> all = mentorshipProgramDao.getAll();
        return all;
    }

    @Override
    public MentorshipProgram getById(Integer id) {
        MentorshipProgram byId = mentorshipProgramDao.getById(id);
        return byId;
    }

    @Override
    public MentorshipProgram insertRecord(MentorshipProgram value) {
        MentorshipProgram mentorshipProgram = mentorshipProgramDao.insertRecord(value);
        return mentorshipProgram;
    }

    @Override
    public MentorshipProgram updateRecord(MentorshipProgram value) {
        MentorshipProgram mentorshipProgram = mentorshipProgramDao.updateRecord(value);
        return mentorshipProgram;
    }
}
