package com.bu.service;

import com.bu.entity.Book;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BookService {

    PageInfo<Book> getBook();
    //List<Book> getBook();

    int addBook(Book book);

    int update(Book book);

    Book getById(Integer id);

    int delete(Integer id);

    List<Book> getByCid(Integer classid);
}
