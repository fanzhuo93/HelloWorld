package com.kgc.demo.controller;

import com.kgc.demo.dto.Student;
import com.kgc.demo.service.StudentService;
import com.kgc.demo.utils.ReturnResult;
import com.kgc.demo.utils.ReturnResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "query")
    public ReturnResult<Student> queryStudent() {
        return ReturnResultUtils.returnSuccess(studentService.queryStudent());
    }

}
