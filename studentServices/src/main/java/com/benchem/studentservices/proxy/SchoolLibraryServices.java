package com.benchem.studentservices.proxy;

import com.benchem.microserviceshub.annotation.MicroService;
import com.benchem.microserviceshub.bean.RequestType;
import com.benchem.microserviceshub.sdk.MicroServicesDomains;
import com.benchem.studentservices.bean.Student;
import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Component
public class SchoolLibraryServices {

    @MicroService(domain= MicroServicesDomains.LibrarySvr, path = "/library/checkstudent", type = RequestType.POST)
    public boolean checkStudent(Student student) {
        throw new NotImplementedException();
    }

    @MicroService(domain= MicroServicesDomains.LibrarySvr, path = "/library/checkstudent1", type = RequestType.POST)
    public Student checkStudent1(Student student) {
        throw new NotImplementedException();
    }

    @MicroService(domain= MicroServicesDomains.LibrarySvr, path = "/library/checkstudent2", type = RequestType.POST)
    public void checkStudent2(Student student) {
        throw new NotImplementedException();
    }
}
