package com.epam.mentorship.service;

import com.epam.mentorship.dao.MentorshipProgramDao;
import com.epam.mentorship.entity.MentorshipProgram;
import com.epam.mentorship.repository.MentorshipProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aftor on 17.09.16.
 */
@Service
public class MentorshipProgramService implements IService<MentorshipProgram> {
    @Autowired
    private MentorshipProgramDao mentorshipProgramDao;

    @Autowired
    private MentorshipProgramRepository mpRepository;


    @Override
    public List<? extends MentorshipProgram> getAll() {
        return mpRepository.findAll();
//        List<? extends MentorshipProgram> all = mentorshipProgramDao.getAll();
//        return all;
    }

    @Override
    public MentorshipProgram getById(Integer id) {
//        MentorshipProgram byId = mentorshipProgramDao.getById(id);
//        return byId;
        return mpRepository.findOne(id);
    }

    @Override
    public MentorshipProgram insertRecord(MentorshipProgram value) {
//        MentorshipProgram mentorshipProgram = mentorshipProgramDao.insertRecord(value);
//        return mentorshipProgram;
        return mpRepository.save(value);
    }

    @Override
    public MentorshipProgram updateRecord(MentorshipProgram value) {
//        MentorshipProgram mentorshipProgram = mentorshipProgramDao.updateRecord(value);
//        return mentorshipProgram;
        return mpRepository.save(value);
    }
}
