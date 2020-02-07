package com.bu.service.impl;

import com.bu.entity.Book;
import com.bu.mapper.BookMapper;
import com.bu.service.BookService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public PageInfo<Book> getBook() {
        List<Book> bookList = bookMapper.getBook();
        return new PageInfo<Book>(bookList);
    }

    /*@Override
    public List<Book> getBook() {
        List<Book> bookList = bookMapper.getBook();
        return bookList;
    }*/

    @Override
    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int update(Book book) {
        return bookMapper.update(book);
    }

    @Override
    public Book getById(Integer id) {
        return bookMapper.getById(id);
    }

    @Override
    public int delete(Integer id) {
        return bookMapper.delete(id);
    }


    @Override
    public List<Book> getByCid(Integer classid) {
        return bookMapper.getByCid(classid);
    }
}
