package com.bu.mapper;

import com.bu.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {

    List<Book> getBook();

    int getCount();

    int addBook(Book book);

    int update(Book book);

    Book getById(Integer id);

    int delete(Integer id);

    List<Book> getByCid(Integer classid);
}
