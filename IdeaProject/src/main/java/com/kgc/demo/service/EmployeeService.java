package com.kgc.demo.service;

import com.kgc.demo.dto.EmployeeExample;
import com.kgc.demo.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    public int delEmployee(Integer id) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andIdIn(Arrays.asList(id));
        int del = employeeMapper.deleteByExample(employeeExample);
        return del;
    }
}
