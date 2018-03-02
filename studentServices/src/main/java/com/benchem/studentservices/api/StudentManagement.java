package com.benchem.studentservices.api;

import com.benchem.studentservices.bean.Student;

public interface StudentManagement {
    Student findStudent(String name);

    void createStudent(Student student);
}
