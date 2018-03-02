package com.benchem.studentservices.controller;

import com.benchem.studentservices.api.StudentManagement;
import com.benchem.studentservices.bean.Student;
import com.benchem.studentservices.proxy.SchoolLibraryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentManagement studentService;

    @Autowired
    SchoolLibraryServices libraryServices;

    @RequestMapping("/get")
    public Student getStudent(@RequestParam String name){
        return studentService.findStudent(name);
    }

    @RequestMapping("/findBook")
    public boolean findBook(@RequestParam String name){
        Student std = studentService.findStudent(name);
        return libraryServices.checkStudent(std);
    }

    @RequestMapping("/findStudent")
    public Student goRound(@RequestParam String name){
        Student std = studentService.findStudent(name);
        return libraryServices.checkStudent1(std);
    }

    @RequestMapping("/sayhi")
    public void sayHi(@RequestParam String name){
        Student std = studentService.findStudent(name);
        libraryServices.checkStudent2(std);
    }

}
