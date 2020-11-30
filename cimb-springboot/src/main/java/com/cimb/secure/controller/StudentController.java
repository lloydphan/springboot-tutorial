package com.cimb.secure.controller;

import com.cimb.secure.constant.SecurityConstant;
import com.cimb.secure.domain.Student;
import com.cimb.secure.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = SecurityConstant.CROSS_DOMAIN_URL)
public class StudentController implements IController<Student> {

    @Autowired
    private StudentService studentService;

    @Override
    public ResponseEntity<Page<Student>> findAll(Pageable pageable, String searchText) {
        return new ResponseEntity<>(studentService.findAll(pageable), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Page<Student>> findAll(Pageable pageable) {
        return new ResponseEntity<>(studentService.findAll(pageable), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Student> findById(Long id) {
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Student> save(Student student) {
        return new ResponseEntity<>(studentService.saveOrUpdate(student), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Student> update(Student student) {
        return new ResponseEntity<>(studentService.saveOrUpdate(student), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> deleteById(Long id) {
        return new ResponseEntity<>(studentService.deleteById(id), HttpStatus.OK);
    }
}
