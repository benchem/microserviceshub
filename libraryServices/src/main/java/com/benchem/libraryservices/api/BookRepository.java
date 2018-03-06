package com.benchem.libraryservices.api;

import com.benchem.libraryservices.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findByName(String bookName);

    List<Book> findByCode(String bookCode);
}
