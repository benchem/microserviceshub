package com.benchem.libraryservices.controller;

import com.benchem.libraryservices.bean.Student;
import com.benchem.libraryservices.lang.LibraryServiceStateCode;
import com.benchem.microserviceshub.annotation.MicroService;
import com.benchem.microserviceshub.lang.MicroServiceException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @RequestMapping("/checkstudent")
    public boolean checkStudent(@RequestBody Student student) {
        if ("jj".equals(student.getName())) return true;
        throw new MicroServiceException(LibraryServiceStateCode.CAN_NOT_READ);
    }

    @RequestMapping("/checkstudent1")
    public Student checkStudent1(@RequestBody Student student) {
        return student;
    }

    @RequestMapping("/checkstudent2")
    public void checkStudent2(@RequestBody Student student) {

    }
}
