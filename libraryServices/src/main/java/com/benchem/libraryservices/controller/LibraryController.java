package com.benchem.libraryservices.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.benchem.libraryservices.api.BookRepository;
import com.benchem.libraryservices.bean.Book;
import com.benchem.libraryservices.bean.Student;
import com.benchem.libraryservices.lang.LibraryServiceStateCode;
import com.benchem.microserviceshub.annotation.MicroService;
import com.benchem.microserviceshub.lang.MicroServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    BookRepository bookRepository;

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
    public void checkStudent2(@RequestBody JSONObject student) {
        System.out.print(student.getString("name"));
    }

    @RequestMapping("/checkstudent3")
    public JSONObject checkStudent3(@RequestBody JSONObject student) {
        System.out.print(student.getString("name"));
        student.put("name", "22222");
        return student;
    }

    @RequestMapping("/list")
    public List<Book> getList(@RequestParam(required = false) String keyword){
        return bookRepository.findByNameOrCodeLikeOrderByCode(keyword, keyword);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Book createBook(@RequestBody JSONObject bookInfo){
        Book book = new Book();
        book.setName(bookInfo.getString("name"));
        book.setCode(bookInfo.getString("code"));
        bookRepository.save(book);
        return book;
    }
}
