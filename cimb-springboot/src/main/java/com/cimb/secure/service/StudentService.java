package com.cimb.secure.service;

import com.cimb.secure.domain.Student;
import com.cimb.secure.repository.StudentRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IService<Student> {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student saveOrUpdate(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Boolean deleteById(Long id) {
        boolean isDelete = false;
        try {
            studentRepository.deleteById(id);
            isDelete = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isDelete;
    }
}
