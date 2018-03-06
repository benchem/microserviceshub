package com.benchem.libraryservices.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity(name = "t_bd_book")
public class Book {
    @Id
    @Column(name = "FROWID")
    private String RowId ;

    @Column(name = "FNAME")
    private String name;

    @Column(name = "FCODE")
    private String code;

    public Book() {
        RowId = UUID.randomUUID().toString();
    }

    public String getRowId() {
        return RowId;
    }

    public void setRowId(String rowId) {
        RowId = rowId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
