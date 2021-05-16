package com.example.graphql.book;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author gaojianqiang
 * @date 2021-05-16
 */
@Service
public class BookQueryResolver implements GraphQLQueryResolver {

    @Resource
    private BookService bookService;

    public Book getBookById(int id) {
        return bookService.getBookById(id);
    }
}
