package com.benchem.studentservices.api.impl;

import com.benchem.microserviceshub.lang.MicroServiceException;
import com.benchem.microserviceshub.lang.SystemStateCode;
import com.benchem.studentservices.api.StudentManagement;
import com.benchem.studentservices.bean.Student;
import com.benchem.studentservices.lang.StudentServiceStateCode;
import org.springframework.stereotype.Service;

@Service
public class StudentManagementImpl implements StudentManagement{

    @Override
    public Student findStudent(String name) {
        if(name.equals("zhangsan")) throw new MicroServiceException(StudentServiceStateCode.NOT_FOUND);
        if(name.equals("lisi")) throw new NullPointerException("aaa...aaa");
        return new Student(name.toLowerCase(), "13750378000");
    }

    @Override
    public void createStudent(Student student) {
        if("lisi".equals(student.getName())) throw new MicroServiceException(StudentServiceStateCode.STUDENT_EXITES);
        if("full".equals(student.getName())) throw  new MicroServiceException(SystemStateCode.SYSTEM_ERROR, "系统磁盘已满");
    }
}
