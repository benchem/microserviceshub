package com.benchem.libraryservices.api;

import com.benchem.libraryservices.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findByName(String bookName);

    List<Book> findByNameOrCodeLikeOrderByCode(String name, String code);
}
