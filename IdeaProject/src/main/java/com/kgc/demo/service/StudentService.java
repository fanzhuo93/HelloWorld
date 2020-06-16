package com.kgc.demo.service;

import com.kgc.demo.dto.Student;
import com.kgc.demo.dto.StudentExample;
import com.kgc.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public Student queryStudent() {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andIdEqualTo(1);
        List<Student> studentList = studentMapper.selectByExample(studentExample);
        return studentList.get(0);
    }
}
