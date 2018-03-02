package com.benchem.studentservices.controller;

import com.benchem.studentservices.api.StudentManagement;
import com.benchem.studentservices.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentManagement studentService;

    @RequestMapping("/get")
    public Student getStudent(@RequestParam String name){
        return studentService.findStudent(name);
    }
}
